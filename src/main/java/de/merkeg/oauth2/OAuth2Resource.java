package de.merkeg.oauth2;

import de.merkeg.TwitchApiClient;
import de.merkeg.oauth2.data.OAuth2Request;
import de.merkeg.oauth2.data.OAuth2Response;
import de.merkeg.oauth2.data.OAuth2ResponseMapper;
import de.merkeg.oauth2.data.OAuth2TwitchResponse;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.print.attribute.standard.Media;

@Path("/oauth2")
public class OAuth2Resource {

    @Inject
    @RestClient
    TwitchApiClient twitchApiClient;

    @Inject
    OAuth2ResponseMapper mapper;

    @Inject
    MeterRegistry meterRegistry;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    @Path("token")
    public OAuth2Response token(OAuth2Request request) {
        meterRegistry.counter("http_request_token_counter",
                Tags.of(Tag.of("clientId", request.getClientId()), Tag.of("grantType", request.getGrantType()))).increment();

        OAuth2TwitchResponse response = twitchApiClient.tokenExchange(request);

        return mapper.map(response);
    }
}
