package de.merkeg.oauth2.data;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface OAuth2ResponseMapper {

    @Mapping(source = "scope", target = "scope")
    OAuth2Response map(OAuth2TwitchResponse response);

    default String mapArrayToString(String[] arr) {
        return String.join(" ", arr);
    }
}
