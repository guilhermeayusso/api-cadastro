package br.com.fiap.apicadastro.repository;

import br.com.fiap.apicadastro.entities.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, UUID> {
}
