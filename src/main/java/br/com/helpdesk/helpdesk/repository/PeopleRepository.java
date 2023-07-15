package br.com.helpdesk.helpdesk.repository;

import br.com.helpdesk.helpdesk.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {

}
