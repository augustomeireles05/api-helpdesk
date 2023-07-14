package br.com.helpdesk.helpdesk.domain;

import br.com.helpdesk.helpdesk.domain.enums.Priority;
import br.com.helpdesk.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Request")
@Table(name = "TB_REQUEST")
public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate openingDate = LocalDate.now();

    private LocalDate closingDate;

    private Priority priority;

    private Status status;

    private String title;

    private String observation;

    @ManyToOne
    @JoinColumn(name="technician_id")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;


}
