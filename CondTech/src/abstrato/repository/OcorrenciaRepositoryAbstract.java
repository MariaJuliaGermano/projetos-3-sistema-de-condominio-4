package abstrato.repository;

import java.util.List;
import model.Ocorrencia;

abstract public class OcorrenciaRepositoryAbstract {
    abstract public void adicionarOcorrencia(Ocorrencia ocorrencia);
    abstract public List<Ocorrencia> listarOcorrencias();
}
