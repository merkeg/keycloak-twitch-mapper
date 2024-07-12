package de.merkeg;

import de.merkeg.oauth2.data.OAuth2Request;
import de.merkeg.oauth2.data.OAuth2TwitchResponse;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Path;

@RegisterRestClient(baseUri = "https://id.twitch.tv/oauth2")
public interface TwitchApiClient {

    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    OAuth2TwitchResponse tokenExchange(@BeanParam OAuth2Request request);
}
