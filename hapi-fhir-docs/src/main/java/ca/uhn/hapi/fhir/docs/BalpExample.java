package ca.uhn.hapi.fhir.docs;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.storage.interceptor.balp.AsyncMemoryQueueBackedFhirClientBalpSink;
import ca.uhn.fhir.storage.interceptor.balp.IBalpAuditContextServices;
import ca.uhn.fhir.storage.interceptor.balp.IBalpAuditEventSink;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.client.interceptor.BasicAuthInterceptor;
import ca.uhn.fhir.rest.server.RestfulServer;
import org.hl7.fhir.r4.model.Reference;

import javax.annotation.Nonnull;
import javax.servlet.ServletException;
import java.util.List;

public class BalpExample {

	//START SNIPPET: contextService
	public class ExampleBalpAuditContextServices implements IBalpAuditContextServices {

		/**
		 * Here we are just hard-coding a simple display name. In a real implementation
		 * we should use the actual identity of the requesting client.
		 */
		@Nonnull
		@Override
		public Reference getAgentClientWho(RequestDetails theRequestDetails) {
			Reference client = new Reference();
			client.setDisplay("Growth Chart Application");
			client.getIdentifier()
				.setSystem("http://example.org/clients")
				.setValue("growth_chart");
			return client;
		}

		/**
		 * Here we are just hard-coding a simple display name. In a real implementation
		 * we should use the actual identity of the requesting user.
		 */
		@Nonnull
		@Override
		public Reference getAgentUserWho(RequestDetails theRequestDetails) {
			Reference user = new Reference();
			user.getIdentifier()
				.setSystem("http://example.org/users")
				.setValue("my_username");
			return user;
		}
	}
	//END SNIPPET: contextService

	//START SNIPPET: server
	public class MyServer extends RestfulServer {

		/**
		 * Constructor
		 */
		public MyServer() {
			super(FhirContext.forR4Cached());
		}

		@Override
		protected void initialize() throws ServletException {
			// Register your resource providers and other interceptors here...

			/*
			 * Create our context sservices object
			 */
			IBalpAuditContextServices contextServices = new ExampleBalpAuditContextServices();

			/*
			 * Create our event sink
			 */
			FhirContext fhirContext = FhirContext.forR4Cached();
			String targetUrl = "http://my.fhir.server/baseR4";
			List<Object> clientInterceptors = List.of(
				// We'll register an auth interceptor against the sink FHIR client so that
				// credentials get passed to the target server. Of course in a real implementation
				// you should never hard code credentials like this.
				new BasicAuthInterceptor("username", "password")
			);
			IBalpAuditEventSink eventSink = new AsyncMemoryQueueBackedFhirClientBalpSink(fhirContext, targetUrl, clientInterceptors);

		}
	}
	//END SNIPPET: server
}