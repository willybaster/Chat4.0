package objects;

import java.io.IOException;
import java.io.Reader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class DecoderMessage implements Decoder.TextStream<Message> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method that decode the json generate by the encoder to a message again
	 * 
	 * @param reader
	 * @return message
	 */
	@Override
	public Message decode(Reader reader) throws DecodeException, IOException {

		Message msg = new Message();
		try (JsonReader jsonReader = Json.createReader(reader)) {
			JsonObject json = jsonReader.readObject();
			msg.setMessage(json.getString("message"));
			msg.setUser(json.getString("user"));
		}
		return msg;
	}

}
