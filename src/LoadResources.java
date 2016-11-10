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

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return locations;
	}
}
