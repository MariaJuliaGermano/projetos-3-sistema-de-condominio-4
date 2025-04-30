package model;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;

public class AreaReservada {
    
    private final String id = UUID.randomUUID().toString();
    private String idCondominio;
    private String idMorador;
    private LocalDate dataReserva;
    private LocalTime horarioReservado;
    private String status;

    //implementar get e set
}
