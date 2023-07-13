package br.com.helpdesk.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer id;
    private String desc;

    public static Priority toEnum(Integer id){
        if(id == null) {
            return null;
        }

        for(Priority p : Priority.values()) {
            if(id.equals(p.getId())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Status inválido!");
    }

}
