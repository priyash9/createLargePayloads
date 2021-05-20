import java.io.StringWriter;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;


import javax.xml.parsers.*;
public class xmlIE044Editor {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("IE044.xml");
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
	            //name.appendChild(document.createTextNode("\n"));
	            name.appendChild(document.createTextNode(server.getSeaIdeSI11(i)));
	            
	            newServer.appendChild(name);
	            newServer.appendChild(document.createTextNode("\n"));

	            Element port = document.createElement("SeaIdeSID1LNG");
	           // port.appendChild(document.createTextNode("\n"));
	            port.appendChild(document.createTextNode(server.getSeaIdeSI11LNG()));
	            newServer.appendChild(port);
	            newServer.appendChild(document.createTextNode("\n"));
	            
                sealNumTag.appendChild(newServer);
	            sealNumTag.appendChild(document.createTextNode("\n"));

        	}
        }

        DOMSource source = new DOMSource(document);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer=new StringWriter();
      
        StreamResult result = new StreamResult("IE044.xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        writer.toString().replace("\\s+\\n","\\n");

        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);
        

	}
	
	public static class Server {
        public String getSeaIdeSI11(int i) { return "New seal"+i+" header"; }
        public String getSeaIdeSI11LNG() { return "EN"; }
    }

}
