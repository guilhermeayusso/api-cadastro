package br.com.fiap.apicadastro.controller;

import br.com.fiap.apicadastro.dto.EstabelecimentoDTO;
import br.com.fiap.apicadastro.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService service;

    @PostMapping
    public ResponseEntity<EstabelecimentoDTO> save (@RequestBody EstabelecimentoDTO estabelecimentoDTO){
        estabelecimentoDTO = service.save(estabelecimentoDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(estabelecimentoDTO);
    }

    @PatchMapping("/{id_estab}")
    public ResponseEntity<EstabelecimentoDTO> update (@RequestBody EstabelecimentoDTO estabelecimentoDTO,
                                                      @PathVariable UUID id_estab){
        estabelecimentoDTO = service.update(id_estab,estabelecimentoDTO);
        return ResponseEntity.ok(estabelecimentoDTO);
    }

    @GetMapping("/{id_estab}")
    public ResponseEntity<EstabelecimentoDTO> findStatus(@PathVariable UUID id_estab){
        var estabelecimento = service.findById(id_estab);
        return ResponseEntity.ok(estabelecimento);
    }



}
