package controller;

import abstrato.controller.OcorrenciaControllerAbstract;

import java.util.List;

import model.Ocorrencia;
import repository.OcorrenciaRepository;

public class OcorrenciaController extends OcorrenciaControllerAbstract{

    private final OcorrenciaRepository ocRepo;

    public OcorrenciaController(OcorrenciaRepository ocRepo) {
        this.ocRepo = ocRepo;
    }

    @Override
    public void registrarOcorrencia(Ocorrencia ocorrencia) {
        ocRepo.adicionarOcorrencia(ocorrencia);
    }

    @Override
    public List<Ocorrencia> listarOcorrencias() {
        return ocRepo.listarOcorrencias();
    }
}
