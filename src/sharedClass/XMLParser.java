package sharedClass;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
	
	private NodeList nList;
	public XMLParser(String fileName){
		try {
			File xmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			
			nList = doc.getElementsByTagName("item");
			retrieveInfo();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public NodeList getNodeList(){
		return nList;
	}
	
	public void setNodeList(NodeList nList){
		this.nList = nList;
	}
	public void retrieveInfo(){
		for(int i = 0 ; i < nList.getLength();i++){
			
			Node node = nList.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) node;
				System.out.print(element.getAttribute("name") +  "   ");
				System.out.println(element.getElementsByTagName("Amount").item(0).getTextContent());
			}
		}		
	}
	
	
}
