package abstrato.model;

import java.time.LocalDate;
import java.util.List;

abstract public class OcorrenciaAbstract {
    abstract public String getId();
    abstract public String getIdMorador();
    abstract public void setIdMorador(String idMorador);
    abstract public LocalDate getDataRegistro();
    abstract public void setDataRegistro(LocalDate dataRegistro);
    abstract public String getDescricao();
    abstract public void setDescricao(String descricao);
    abstract public String getStatus();
    abstract public void setStatus(String status);
    abstract public List<String> getAnexos();
    abstract public void setAnexos(List<String> anexos);
}
