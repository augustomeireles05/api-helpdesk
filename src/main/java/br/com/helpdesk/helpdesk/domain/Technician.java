package br.com.helpdesk.helpdesk.domain;

import br.com.helpdesk.helpdesk.domain.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "TB_TECHNICIAN")
public class Technician extends People {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "technician")
    private List<Request> requests = new ArrayList<>();

    public Technician() {
        super();
        addProfile(Profile.TECNICO);
    }

    public Technician(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.TECNICO);
    }
}
