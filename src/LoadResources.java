import java.util.*;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class LoadResources {
	public static Locations loadLocations(String filename) throws Exception {
		Locations locations = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Locations.class, Location.class, Exit.class);
			
			File resourceXML = new File(filename);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			locations = (Locations) unmarshaller.unmarshal(resourceXML);
			
			/* TODO - create Exits class so can have multiple? Or skip wrapper */
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return locations;
	}

	public static List<Exit> loadExits(String filename) throws Exception {
		List<Exit> exits = new ArrayList<Exit>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Exit.class);
			
			XMLInputFactory xif = XMLInputFactory.newFactory();
			StreamSource xml = new StreamSource(filename);
			XMLStreamReader xsr = xif.createXMLStreamReader(xml);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			while(xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
				if(xsr.isStartElement() && "exit".equals(xsr.getLocalName())) {
					Exit exit = (Exit) jaxbUnmarshaller.unmarshal(xsr);
					exits.add(exit);
				}
				xsr.next();
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return exits;
	}
}
