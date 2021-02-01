package jaxp;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Kristina
 */
public class Parsiranje {
    
    public static Element parsiranje(){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
        
            dbf.setIgnoringElementContentWhitespace(true);
            Document doc=db.parse("XMLparse.xml");
            
            return doc.getDocumentElement();
        }
        catch(  ParserConfigurationException | IOException | SAXException e1) { System.out.println("Error");;}
        return null;
    }
    
}
