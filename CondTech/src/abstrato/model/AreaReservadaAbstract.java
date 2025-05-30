package abstrato.model;

import java.time.LocalDate;
import java.time.LocalTime;

abstract public class AreaReservadaAbstract {
    abstract public String getId();
    abstract public String getIdCondominio();
    abstract public void setIdCondominio(String idCondominio);
    abstract public String getIdMorador();
    abstract public void setIdMorador(String idMorador);
    abstract public LocalDate getDataReserva();
    abstract public void setDataReserva(LocalDate dataReserva);
    abstract public LocalTime getHorarioReservado();
    abstract public void setHorarioReservado(LocalTime horarioReservado);
    abstract public String getStatus();
    abstract public void setStatus(String status);
}
