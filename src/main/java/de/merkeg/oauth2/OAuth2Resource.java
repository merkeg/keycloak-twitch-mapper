package de.merkeg.oauth2;

import de.merkeg.TwitchApiClient;
import de.merkeg.oauth2.data.OAuth2Request;
import de.merkeg.oauth2.data.OAuth2Response;
import de.merkeg.oauth2.data.OAuth2ResponseMapper;
import de.merkeg.oauth2.data.OAuth2TwitchResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/oauth2")
public class OAuth2Resource {

    @Inject
    @RestClient
    TwitchApiClient twitchApiClient;

    @Inject
    OAuth2ResponseMapper mapper;

    @POST
    @Path("token")
    public OAuth2Response token(OAuth2Request request) {

        OAuth2TwitchResponse response = twitchApiClient.tokenExchange(request);

        return mapper.map(response);
    }
}
