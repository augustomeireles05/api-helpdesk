package br.com.helpdesk.helpdesk.domain;

import br.com.helpdesk.helpdesk.domain.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Client")
@Table(name="TB_CLIENT")
public class Client extends People {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "client") //atribute name in Request
    private List<Request> requests = new ArrayList<>();

    public Client() {
        super();
        addProfile(Profile.CLIENTE);
    }

    public Client(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.CLIENTE);
    }
}
