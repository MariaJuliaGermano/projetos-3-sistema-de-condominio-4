package model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

public class Ocorrencia {
    
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

    public String getId() {
        return id;
    }

    public String getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(String idMorador) {
        this.idMorador = idMorador;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<String> anexos) {
        this.anexos = anexos;
    }

}
