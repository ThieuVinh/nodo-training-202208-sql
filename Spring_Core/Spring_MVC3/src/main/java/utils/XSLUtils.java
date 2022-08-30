package utils;

import model.JavaClazz;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class XSLUtils {
    public static DOMSource clazzToDomSource(JavaClazz clazz) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(JavaClazz.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream outputStream = new ByteArrayOutputStream();
        jaxbMarshaller.marshal(clazz, outputStream);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray()));

        return new DOMSource(document);
    }
}
