package connection_layer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The ClicMetaData class represents a Clic with all it's metadata
 * as it's stored on the server.  
 * @author Albert Cabré Juan
 */
class ClicMetaData {
	
	//definition for the xml tags
	private static final String SUBJECT = "Subject";
	private static final String AUTHOR = "Author";
	private static final String LICENCE = "License";
	private static final String THEME = "Theme";
	private static final String LANGUAGE = "Language";
	private static final String KEYWORD = "keyWord";
	private static final String ICON = "urlIcon";
	private static final String SCREENSHOT = "urlScreenshot";
	private static final String CLIC = "urlClic";
	
	private String subject;
	private String author;
	private String license;
	private int theme;
	private String language;
	private String[] keywords;
	private byte[] icon;
	private byte[] screenShot;
	private byte[] clic;
	
	/**
	 * Creates an instance of a ClicMetaData based on a XML
	 * representation of the Clic and it's metadata.
	 * @param xmlURL URL for the XML
	 * @throws ParserConfigurationException Should never be thrown.
	 * @throws SAXException The file reached is not valid XML
	 * @throws IOException Thrown when connectivity problems appear.
	 * @throws DOMException The XML format was unexpected (ex:missing attributes)
	 * @throws UnknownHostException Unchecked exception, it's thrown
	 *	   	   when there's no Internet at all (DNS servers unreachable).
	 */
	public ClicMetaData(URL xmlURL) throws ParserConfigurationException, SAXException, IOException, DOMException{
		
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document clicMetaData = builder.parse(new ByteArrayInputStream(Downloader.downloadFile(xmlURL)));
		
		//String attributes
		subject = clicMetaData.getElementsByTagName(SUBJECT).item(0).getFirstChild().getNodeValue();
		author = clicMetaData.getElementsByTagName(AUTHOR).item(0).getFirstChild().getNodeValue();
		license = clicMetaData.getElementsByTagName(LICENCE).item(0).getFirstChild().getNodeValue();
		theme = Integer.parseInt(clicMetaData.getElementsByTagName(THEME).item(0).getFirstChild().getNodeValue());
		language = clicMetaData.getElementsByTagName(LANGUAGE).item(0).getFirstChild().getNodeValue();
		
		//File attributes, don't work at moment, urls on the xmlclic are down
		icon = Downloader.downloadFile(new URL(clicMetaData.getElementsByTagName(ICON).item(0).getFirstChild().getNodeValue()));
		screenShot = Downloader.downloadFile(new URL(clicMetaData.getElementsByTagName(SCREENSHOT).item(0).getFirstChild().getNodeValue()));
		
		//keywords list
		NodeList nodes = clicMetaData.getElementsByTagName(KEYWORD);
		keywords = new String[nodes.getLength()];
		
		for (int i = 0; i<keywords.length ; i++){
			keywords[i]=nodes.item(i).getFirstChild().getNodeValue();
		}
	
		// the click itself, doesn't work either, the sushitos copy is private (needs login) 
		//clic = clicMetaData.getElementsByTagName(CLIC).item(0).getFirstChild().getNodeValue();	
		
	}

	/**
	 * 
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	public String getAuthor() {
		return author;
	}

	public String getLicense() {
		return license;
	}

	public int getTheme() {
		return theme;
	}

	public String getLanguage() {
		return language;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public byte[] getIcon() {
		return icon;
	}

	public byte[] getScreenShot() {
		return screenShot;
	}

	public byte[] getClic() {
		return clic;
	}

	
}
