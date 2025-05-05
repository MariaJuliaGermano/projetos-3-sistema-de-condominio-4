package controller;

import java.util.List;

import model.Ocorrencia;
import repository.OcorrenciaRepository;

public class OcorrenciaController {

    private final OcorrenciaRepository ocRepo;

    public OcorrenciaController(OcorrenciaRepository ocRepo) {
        this.ocRepo = ocRepo;
    }

    public void registrarOcorrencia(Ocorrencia ocorrencia) {
        ocRepo.adicionarOcorrencia(ocorrencia);
    }

    public List<Ocorrencia> listarOcorrencias() {
        return ocRepo.listarOcorrencias();
    }
}
