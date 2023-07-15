package br.com.helpdesk.helpdesk.repository;

import br.com.helpdesk.helpdesk.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RequestRepository extends JpaRepository<Request, Long> {

}
