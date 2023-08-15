package ru.mylov;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class XmlWriter {
    private static XmlWriter xmlWriter;
    private static final Logger logger = Logger.getLogger(ExcelWriter.class.getName());

    public static XmlWriter getXmlWriter() throws JAXBException {
        if (xmlWriter == null) {
            xmlWriter = new XmlWriter();
        }
        return xmlWriter;
    }

    public void writeXml(Structure structure) throws JAXBException, IOException {
        logger.log(Level.INFO, "Starting xml writer");
        JAXBContext context = JAXBContext.newInstance(Structure.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Files.createDirectories(Paths.get("target/xmlReqs"));
        File file = new File("target/xmlReqs/" + Structure.getTimestamp() + ".xml");
        FileOutputStream fos = new FileOutputStream(file);
        marshaller.marshal(structure, file);
        logger.log(Level.INFO, "Xml file writing is finished");
        fos.close();
    }
}
