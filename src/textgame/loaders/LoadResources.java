package textgame.loaders;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import textgame.locations.*;

public class LoadResources {
	
	public static Map<String, Location> load(String filename) {
		Type locationObjectType = new TypeToken<Map<String, Location>>(){}.getType();
		Map<String, Location> locations = new HashMap<String, Location>();
		Gson gson = new Gson();
		
		try {
			String json = new String(Files.readAllBytes(Paths.get(filename)));
			locations = gson.fromJson(json, locationObjectType);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return locations;
	}
}
