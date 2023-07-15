package br.com.helpdesk.helpdesk.repository;

import br.com.helpdesk.helpdesk.domain.Technician;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
