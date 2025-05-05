package repository;

import java.util.ArrayList;
import java.util.List;

import model.Ocorrencia;

public class OcorrenciaRepository {

    private final List<Ocorrencia> Ocorrencias;

    public OcorrenciaRepository() {
        this.Ocorrencias = new ArrayList<>();
    }

    public void adicionarOcorrencia(Ocorrencia Ocorrencia) {
        Ocorrencias.add(Ocorrencia);
    }

    public List<Ocorrencia> listarOcorrencias() {
        return new ArrayList<>(Ocorrencias); // cópia da lista
    }

}
