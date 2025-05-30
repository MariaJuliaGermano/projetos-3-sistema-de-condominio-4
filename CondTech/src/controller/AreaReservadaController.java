package controller;

import abstrato.controller.AreaReservadaControllerAbstract;

import java.util.List;

import model.AreaReservada;
import repository.AreaReservadaRepository;

public class AreaReservadaController extends AreaReservadaControllerAbstract{

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
