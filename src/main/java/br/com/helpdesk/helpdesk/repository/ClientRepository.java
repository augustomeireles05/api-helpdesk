package br.com.helpdesk.helpdesk.repository;

import br.com.helpdesk.helpdesk.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
