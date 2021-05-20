import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
public class xmlIE015Editor {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("IE015.xml");
        Element root = document.getDocumentElement();
        int sealsToBeAdded = 10;
        Element sealNumTag =  (Element)root.getElementsByTagName("SEAINFSLI").item(0);
        Element sealNum = document.createElement("SeaNumSF12");
        sealNum.appendChild(document.createTextNode(Integer.toString(sealsToBeAdded)));
        sealNumTag.appendChild(sealNum);

        Collection<Server> servers = new ArrayList<Server>();
        servers.add(new Server());

        for (Server server : servers) {
            // server elements
        	for(int i=1;i<=sealsToBeAdded;i++)
        	{
	            Element newServer = document.createElement("SEAIDSID");
	            newServer.appendChild(document.createTextNode("\n"));
	
	            Element name = document.createElement("SeaIdeSID1");
	            name.appendChild(document.createTextNode(server.getSeaIdeSI11(i)));
	            
	            newServer.appendChild(name);
	            newServer.appendChild(document.createTextNode("\n"));
	
	            sealNumTag.appendChild(newServer);
	            sealNumTag.appendChild(document.createTextNode("\n"));
        	}
        }
        DOMSource source = new DOMSource(document);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
      
        StreamResult result = new StreamResult("IE015.xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);
	}
	
	public static class Server {
        public String getSeaIdeSI11(int i) { return "NCTS00"+i+""; }
        //public String getSeaIdeSI11LNG() { return "EN"; }
    }

}
