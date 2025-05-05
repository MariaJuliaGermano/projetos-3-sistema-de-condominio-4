package controller;

import java.util.List;

import model.AreaReservada;
import repository.AreaReservadaRepository;

public class AreaReservadaController {

    private final AreaReservadaRepository arRepo;

    public AreaReservadaController(AreaReservadaRepository arRepo) {
        this.arRepo = arRepo;
    }

    public void reservarArea(AreaReservada areaReservada) {
        arRepo.adicionarAreaReservada(areaReservada);
    }

    public List<AreaReservada> listarReservas() {
        return arRepo.listarAreaReservadas();
    }
}
