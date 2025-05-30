package abstrato.controller;

import java.util.List;
import model.AreaReservada;

abstract public class AreaReservadaControllerAbstract {
    abstract public void reservarArea(AreaReservada areaReservada);
    abstract public List<AreaReservada> listarReservas();
}
