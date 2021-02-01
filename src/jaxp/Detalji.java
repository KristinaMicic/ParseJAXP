package jaxp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static jaxp.Parsiranje.parsiranje;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Kristina
 */
public class Detalji {
    
    public static Element parsirajXML() throws ParseException{
        
            Element koren = (Element)parsiranje();
            NodeList knjige = koren.getElementsByTagName("book");
            
            for(int i=0;i<knjige.getLength();i++){
                    Node book = knjige.item(i);
                    //System.out.println("Podaci o knjzi:" + book.getTextContent());
                    
                    NodeList price = ((Element)knjige.item(i)).getElementsByTagName("price");
                        
                for(int j=0;j<price.getLength();j++){
                            //Node price1 = price.item(j);
                            String cena =(String)price.item(j).getTextContent();
                            double vrednost = Double.parseDouble(cena);
                            //if(vrednost>10){}
                            
                     NodeList publish_date = ((Element)knjige.item(i)).getElementsByTagName("publish_date");
                        for(int u=0;u<publish_date.getLength();u++){
                            String datum = publish_date.item(u).getTextContent();
                            
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = dateFormat.parse(datum);
                            String datum1 = dateFormat.format(date);
                            String delovi[] = datum1.split("-");
                            String year = delovi[0];
                            int godina = Integer.parseInt(year);
                                if(vrednost>10 && godina>2005){
                                System.out.println("Podaci o knjigama gde je cena veca od 10 i godina izdavanja posle 2005:" + book.getTextContent());
                                }
                        }
                }
            }
            return null;
    }
}

