# Twitch Keycloak mapper
Twitch does not fully follow the oAuth2 spec in the `/oauth2/token` endpoint. Because of that, Keycloak can not use twitch as an external identity provider.
This project is used as an alternative endpoint, that calls the Twitch api, and maps the response into something keycloak can understand.
