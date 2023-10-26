package br.com.fiap.apicadastro.service;

import br.com.fiap.apicadastro.controller.exception.ControllerNotFoundException;
import br.com.fiap.apicadastro.dto.EstabelecimentoDTO;
import br.com.fiap.apicadastro.entities.Estabelecimento;
import br.com.fiap.apicadastro.repository.EstabelecimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository repository;

    public EstabelecimentoDTO save(EstabelecimentoDTO estabelecimentoDTO) {
        Estabelecimento estabelecimento = repository.save(toEstabelecimento(estabelecimentoDTO));
        return toEstabelecimentoDTO(estabelecimento);
    }

    public EstabelecimentoDTO update(UUID id, EstabelecimentoDTO estabelecimentoDTO) {
        try {
            Estabelecimento buscaEstab = repository.getReferenceById(id);
            buscaEstab.setStatus(estabelecimentoDTO.status());

            buscaEstab = repository.save(buscaEstab);

            return toEstabelecimentoDTO(buscaEstab);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Estabelecimento não encontrado");
        }
    }

    public EstabelecimentoDTO findById(UUID id){
        var estabelecimento = repository.findById(id).orElseThrow(()-> new ControllerNotFoundException("Estabelecimento não encontrado"));
        return toEstabelecimentoDTO(estabelecimento);
    }

    private EstabelecimentoDTO toEstabelecimentoDTO(Estabelecimento estabelecimento) {

        return new EstabelecimentoDTO(
                estabelecimento.getId_estab(),
                estabelecimento.getNome_fantasia(),
                estabelecimento.getCnpj(),
                estabelecimento.getRamo_atividade(),
                estabelecimento.getStatus(),
                estabelecimento.getAdquirente()
        );
    }

    private Estabelecimento toEstabelecimento(EstabelecimentoDTO estabelecimentoDTO) {
        return new Estabelecimento(
                estabelecimentoDTO.id_estab(),
                estabelecimentoDTO.nome_fantasia(),
                estabelecimentoDTO.cnpj(),
                estabelecimentoDTO.ramo_atividade(),
                estabelecimentoDTO.status(),
                estabelecimentoDTO.adquirente()
        );
    }

}
