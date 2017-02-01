package textgame.loaders;
import javax.xml.bind.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.jadventure.game.entities.NPC;
import com.jadventure.game.items.Storage;

import textgame.locations.*;
import textgame.entities.*;
import textgame.conversation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LoadResources {
    private Map<String,NPC> npcMap = new HashMap<String,NPC>();

	public static Locations loadLocations(String filename) {
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

	public static NPCs loadNPCs(String filename) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(NPC.class, new NPCDeserializer());
        Gson gson = gsonBuilder.create();
		JsonArray jsonNPCs = new JsonArray();
		try {
			File jsonResource = new File(filename);
			JsonReader reader = new JsonReader(new FileReader(jsonResource));
			JsonParser parser = new JsonParser();
			JsonObject json = parser.parse(reader).getAsJsonObject();
			jsonNPCs = json.get("NPCs").getAsJsonArray();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		NPCs npcs = new NPCs();
		for(JsonElement npcElement : jsonNPCs) {
    		NPC npc = gson.fromJson(npcElement, NPC.class);
    		npcs.setNPC(npc);
		}
		
		return npcs;
    }
}
