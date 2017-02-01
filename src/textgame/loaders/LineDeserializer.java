package textgame.loaders;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import textgame.conversation.Line;
import textgame.conversation.Response;

public class LineDeserializer implements JsonDeserializer<Line> {

  @Override
  public Line deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject lineData = json.getAsJsonObject();
    
	String text = lineData.get("npc_text").getAsString();
	
	Line line = new Line(text);

	JsonElement responseLines = lineData.get("responses");
	
	if(responseLines != null) {
		JsonArray responseArray = responseLines.getAsJsonArray();
		for(JsonElement responseElement : responseArray) {
			JsonObject responseData = responseElement.getAsJsonObject();
			int nextIndex = responseData.get("next_index").getAsInt();
			String message = responseData.get("player_text").getAsString();
			Response response = new Response(nextIndex, message);
			line.addResponse(response);
		}
	}

	return line;
  }
}