package br.com.helpdesk.helpdesk.service;

import br.com.helpdesk.helpdesk.domain.Client;
import br.com.helpdesk.helpdesk.domain.Request;
import br.com.helpdesk.helpdesk.domain.Technician;
import br.com.helpdesk.helpdesk.domain.enums.Priority;
import br.com.helpdesk.helpdesk.domain.enums.Profile;
import br.com.helpdesk.helpdesk.domain.enums.Status;
import br.com.helpdesk.helpdesk.repository.ClientRepository;
import br.com.helpdesk.helpdesk.repository.RequestRepository;
import br.com.helpdesk.helpdesk.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RequestRepository requestRepository;

    public void instanciarDB() {
        Technician tec1 = new Technician(1l, "Tecnico Silva", "45723561499", "tecnicosilva@mail.com", "123");
        tec1.addProfile(Profile.ADMIN);
        Client cli1 = new Client(1l, "Cliente Silva", "24301813802", "clientesilva@mail.com", "123");
        Request req1 = new Request(1l, Priority.ALTA, Status.ANDAMENTO, "Chamado 1", "Primeiro chamado", tec1, cli1);

        technicianRepository.saveAll(Arrays.asList(tec1));
        clientRepository.saveAll(Arrays.asList(cli1));
        requestRepository.saveAll(Arrays.asList(req1));
    }
}
