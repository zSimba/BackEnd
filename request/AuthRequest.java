package es.darcalzadilla.backend.request;


import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Setter
@Getter
public class AuthRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

}
