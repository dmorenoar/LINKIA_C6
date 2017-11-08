/*
 * LINKIA CLASE 6 - SERIALIZACIÓN Y JDOM
 */
package linkia_c6;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Daniel Morneo
 */
public class LINKIA_C6 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {

            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build("peliculas.xml");

            //Elemento raíz del documento - Estamos a nivel del root
            Element root = doc.getRootElement();
            //System.out.println(root.getName());

            List<Element> hijos = root.getChildren();

            for (Element peli : hijos) {
                System.out.println("************");
                //System.out.println(peli.getName());
                String valoracion = peli.getAttributeValue("valoracion");
                System.out.println("Esta pelicula esta valorada con:" + valoracion);

                List<Element> nietos = peli.getChildren();

                for (Element nodo : nietos) {

                    //Para obtener únicamente un campo
                    if (nodo.getName().equalsIgnoreCase("titulo")) {
                        System.out.println(nodo.getName() + ":" + nodo.getValue());
                    }
                    //Para obtener todos los atributos y su valor.
                    System.out.println(nodo.getName() + ":" + nodo.getValue());
                }
            }

        } catch (IOException | JDOMException ex) {
            Logger.getLogger(LINKIA_C6.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            Pelicula cube = new Pelicula("Cube", "Vicenzo Natali", 1995, "Suspense");
            Pelicula anillos = new Pelicula("El señor de los anillos: La comunidad del anillo", "Peter Jackson", 2001, "Fantástico");
            XMLEncoder xml = new XMLEncoder(new FileOutputStream(new File("mispeliculas.xml")));

            xml.writeObject(cube);
            xml.writeObject(anillos);
            xml.close();


            /* Lectura del fichero XML*/
            XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("mispeliculas.xml")));

            Pelicula peliVacia;
            peliVacia = (Pelicula) xmlDecoder.readObject();
            System.out.println(peliVacia);

            peliVacia = (Pelicula) xmlDecoder.readObject();
            System.out.println(peliVacia);

        } catch (IOException ex) {
            Logger.getLogger(LINKIA_C6.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Leer de un fichero    
        String cadena;
        FileReader fichero = new FileReader("starwars.txt");
        BufferedReader buff = new BufferedReader(fichero);

        while ((cadena = buff.readLine()) != null) {
            System.out.println(cadena);
        }

        //Escribir en un fichero
        FileWriter writer = new FileWriter("starwars.txt");

        System.out.println("Vamos a empezar a escribir");
        writer.write("Hace mucho tiempo en una galaxia muy, muy lejana...");

        writer.flush();

        writer.close();

    }
}
