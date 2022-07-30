package com.example.harjoitustyo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MovieDataLoader {

    private static MovieDataLoader movieDataLoader = null;

    public static MovieDataLoader getInstance() {
        // here we create a singleton
        if (movieDataLoader == null) {
            movieDataLoader = new MovieDataLoader();
        }
        return movieDataLoader;
    }
    public ArrayList getCurrentMovieNames(ArrayList<String> list) {
        // we load current events by original title from finnkino.fi, and put them into Arraylist
        // as Strings that we return.
        list.clear();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Events/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Event");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String movieName = element.getElementsByTagName
                            ("OriginalTitle").item(0).getTextContent();
                    list.add(movieName);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    return list;
    }

}
