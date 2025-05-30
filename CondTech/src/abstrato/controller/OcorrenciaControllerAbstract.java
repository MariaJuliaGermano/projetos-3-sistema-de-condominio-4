package abstrato.controller;

import java.util.List;
import model.Ocorrencia;

abstract public class OcorrenciaControllerAbstract {
    abstract public void registrarOcorrencia(Ocorrencia ocorrencia);
    abstract public List<Ocorrencia> listarOcorrencias();
}
