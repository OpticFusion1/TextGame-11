package textgame.loaders;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import textgame.conversation.*;
import textgame.entities.NPC;

public class NPCDeserializer implements JsonDeserializer<NPC> {
    
    @Override
    public NPC deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
    		throws JsonParseException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Line.class, new LineDeserializer());
        Gson gson = gsonBuilder.create();
        
    	JsonObject npcData = json.getAsJsonObject();

    	String id = npcData.get("id").getAsString();
    	String name = npcData.get("name").getAsString();

    	JsonArray conversationArray = npcData.get("conversation").getAsJsonArray();

    	Conversation convo = new Conversation();
    	for (JsonElement conversationLine : conversationArray) {
    		Line line = gson.fromJson(conversationLine, Line.class);
    		convo.addLine(line);
    	}

    	NPC npc = new NPC(id, name, convo);
    	return npc;
    }
}