package de.merkeg.oauth2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.merkeg.TwitchApiClient;
import de.merkeg.oauth2.data.OAuth2Request;
import de.merkeg.oauth2.data.OAuth2Response;
import de.merkeg.oauth2.data.OAuth2ResponseMapper;
import de.merkeg.oauth2.data.OAuth2TwitchResponse;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.quarkus.vertx.http.runtime.devmode.Json;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.print.attribute.standard.Media;

@Path("/oauth2")
@Slf4j
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
    public OAuth2Response token(@BeanParam OAuth2Request request) throws JsonProcessingException {
        log.debug("New token mapping request");
        OAuth2TwitchResponse response = twitchApiClient.tokenExchange(request);
        log.debug("Got twitch response data: {}", response);

        OAuth2Response mapped = mapper.map(response);
        log.debug("Got mapped response data: {}", mapped);

        String idToken = mapped.getIdToken();
        String[] split = idToken.split("\\.");
        split[0] = split[0] + 'o';
        mapped.setIdToken(String.join(".", split));

        ObjectMapper objectMapper = new ObjectMapper();
        log.debug(objectMapper.writeValueAsString(mapped));

        return mapped;
    }
}
