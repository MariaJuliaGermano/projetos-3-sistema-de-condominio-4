package model;

import abstrato.model.OcorrenciaAbstract;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

public class Ocorrencia extends OcorrenciaAbstract{
    
    private final String id;
    private String idMorador;
    private LocalDate dataRegistro;
    private String descricao;
    private String status;
    private List<String> anexos;

    public Ocorrencia(String idMorador, LocalDate dataRegistro, String descricao, String status, List<String> anexos) { //para criar uma nova ocorrência
        this.id = UUID.randomUUID().toString();
        this.idMorador = idMorador;
        this.dataRegistro = dataRegistro;
        this.descricao = descricao;
        this.status = status;
        this.anexos = anexos;
    }

    public Ocorrencia(String id, String idMorador, LocalDate dataRegistro, String descricao, String status, List<String> anexos) { //para consultar uma ocorrencia
        this.id = id;
        this.idMorador = idMorador;
        this.dataRegistro = dataRegistro;
        this.descricao = descricao;
        this.status = status;
        this.anexos = anexos;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getIdMorador() {
        return idMorador;
    }

    @Override
    public void setIdMorador(String idMorador) {
        this.idMorador = idMorador;
    }

    @Override
    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    @Override
    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public List<String> getAnexos() {
        return anexos;
    }

    @Override
    public void setAnexos(List<String> anexos) {
        this.anexos = anexos;
    }

}
