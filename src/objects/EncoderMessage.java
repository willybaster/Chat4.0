package objects;

import java.io.IOException;
import java.io.Writer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EncoderMessage implements Encoder.TextStream<Message> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method that enconde the message into a json
	 * 
	 * @param message
	 * @param writer
	 */
	@Override
	public void encode(Message message, Writer writer) throws EncodeException, IOException {

		JsonObject json = Json.createObjectBuilder().add("user", message.getUser()).add("message", message.getMessage())
				.build();

		try (JsonWriter jWriter = Json.createWriter(writer)) {
			jWriter.writeObject(json);
		}
	}

}
