package br.com.helpdesk.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profile {

    ADMIN(0, "ROLE_ADMIN"),
    CLIENTE(1, "ROLE_CLIENTE"),
    TECNICO(2, "ROLE_TECNICO");

    private Integer id;
    private String desc;

    public static Profile toEnum(Integer id){
        if(id == null) {
            return null;
        }

        for(Profile p : Profile.values()) {
            if(id.equals(p.getId())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Perfil inválido!");
    }

}
