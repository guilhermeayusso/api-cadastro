package br.com.fiap.apicadastro.dto;

import java.util.UUID;

public record EstabelecimentoDTO(
        UUID id_estab,
        String nome_fantasia,
        String cnpj,
        String ramo_atividade,
        String status,
        String adquirente

) {
}
