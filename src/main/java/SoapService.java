import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SoapService {
    public String sendSoap(String xml){
        try {
            String url = "http://www.dneonline.com/calculator.asmx";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public String execute(int intA, int intB, MethodEnum method) throws IOException {
        String xml = Files.asCharSource(new File(getClass().getClassLoader().getResource("methods").getFile() + "/" + method), Charsets.UTF_8).read()
                .replace("%intB%", String.valueOf(intB))
                .replace("%intA%", String.valueOf(intA));
        return xml;
    }

    public int getResult(MethodEnum method, int intA, int intB) throws IOException, ParserConfigurationException, SAXException {
        String responseString = sendSoap(execute(intA, intB, method));
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(responseString));
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(src);
        return Integer.valueOf(doc.getElementsByTagName("soap:Body").item(0).getFirstChild().getFirstChild().getTextContent());
    }
}
