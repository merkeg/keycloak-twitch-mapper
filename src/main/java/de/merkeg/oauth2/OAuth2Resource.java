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
import jakarta.ws.rs.*;
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
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Path("token")
    public OAuth2Response token(@BeanParam OAuth2Request request) {
        OAuth2TwitchResponse response = twitchApiClient.tokenExchange(request);

        return mapper.map(response);
    }
}
