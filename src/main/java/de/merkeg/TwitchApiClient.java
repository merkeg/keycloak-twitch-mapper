package de.merkeg;

import de.merkeg.oauth2.data.OAuth2Request;
import de.merkeg.oauth2.data.OAuth2TwitchResponse;
import jakarta.ws.rs.POST;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Path;

@RegisterRestClient(baseUri = "https://id.twitch.tv/oauth2")
public interface TwitchApiClient {

    @POST
    @Path("/token")
    OAuth2TwitchResponse tokenExchange(OAuth2Request request);
}
