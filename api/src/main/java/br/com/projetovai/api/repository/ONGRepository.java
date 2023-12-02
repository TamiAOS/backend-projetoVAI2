package br.com.projetovai.api.repository;

import br.com.projetovai.api.entity.ONG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ONGRepository extends JpaRepository<ONG, Long> {
}
