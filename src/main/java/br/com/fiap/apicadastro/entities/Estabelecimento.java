package br.com.fiap.apicadastro.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_estabelecimentos")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_estab;
    private String nome_fantasia;
    private String cnpj;
    private String ramo_atividade;
    private String status;
    private String adquirente;

    public Estabelecimento() {
    }

    public Estabelecimento(UUID id_estab, String nome_fantasia, String cnpj, String ramo_atividade, String status, String adquirente) {
        this.id_estab = id_estab;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.ramo_atividade = ramo_atividade;
        this.status = status;
        this.adquirente = adquirente;
    }

    public String getAdquirente() {
        return adquirente;
    }

    public void setAdquirente(String adquirente) {
        this.adquirente = adquirente;
    }

    public UUID getId_estab() {
        return id_estab;
    }

    public void setId_estab(UUID id_estab) {
        this.id_estab = id_estab;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRamo_atividade() {
        return ramo_atividade;
    }

    public void setRamo_atividade(String ramo_atividade) {
        this.ramo_atividade = ramo_atividade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(id_estab, that.id_estab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_estab);
    }

    @Override
    public String toString() {
        return "Estabelecimento{" +
                "id_estab=" + id_estab +
                ", nome_fantasia='" + nome_fantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", ramo_atividade='" + ramo_atividade + '\'' +
                ", status='" + status + '\'' +
                ", adquirente='" + adquirente + '\'' +
                '}';
    }
}
