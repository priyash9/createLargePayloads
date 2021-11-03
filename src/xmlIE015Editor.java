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
        Element sealNumTag =  (Element)root.getElementsByTagName("SEAINFSLI").item(0);
        int j=1;

        Collection<Server> servers = new ArrayList<Server>();
        servers.add(new Server());

        for (Server server : servers) {
            // server elements
            for(int i=1;i<=9999;i++)
            {
                Element newServer = document.createElement("SEAIDSID");
                Element name = document.createElement("SeaIdeSID1");
                name.appendChild(document.createTextNode(server.getSeaIdeSI11(i)));

                newServer.appendChild(name);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(name);

                Element port = document.createElement("SeaIdeSID1LNG");
                //port.appendChild(document.createTextNode("\n"));
                port.appendChild(document.createTextNode(server.getSeaIdeSI11LNG()));
                newServer.appendChild(port);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(port);

                sealNumTag.appendChild(newServer);
                sealNumTag.appendChild(document.createTextNode("\n"));
            }
        }

        Collection<Server> goodsServers = new ArrayList<Server>();
        goodsServers.add(new Server());

        for (Server server : goodsServers) {
            // server elements
            for(int i=1;i<=999;i++)
            {
                int x=0;
                Element newServer = document.createElement("GOOITEGDS");
                //newServer.appendChild(document.createTextNode("\n"));

                Element item = document.createElement("IteNumGDS7");
                item.appendChild(document.createTextNode(server.getItemNum(i)));

                newServer.appendChild(item);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(item);

                Element goodsDesc = document.createElement("GooDesGDS23");
                //port.appendChild(document.createTextNode("\n"));
                goodsDesc.appendChild(document.createTextNode(server.getGoodsDesc(i)));
                newServer.appendChild(goodsDesc);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(goodsDesc);

                Element goodsDescLang = document.createElement("GooDesGDS23LNG");
                //port.appendChild(document.createTextNode("\n"));
                goodsDescLang.appendChild(document.createTextNode(server.getGoodsDescLNG()));
                newServer.appendChild(goodsDescLang);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(goodsDescLang);

                Element goodsGrossMass = document.createElement("GroMasGDS46");
                //port.appendChild(document.createTextNode("\n"));
                goodsGrossMass.appendChild(document.createTextNode(server.getGrossMass()));
                newServer.appendChild(goodsGrossMass);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(goodsGrossMass);

                Element goodsNetMass = document.createElement("NetMasGDS48");
                //port.appendChild(document.createTextNode("\n"));
                goodsNetMass.appendChild(document.createTextNode(server.getNetMass()));
                newServer.appendChild(goodsNetMass);
                newServer.appendChild(document.createTextNode("\n"));
                newServer.appendChild(goodsNetMass);
                newServer.appendChild(document.createTextNode("\n"));

                //Packages Documents
                while(x<5)
                {

                    Element packageDoc = document.createElement("PRODOCDC2");
                    newServer.appendChild(packageDoc);
                    newServer.appendChild(document.createTextNode("\n"));

                    Element docType = document.createElement("DocTypDC21");
                    docType.appendChild(document.createTextNode(server.getDocType()));

                    packageDoc.appendChild(docType);
                    packageDoc.appendChild(document.createTextNode("\n"));
                    packageDoc.appendChild(docType);

                    Element docRef = document.createElement("DocRefDC23");
                    docRef.appendChild(document.createTextNode(server.getDocRef()));

                    packageDoc.appendChild(docRef);
                    packageDoc.appendChild(document.createTextNode("\n"));
                    packageDoc.appendChild(docRef);

                    Element docRefLNG = document.createElement("DocRefDCLNG");
                    docRefLNG.appendChild(document.createTextNode(server.getDocRefLNG()));

                    packageDoc.appendChild(docRefLNG);
                    packageDoc.appendChild(document.createTextNode("\n"));
                    packageDoc.appendChild(docRefLNG);

                    Element docComOfInfDC25 = document.createElement("ComOfInfDC25");
                    docComOfInfDC25.appendChild(document.createTextNode(server.getComOfInfDC25()));

                    packageDoc.appendChild(docComOfInfDC25);
                    packageDoc.appendChild(document.createTextNode("\n"));
                    packageDoc.appendChild(docComOfInfDC25);

                    Element docComOfInfDC25LNG = document.createElement("ComOfInfDC25LNG");
                    docComOfInfDC25LNG.appendChild(document.createTextNode(server.getComOfInfDC25LNG()));

                    packageDoc.appendChild(docComOfInfDC25LNG);
                    packageDoc.appendChild(document.createTextNode("\n"));
                    packageDoc.appendChild(docComOfInfDC25LNG);
                    x++;
                }

                while(j==1)
                {
                    //Special Mentions
                    Element specialMentions = document.createElement("SPEMENMT2");
                    newServer.appendChild(specialMentions);
                    newServer.appendChild(document.createTextNode("\n"));

                    Element addInfo = document.createElement("AddInfMT21");
                    addInfo.appendChild(document.createTextNode(server.getSpecialMentions()));

                    specialMentions.appendChild(addInfo);
                    specialMentions.appendChild(document.createTextNode("\n"));
                    specialMentions.appendChild(addInfo);

                    Element addInfoCod = document.createElement("AddInfCodMT23");
                    addInfoCod.appendChild(document.createTextNode(server.getSpecialMentionsCode()));

                    specialMentions.appendChild(addInfoCod);
                    specialMentions.appendChild(document.createTextNode("\n"));
                    specialMentions.appendChild(addInfoCod);

                    specialMentions.appendChild(document.createTextNode("\n"));
                    j--;
                }
                //Packages

                Element packages = document.createElement("PACGS2");
                newServer.appendChild(packages);
                newServer.appendChild(document.createTextNode("\n"));

                Element noOfPackages = document.createElement("MarNumOfPacGS21");
                noOfPackages.appendChild(document.createTextNode(server.getMarNumOfPac(i)));

                packages.appendChild(noOfPackages);
                packages.appendChild(document.createTextNode("\n"));
                packages.appendChild(noOfPackages);

                Element noOfPackagesLNG = document.createElement("MarNumOfPacGS21LNG");
                noOfPackagesLNG.appendChild(document.createTextNode(server.getNumofPackagesLNG()));

                packages.appendChild(noOfPackagesLNG);
                packages.appendChild(document.createTextNode("\n"));
                packages.appendChild(noOfPackagesLNG);

                Element kindOfPackages = document.createElement("KinOfPacGS23");
                kindOfPackages.appendChild(document.createTextNode(server.getKindofPackages()));

                packages.appendChild(kindOfPackages);
                packages.appendChild(document.createTextNode("\n"));
                packages.appendChild(kindOfPackages);

                Element noOfPack = document.createElement("NumOfPacGS24");
                noOfPack.appendChild(document.createTextNode(server.getNoofPackages()));

                packages.appendChild(noOfPack);
                packages.appendChild(document.createTextNode("\n"));
                packages.appendChild(noOfPack);

                packages.appendChild(document.createTextNode("\n"));

                root.appendChild(newServer);
                root.appendChild(document.createTextNode("\n"));
            }
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();

        StreamResult result = new StreamResult("IE015.xml");
        //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        //transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC,"yes");
        //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);


    }


    public static class Server {
        public String getSeaIdeSI11(int i) { return "NCTS00"+i+""; }
        public String getSeaIdeSI11LNG() { return "EN"; }
        public String getItemNum(int i) { return ""+i+""; }
        public String getGoodsDesc(int i) { return "PNL 15.6 FHD AG SVA 45% 250n N PANEL LCD 13.3 W BEZEL FHD 400 PANEL :LCD 13.3 W BEZEL FHD 400\n"
                + "PNL LCD HU 15.6 FHD AG PVCY NS "+i+""; }
        public String getGoodsDescLNG() { return "EN"; }
        public String getGrossMass() { return "1000"; }
        public String getNetMass() { return "950"; }

        //Packages Documents
        public String getDocType() { return "325"; }
        public String getDocRef() { return "EU_EXIT"; }
        public String getDocRefLNG() { return "EN"; }
        public String getComOfInfDC25() { return "Ref."; }
        public String getComOfInfDC25LNG() { return "EN"; }

        //Special mentions
        public String getSpecialMentions() { return "20GB0000010000GX1"; }
        public String getSpecialMentionsCode() { return "CAL"; }

        //Packages
        public String getMarNumOfPac(int i) { return "Ref#"+i+""; }
        public String getNumofPackagesLNG() { return "EN"; }
        public String getKindofPackages() { return "BX"; }
        public String getNoofPackages() { return "10"; }
    }

}
