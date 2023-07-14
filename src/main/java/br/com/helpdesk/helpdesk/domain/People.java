package br.com.helpdesk.helpdesk.domain;

import br.com.helpdesk.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "TB_PEOPLE")
public abstract class People implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    @Column(unique = true)
    protected String cpf;
    @Column(unique = true)
    protected String email;
    protected String password;
    @ElementCollection(fetch = FetchType.EAGER)//Asseguro que a lista de perfis virá junto com o usuário
    @CollectionTable(name = "TB_PROFILES")
    protected Set<Integer> profiles = new HashSet<>(); //Não permite dois perfis com mesmo valor

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdDate = LocalDate.now();

    public People() {
        super();
        addProfile(Profile.CLIENTE);
    }

    public People(Long id, String name, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        addProfile(Profile.CLIENTE);
    }

    public Set<Profile> getProfile() {
        return profiles.stream().map(p -> Profile.toEnum(p)).collect(Collectors.toSet());
    }

    public void addProfile(@NotNull Profile profile) {
        this.profiles.add(profile.getId());
    }

}
