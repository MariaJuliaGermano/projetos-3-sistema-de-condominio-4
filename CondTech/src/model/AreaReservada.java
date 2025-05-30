package model;

import abstrato.model.AreaReservadaAbstract;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;

public class AreaReservada extends AreaReservadaAbstract{

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

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getIdCondominio() {
        return idCondominio;
    }

    @Override
    public void setIdCondominio(String idCondominio) {
        this.idCondominio = idCondominio;
    }

    @Override
    public String getIdMorador() {
        return idMorador;
    }

    @Override
    public void setIdMorador(String idMorador) {
        this.idMorador = idMorador;
    }

    @Override
    public LocalDate getDataReserva() {
        return dataReserva;
    }

    @Override
    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    @Override
    public LocalTime getHorarioReservado() {
        return horarioReservado;
    }

    @Override
    public void setHorarioReservado(LocalTime horarioReservado) {
        this.horarioReservado = horarioReservado;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}

