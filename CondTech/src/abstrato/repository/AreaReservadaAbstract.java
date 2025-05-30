package abstrato.repository;

import java.util.List;
import model.AreaReservada;

abstract public class AreaReservadaAbstract {
    abstract public void adicionarAreaReservada(AreaReservada areaReservada);
    abstract public List<AreaReservada> listarAreaReservadas();
}
