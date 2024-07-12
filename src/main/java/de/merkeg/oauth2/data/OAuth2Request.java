package de.merkeg.oauth2.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.FormParam;
import lombok.Getter;
import lombok.Setter;
import org.jboss.resteasy.reactive.RestForm;

@Getter
@Setter
public class OAuth2Request {

    @FormParam("client_id")
    @JsonProperty("client_id")
    String clientId;

    @FormParam("client_secret")
    @JsonProperty("client_secret")
    String clientSecret;

    @FormParam("code")
    @JsonProperty("code")
    String code;

    @FormParam("grant_type")
    @JsonProperty("grant_type")
    String grantType;

    @FormParam("redirect_uri")
    @JsonProperty("redirect_uri")
    String redirectUri;
}
