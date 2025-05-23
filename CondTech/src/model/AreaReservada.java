package model;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;

public class AreaReservada {

    private final String id;
    private String idCondominio;
    private String idMorador;
    private LocalDate dataReserva;
    private LocalTime horarioReservado;
    private String status;

    public AreaReservada(String idCondominio, String idMorador, LocalDate dataReserva, LocalTime horarioReservado, String status) { //para criar uma nova reserva
        this.id = UUID.randomUUID().toString();
        this.idCondominio = idCondominio;
        this.idMorador = idMorador;
        this.dataReserva = dataReserva;
        this.horarioReservado = horarioReservado;
        this.status = status;
    }

    public AreaReservada(String id, String idCondominio, String idMorador, LocalDate dataReserva, LocalTime horarioReservado, String status) { //para consultar uma reserva
        this.id = id;
        this.idCondominio = idCondominio;
        this.idMorador = idMorador;
        this.dataReserva = dataReserva;
        this.horarioReservado = horarioReservado;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(String idMorador) {
        this.idMorador = idMorador;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHorarioReservado() {
        return horarioReservado;
    }

    public void setHorarioReservado(LocalTime horarioReservado) {
        this.horarioReservado = horarioReservado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

