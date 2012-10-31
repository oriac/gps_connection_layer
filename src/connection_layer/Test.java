package connection_layer;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class Test {
	public static void main (String[] args) throws DOMException, ParserConfigurationException, SAXException, IOException{
		URL xmlURL = new URL("http://dl.dropbox.com/u/14187788/clic7.xmlclic");
		ClicMetaData c = new ClicMetaData(xmlURL);
		System.out.println(c.getIcon().length);
	}
}
