import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XmlReader {


    public static Document convertStringToXMLDocument(String xmlString) throws IOException, ParserConfigurationException, SAXException {
    SoapService service = new SoapService();
    //service.sendSoap(1, 2);
    String xml = service.sendSoap(service.execute(4, 5, MethodEnum.add));

    InputSource src = new InputSource();
    src.setCharacterStream(new StringReader(xml));
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = builder.parse(src);
        System.out.println(doc.getFirstChild().getAttributes().item(0));
        return null;
    }

    public static StringBuilder goThroughNode(Node node){
        StringBuilder body = new StringBuilder();

        if(node.getChildNodes().getLength() > 1){
            for(int g = 0; g < node.getChildNodes().getLength(); g++){
                Node nodeCheck = node.getChildNodes().item(g);
                if(nodeCheck.getNodeType() == Node.ELEMENT_NODE) {
                    if(nodeCheck.getChildNodes().getLength() > 1){
                        body.append("\n" + nodeCheck.getNodeName()+ ": {");
                        body.append(goThroughNode(nodeCheck));
                        body.append("\n}");
                        if(g != (node.getChildNodes().getLength()-2)) {
                            body.append(",");
                        }
                    } else {
                        body.append("\n"+ nodeCheck.getNodeName()+ ": ");
                        body.append(nodeCheck.getTextContent());
                        if(g != (node.getChildNodes().getLength()-2)) {
                            body.append(",");
                        }
                    }
                }
            }
        } else {
            body.append(node.getTextContent());
        }
        return body;
    }

}
