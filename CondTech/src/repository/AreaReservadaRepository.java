package repository;

import java.util.ArrayList;
import java.util.List;

import model.AreaReservada;

public class AreaReservadaRepository {
    
    private final List<AreaReservada> areaReservadas;

    public AreaReservadaRepository() {
        this.areaReservadas = new ArrayList<>();
    }

    public void adicionarAreaReservada(AreaReservada areaReservada) {
        areaReservadas.add(areaReservada);
    }

    public List<AreaReservada> listarAreaReservadas() {
        return new ArrayList<>(areaReservadas); // cópia da lista
    }

}
