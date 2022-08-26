import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class ApplicationRunner {
    public static void main(String...args) throws IOException, ParserConfigurationException, SAXException {
        SoapService service = new SoapService();
        //service.sendSoap(1, 2);
        String xml = "\t\t\t\t\t\t<item xsi:type=\"ns1:service_Server_Multimedia_Entity_Multimedia\">\n" +
                "\t\t\t\t\t\t\t<Id xsi:type=\"xsd:int\">14541</Id>\n" +
                "\t\t\t\t\t\t\t<PictureType xsi:type=\"xsd:string\">image</PictureType>\n" +
                "\t\t\t\t\t\t\t<Filename xsi:type=\"xsd:string\">Zawory_i_elektrozawory_pneumatyczne_VCML326M8.tif</Filename>\n" +
                "\t\t\t\t\t\t\t<Extension xsi:type=\"xsd:string\">jpg</Extension>\n" +
                "\t\t\t\t\t\t\t<Description xsi:type=\"xsd:string\">VCML32018</Description>\n" +
                "\t\t\t\t\t\t\t<Hide xsi:type=\"xsd:boolean\">false</Hide>\n" +
                "\t\t\t\t\t\t\t<ModificationDate xsi:type=\"xsd:string\">2017-05-17 14:42:46</ModificationDate>\n" +
                "\t\t\t\t\t\t\t<Hash xsi:type=\"xsd:string\">130aff71fa5fae70aef7b3f0b7beae2356de45350ebc734245f78fe80c481d43</Hash>\n" +
                "\t\t\t\t\t\t\t<Url xsi:type=\"xsd:string\">https://www.qa2.pneaws.unitymsp.it/public/files/productimages/thumb150x150/Zawory_i_elektrozawory_pneumatyczne_VCML326M8.tif.jpg</Url>\n" +
                "\t\t\t\t\t\t\t<UrlNative xsi:type=\"xsd:string\">https://www.qa2.pneaws.unitymsp.it/public/files/productimages/Zawory_i_elektrozawory_pneumatyczne_VCML326M8.tif.jpg</UrlNative>\n" +
                "\t\t\t\t\t\t\t<Items SOAP-ENC:arrayType=\"ns1:service_Server_Multimedia_Entity_ObjectPhoto[5]\" xsi:type=\"ns1:ArrayOfservice_Server_Multimedia_Entity_ObjectPhoto\">\n" +
                "\t\t\t\t\t\t\t\t<item xsi:type=\"ns1:service_Server_Multimedia_Entity_ObjectPhoto\">\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectType xsi:type=\"xsd:int\">1</ObjectType>\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectId xsi:type=\"xsd:int\">94046</ObjectId>\n" +
                "\t\t\t\t\t\t\t\t\t<Order xsi:type=\"xsd:int\">2520</Order>\n" +
                "\t\t\t\t\t\t\t\t\t<IsRemoved xsi:type=\"xsd:boolean\">true</IsRemoved>\n" +
                "\t\t\t\t\t\t\t\t\t<ModificationDate xsi:type=\"xsd:string\">2022-01-04 11:31:44.295518</ModificationDate>\n" +
                "\t\t\t\t\t\t\t\t</item>\n" +
                "\t\t\t\t\t\t\t\t<item xsi:type=\"ns1:service_Server_Multimedia_Entity_ObjectPhoto\">\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectType xsi:type=\"xsd:int\">1</ObjectType>\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectId xsi:type=\"xsd:int\">8193</ObjectId>\n" +
                "\t\t\t\t\t\t\t\t\t<Order xsi:type=\"xsd:int\">2520</Order>\n" +
                "\t\t\t\t\t\t\t\t\t<IsRemoved xsi:type=\"xsd:boolean\">true</IsRemoved>\n" +
                "\t\t\t\t\t\t\t\t\t<ModificationDate xsi:type=\"xsd:string\">2022-01-12 12:05:06.106599</ModificationDate>\n" +
                "\t\t\t\t\t\t\t\t</item>\n" +
                "\t\t\t\t\t\t\t\t<item xsi:type=\"ns1:service_Server_Multimedia_Entity_ObjectPhoto\">\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectType xsi:type=\"xsd:int\">1</ObjectType>\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectId xsi:type=\"xsd:int\">94046</ObjectId>\n" +
                "\t\t\t\t\t\t\t\t\t<Order xsi:type=\"xsd:int\">2520</Order>\n" +
                "\t\t\t\t\t\t\t\t\t<IsRemoved xsi:type=\"xsd:boolean\">false</IsRemoved>\n" +
                "\t\t\t\t\t\t\t\t\t<ModificationDate xsi:type=\"xsd:string\">2021-12-06 11:28:34.358921</ModificationDate>\n" +
                "\t\t\t\t\t\t\t\t</item>\n" +
                "\t\t\t\t\t\t\t\t<item xsi:type=\"ns1:service_Server_Multimedia_Entity_ObjectPhoto\">\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectType xsi:type=\"xsd:int\">1</ObjectType>\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectId xsi:type=\"xsd:int\">8193</ObjectId>\n" +
                "\t\t\t\t\t\t\t\t\t<Order xsi:type=\"xsd:int\">2520</Order>\n" +
                "\t\t\t\t\t\t\t\t\t<IsRemoved xsi:type=\"xsd:boolean\">false</IsRemoved>\n" +
                "\t\t\t\t\t\t\t\t\t<ModificationDate xsi:type=\"xsd:string\">2021-12-30 11:37:43.058653</ModificationDate>\n" +
                "\t\t\t\t\t\t\t\t</item>\n" +
                "\t\t\t\t\t\t\t\t<item xsi:type=\"ns1:service_Server_Multimedia_Entity_ObjectPhoto\">\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectType xsi:type=\"xsd:int\">1</ObjectType>\n" +
                "\t\t\t\t\t\t\t\t\t<ObjectId xsi:type=\"xsd:int\">94061</ObjectId>\n" +
                "\t\t\t\t\t\t\t\t\t<Order xsi:type=\"xsd:int\">2520</Order>\n" +
                "\t\t\t\t\t\t\t\t\t<IsRemoved xsi:type=\"xsd:boolean\">false</IsRemoved>\n" +
                "\t\t\t\t\t\t\t\t\t<ModificationDate xsi:type=\"xsd:string\">2014-09-29 16:15:49.814168</ModificationDate>\n" +
                "\t\t\t\t\t\t\t\t</item>\n" +
                "\t\t\t\t\t\t\t</Items>\n" +
                "\t\t\t\t\t\t</item>";

        xml = service.sendSoap(service.execute(53, 7, MethodEnum.divide));

        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xml));
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(src);
        doc.normalizeDocument();

        StringBuilder header = new StringBuilder();
        header.append("%dw 2.0\n");
        header.append("output application/xml\n");
        header.append("---\n");
        System.out.println(header);
        StringBuilder body = new StringBuilder();
        Node node = doc.getFirstChild();

        int i = 0;
        while (node.getFirstChild() != null){
            body.append(node.getNodeName());
            if(node.getChildNodes().getLength() > 1){
                body.append(": {");
                body.append(XmlReader.goThroughNode(node));
            } else {
                if(node.getFirstChild().getFirstChild() == null) {
                    body.append(": " + node.getTextContent());
                } else {
                    body.append("{" + "\n");
                }
            }
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                i++;
            }
            node = node.getFirstChild();
        }
        for(int g = 0; g < i-1; g++){
            body.append("\n}");
        }
        System.out.println(body);

    }
}
