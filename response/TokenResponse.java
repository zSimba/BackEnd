package es.darcalzadilla.backend.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
    public TokenResponse(String jwToken) {
        this.jwToken = jwToken;
    }



    private String jwToken;

}
