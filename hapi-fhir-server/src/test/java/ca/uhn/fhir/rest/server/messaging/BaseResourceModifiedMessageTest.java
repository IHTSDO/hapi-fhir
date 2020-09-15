package ca.uhn.fhir.rest.server.messaging;

import ca.uhn.fhir.rest.server.messaging.json.ConcreteResourceModifiedJsonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static ca.uhn.fhir.rest.server.messaging.json.HapiMessageHeaders.FIRST_FAILURE_KEY;
import static ca.uhn.fhir.rest.server.messaging.json.HapiMessageHeaders.LAST_FAILURE_KEY;
import static ca.uhn.fhir.rest.server.messaging.json.HapiMessageHeaders.RETRY_COUNT_KEY;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ConcreteResourceModifiedMessageTest {

	@Test
	public void testSerializationAndDeserializationOfResourceModifiedMessage() throws JsonProcessingException {
		ConcreteResourceModifiedJsonMessage jsonMessage = new ConcreteResourceModifiedJsonMessage();
		jsonMessage.setPayload(new ConcreteResourceModifiedMessage());
		ObjectMapper mapper = new ObjectMapper();
		String serialized = mapper.writeValueAsString(jsonMessage);
		jsonMessage = mapper.readValue(serialized, ConcreteResourceModifiedJsonMessage.class);

		assertThat(jsonMessage.getHapiHeaders().getRetryCount(), is(equalTo(0)));
		assertThat(jsonMessage.getHapiHeaders().getFirstFailureDate(), is(equalTo(null)));
		assertThat(jsonMessage.getHapiHeaders().getLastFailureDate(), is(equalTo(null)));

		assertThat(jsonMessage.getHeaders().get(RETRY_COUNT_KEY), is(equalTo(0)));
		assertThat(jsonMessage.getHeaders().get(FIRST_FAILURE_KEY), is(equalTo(null)));
		assertThat(jsonMessage.getHeaders().get(LAST_FAILURE_KEY), is(equalTo(null)));
	}
}
