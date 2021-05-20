import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.*;

public class xmlIE007Editor {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("IE007.xml");
        Element root = document.getDocumentElement();
        int sealsToBeAdded = 10;
        Element sealNumTag =  (Element)root.getElementsByTagName("SEAINFSF1").item(0);

        Element sealNum = document.createElement("SeaNumSF12");
        sealNum.appendChild(document.createTextNode(Integer.toString(sealsToBeAdded)));
        sealNumTag.appendChild(sealNum);

        Collection<Server> servers = new ArrayList<Server>();
        servers.add(new Server());

        for (Server server : servers) {
            // server elements
            for(int i=1;i<=sealsToBeAdded;i++)
            {
                Element newServer = document.createElement("SEAIDSI1");
                newServer.appendChild(document.createTextNode("\n"));

                Element name = document.createElement("SeaIdeSI11");
                name.appendChild(document.createTextNode(server.getSeaIdeSI11(i)));

                newServer.appendChild(name);
                newServer.appendChild(document.createTextNode("\n"));

                Element port = document.createElement("SeaIdeSI11LNG");
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

        StreamResult result = new StreamResult("IE007.xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);
        //PrettyPrinter.prettyPrintXml();

    }
    public static class Server {
        public String getSeaIdeSI11(int i) { return "seal_"+i+""; }
        public String getSeaIdeSI11LNG() { return "EN"; }
    }

}
