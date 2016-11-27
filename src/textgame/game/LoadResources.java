package textgame.game;
import javax.xml.bind.*;

import textgame.locations.Exit;
import textgame.locations.Location;
import textgame.locations.Locations;

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
	/* Add XML annotations to items so that they can be imported too */
}
