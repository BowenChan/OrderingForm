package sharedClass;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
	
	
	public XMLParser(String fileName){
		try {
			File xmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			NodeList nList = doc.getElementsByTagName("item");
			for(int i = 0 ; i < nList.getLength();i++){
				
				Node node = nList.item(i);
				
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					System.out.print(element.getAttribute("name") +  "   ");
					System.out.println(element.getElementsByTagName("Amount").item(0).getTextContent());
				}
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public NodeList retrieveInfo(Document doc){
		return doc.getElementsByTagName("item");
	}
}
