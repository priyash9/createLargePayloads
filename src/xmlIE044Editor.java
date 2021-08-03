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
        Element sealNumTag =  (Element)root.getElementsByTagName("SEAINFSLI").item(0);



        Collection<Server> servers = new ArrayList<Server>();
        servers.add(new Server());

        for (Server server : servers) {
            // server elements
            for(int i=1;i<=9999;i++)
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
        //Goods Items

        Collection<Server> goodsServers = new ArrayList<Server>();
        goodsServers.add(new Server());

        for (Server server : servers) {
            // server elements
            for(int i=1;i<=9999;i++)
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
                //RESOFCONROC
                Element resOfCtrl = document.createElement("RESOFCONROC");
                newServer.appendChild(resOfCtrl);
                newServer.appendChild(document.createTextNode("\n"));

                Element conIndROC1 = document.createElement("ConIndROC1");
                conIndROC1.appendChild(document.createTextNode(server.getConIndROC1()));

                resOfCtrl.appendChild(conIndROC1);
                resOfCtrl.appendChild(document.createTextNode("\n"));
                resOfCtrl.appendChild(conIndROC1);

                Element resOfCtrl1 = document.createElement("RESOFCONROC");
                newServer.appendChild(resOfCtrl1);
                newServer.appendChild(document.createTextNode("\n"));

                Element desROC2 = document.createElement("DesROC2");
                desROC2.appendChild(document.createTextNode(server.getDesROC2(i)));

                resOfCtrl1.appendChild(desROC2);
                resOfCtrl1.appendChild(document.createTextNode("\n"));
                resOfCtrl1.appendChild(desROC2);


                Element desROC2LNG = document.createElement("DesROC2LNG");
                desROC2LNG.appendChild(document.createTextNode(server.getDesROC2LNG()));

                resOfCtrl1.appendChild(desROC2LNG);
                resOfCtrl1.appendChild(document.createTextNode("\n"));
                resOfCtrl1.appendChild(desROC2LNG);


                Element desconIndROC1 = document.createElement("ConIndROC1");
                desconIndROC1.appendChild(document.createTextNode(server.getConIndROC2()));

                resOfCtrl1.appendChild(desconIndROC1);
                resOfCtrl1.appendChild(document.createTextNode("\n"));
                resOfCtrl1.appendChild(desconIndROC1);

                resOfCtrl.appendChild(document.createTextNode("\n"));

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
        StringWriter writer=new StringWriter();

        StreamResult result = new StreamResult("IE044.xml");
        //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        writer.toString().replace("\\s+\\n","\\n");

        //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);


    }

    public static class Server {
        public String getSeaIdeSI11(int i) { return "New seal"+i+" header"; }
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

        //RESOFCONROC
        public String getConIndROC1() { return "DI"; }
        public String getDesROC2(int i) { return "Item"+i+" Other things to report. updated Gross mass (kg) and Net mass (kg)"; }
        public String getDesROC2LNG() { return "EN"; }
        public String getConIndROC2() { return "OT"; }

        //Packages
        public String getMarNumOfPac(int i) { return "Ref#"+i+""; }
        public String getNumofPackagesLNG() { return "EN"; }
        public String getKindofPackages() { return "BX"; }
        public String getNoofPackages() { return "10"; }
    }

}
