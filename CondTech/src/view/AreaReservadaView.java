package view;

import abstrato.view.AreaReservadaViewAbstract;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import controller.AreaReservadaController;
import model.AreaReservada;
import model.Usuario;
import repository.AreaReservadaRepository;

public class AreaReservadaView extends AreaReservadaViewAbstract{

    private final Scanner scanner;
    private final AreaReservadaController areaController;

    public AreaReservadaView(Scanner scanner, AreaReservadaRepository arRepo) {
        this.scanner = scanner;
        this.areaController = new AreaReservadaController(arRepo);
    }

    @Override
    public void exibirMenu(Usuario usuarioLogado) {
        int opcao;
        do {
            System.out.println("\n==== Menu - Área Reservada ====");
            System.out.println("1 - Reservar área");
            System.out.println("2 - Ver reservas");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    reservarArea(usuarioLogado);
                    break;
                case 2:
                    listarReservas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);
    }

    private void reservarArea(Usuario usuarioLogado) {
        try {
            System.out.print("Data da reserva (AAAA-MM-DD): ");
            String dataStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataStr);

            System.out.print("Horário da reserva (HH:MM): ");
            String horaStr = scanner.nextLine();
            LocalTime horario = LocalTime.parse(horaStr);

            System.out.print("ID do condomínio: ");
            String idCondominio = scanner.nextLine();

            AreaReservada novaReserva = new AreaReservada(
                idCondominio,
                usuarioLogado.getId(),
                data,
                horario,
                "1"
            );

            areaController.reservarArea(novaReserva);
            System.out.println("Reserva realizada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao realizar reserva: " + e.getMessage());
        }
    }

    private void listarReservas() {
        List<AreaReservada> reservas = areaController.listarReservas();

        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            System.out.println("\n=== Lista de Reservas ===");
            for (AreaReservada reserva : reservas) {
                System.out.println("ID: " + reserva.getId());
                System.out.println("Condomínio: " + reserva.getIdCondominio());
                System.out.println("Morador (CPF): " + reserva.getIdMorador());
                System.out.println("Data: " + reserva.getDataReserva());
                System.out.println("Horário: " + reserva.getHorarioReservado());
                System.out.println("Status: " + reserva.getStatus());
                System.out.println("--------------------------");
            }
        }
    }
}
