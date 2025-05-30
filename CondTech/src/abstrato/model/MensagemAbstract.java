package abstrato.model;

import java.time.LocalDateTime;

abstract public class MensagemAbstract {
    abstract public String getId();
    abstract public String getRemetente();
    abstract public String getDestinatario();
    abstract public String getConteudo();
    abstract public LocalDateTime getDataHora();
    abstract public boolean isLida();
    abstract public void setLida(boolean lida);
}
