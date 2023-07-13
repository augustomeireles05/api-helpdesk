package br.com.helpdesk.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer id;
    private String desc;

    public static Status toEnum(Integer id){
        if(id == null) {
            return null;
        }

        for(Status s : Status.values()) {
            if(id.equals(s.getId())) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status inválido!");
    }

}
