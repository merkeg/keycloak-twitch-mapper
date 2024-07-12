package de.merkeg.oauth2.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuth2TwitchResponse {

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("refresh_token")
    String refreshToken;

    @JsonProperty("expires_in")
    int expiresIn;

    @JsonProperty("scope")
    String[] scope;

    @JsonProperty("token_type")
    String tokenType;
}
