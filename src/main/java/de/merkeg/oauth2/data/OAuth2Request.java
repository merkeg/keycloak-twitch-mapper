package de.merkeg.oauth2.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.jboss.resteasy.reactive.RestForm;

@Getter
@Setter
public class OAuth2Request {

    @RestForm
    @JsonProperty("client_id")
    String clientId;

    @RestForm
    @JsonProperty("client_secret")
    String clientSecret;

    @RestForm
    @JsonProperty("code")
    String code;

    @RestForm
    @JsonProperty("grant_type")
    String grantType;

    @RestForm
    @JsonProperty("redirect_uri")
    String redirectUri;
}
