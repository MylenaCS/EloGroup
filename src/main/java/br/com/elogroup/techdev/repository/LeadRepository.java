package br.com.elogroup.techdev.repository;

import br.com.elogroup.techdev.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
