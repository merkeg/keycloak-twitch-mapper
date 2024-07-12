package de.merkeg.oauth2.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuth2Request {

    @JsonProperty("client_id")
    String clientId;

    @JsonProperty("client_secret")
    String clientSecret;

    @JsonProperty("code")
    String code;

    @JsonProperty("grant_type")
    String grantType;

    @JsonProperty("redirect_uri")
    String redirectUri;
}
