package br.com.fiap.earthguard.repository;

import br.com.fiap.earthguard.model.LeituraSatelital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeituraSatelitalRepository extends JpaRepository<LeituraSatelital, Long> {
}