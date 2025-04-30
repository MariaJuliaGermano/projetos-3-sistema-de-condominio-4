package model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

public class Ocorrencia {
    
    private final String id = UUID.randomUUID().toString();
    private String idMorador;
    private LocalDate dataRegistro;
    private String descricao;
    private String status;
    private List<String> anexos;

    //implementar get e set
}
