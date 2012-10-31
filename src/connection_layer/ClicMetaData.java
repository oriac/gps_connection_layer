package connection_layer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
	
	private String subject;
	private String author;
	private String license;
	private int theme;
	private String language;
	private String[] keywords;
	private File icon;
	private File screenShot;
	private File clic;
	
	public static void main(String[] args) throws URISyntaxException, ParserConfigurationException, SAXException, IOException{
		URI uri = new URI("http://dl.dropbox.com/u/14187788/clic7.xmlclic");
		ClicMetaData clic = new ClicMetaData(uri);
	}
	
	public ClicMetaData(URI xmlUri) throws ParserConfigurationException, SAXException, IOException, DOMException, URISyntaxException{
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document clicMetaData = builder.parse(xmlUri.toString());
		
		//String attributes
		subject = clicMetaData.getElementsByTagName(SUBJECT).item(0).getFirstChild().getNodeValue();
		author = clicMetaData.getElementsByTagName(AUTHOR).item(0).getFirstChild().getNodeValue();
		license = clicMetaData.getElementsByTagName(LICENCE).item(0).getFirstChild().getNodeValue();
		theme = Integer.parseInt(clicMetaData.getElementsByTagName(THEME).item(0).getFirstChild().getNodeValue());
		language = clicMetaData.getElementsByTagName(LANGUAGE).item(0).getFirstChild().getNodeValue();
		//File attributes, doesn't work, urls are down
		//icon = new File(new URI(clicMetaData.getElementsByTagName(ICON).item(0).getFirstChild().getNodeValue()));
		//screenShot = new File(new URI(clicMetaData.getElementsByTagName(SCREENSHOT).item(0).getFirstChild().getNodeValue()));
		
		/*
		keywords = clicMetaData.getElementsByTagName(KEYWORDS).item(0).getFirstChild().getNodeValue();
		clic = clicMetaData.getElementsByTagName(CLIC).item(0).getFirstChild().getNodeValue();*/
		
		System.out.println("fin");
	}

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

	public File getIcon() {
		return icon;
	}

	public File getScreenShot() {
		return screenShot;
	}

	public File getClic() {
		return clic;
	}

	
}
