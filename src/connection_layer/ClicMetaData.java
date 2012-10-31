package connection_layer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;



class ClicMetaData {
	
	private static final String SUBJECT = "Subject";
	private static final String AUTHOR = "Author";
	private static final String LICENCE = "License";
	private static final String THEME = "Theme";
	private static final String LANGUAGE = "Language";
	private static final String KEYWORDS = "Keywords";
	private static final String ICON = "urlIcon";
	private static final String SCREENSHOT = "urlScreenShot";
	private static final String CLIC = "urlClic";
	
	private String Subject;
	private String Author;
	private String License;
	private int Theme;
	private String Language;
	private String[] Keywords;
	private File Icon;
	private File ScreenShot;
	private File Clic;
	
	public static void main(String[] args) throws URISyntaxException, ParserConfigurationException, SAXException, IOException{
		URI uri = new URI("http://dl.dropbox.com/u/14187788/clic7.xmlclic");
		ClicMetaData clic = new ClicMetaData(uri);
	}
	
	public ClicMetaData(URI xmlUri) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document clicMetaData = builder.parse(xmlUri.toString());
		
		Node n = clicMetaData.getElementsByTagName("clicDescriptor").item(0);
		System.out.println("fin");
	}
	
	private ClicMetaData(String subject, String author, String license,
			int theme, String language, String[] keywords, URL iconUrl,
			URL screenShotUrl, File clic) throws URISyntaxException {
		Subject = subject;
		Author = author;
		License = license;
		Theme = theme;
		Language = language;
		Keywords = keywords;
		Icon = new File(iconUrl.toURI());
		ScreenShot = new File(screenShotUrl.toURI());
		Clic = clic;
	}

	public String getSubject() {
		return Subject;
	}

	public String getAuthor() {
		return Author;
	}

	public String getLicense() {
		return License;
	}

	public int getTheme() {
		return Theme;
	}

	public String getLanguage() {
		return Language;
	}

	public String[] getKeywords() {
		return Keywords;
	}

	public File getIcon() {
		return Icon;
	}

	public File getScreenShot() {
		return ScreenShot;
	}

	public File getClic() {
		return Clic;
	}
	
	
}
