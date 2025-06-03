package view;

import abstrato.view.OcorrenciaViewAbstract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.OcorrenciaController;
import model.Ocorrencia;
import model.Usuario;
import repository.OcorrenciaRepository;

public class OcorrenciaView extends OcorrenciaViewAbstract{

    private final Scanner scanner;
    private final OcorrenciaController ocorrenciaController;

    public OcorrenciaView(Scanner scanner, OcorrenciaRepository ocRepo) {
        this.scanner = scanner;
        this.ocorrenciaController = new OcorrenciaController(ocRepo);
    }

    @Override
    public void exibirMenu(Usuario usuarioLogado) {
        int opcao;
        do {
            System.out.println("\n==== Menu - Ocorrências ====");
            System.out.println("1 - Registrar ocorrência");
            System.out.println("2 - Ver ocorrências");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            try {
                if(System.getProperty("os.name").contains("Windows")){
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

            switch (opcao) {
                case 1:
                    registrarOcorrencia(usuarioLogado);
                    break;
                case 2:
                    listarOcorrencias();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);
    }

    private void registrarOcorrencia(Usuario usuarioLogado) {
        try {
            System.out.print("Descrição da ocorrência: ");
            String descricao = scanner.nextLine();

            List<String> anexos = new ArrayList<>();
            System.out.print("Deseja adicionar anexos? (s/n): ");
            String resposta = scanner.nextLine();

            while (resposta.equalsIgnoreCase("s")) {
                System.out.print("Digite o nome do anexo (ex: foto.jpg): ");
                String anexo = scanner.nextLine();
                anexos.add(anexo);

                System.out.print("Adicionar outro anexo? (s/n): ");
                resposta = scanner.nextLine();
            }

            Ocorrencia novaOcorrencia = new Ocorrencia(
                usuarioLogado.getId(),
                LocalDate.now(),
                descricao,
                "1",
                anexos
            );

            try {
                if(System.getProperty("os.name").contains("Windows")){
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

            ocorrenciaController.registrarOcorrencia(novaOcorrencia);
            System.out.println("Ocorrência registrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao registrar ocorrência: " + e.getMessage());
        }
    }

    private void listarOcorrencias() {
        List<Ocorrencia> ocorrencias = ocorrenciaController.listarOcorrencias();

        if (ocorrencias.isEmpty()) {
            System.out.println("Nenhuma ocorrência registrada.");
        } else {
            System.out.println("\n=== Lista de Ocorrências ===");
            for (Ocorrencia ocorrencia : ocorrencias) {
                System.out.println("ID: " + ocorrencia.getId());
                System.out.println("Morador (CPF): " + ocorrencia.getIdMorador());
                System.out.println("Data: " + ocorrencia.getDataRegistro());
                System.out.println("Descrição: " + ocorrencia.getDescricao());
                System.out.println("Status: " + ocorrencia.getStatus());
                if (ocorrencia.getAnexos() != null && !ocorrencia.getAnexos().isEmpty()) {
                    System.out.println("Anexos: " + String.join(", ", ocorrencia.getAnexos()));
                } else {
                    System.out.println("Anexos: Nenhum");
                }
                System.out.println("--------------------------");
            }

            System.out.println("\nPRESSIONE ENTER PARA CONTINUAR...");
            scanner.nextLine();
            try {
                if(System.getProperty("os.name").contains("Windows")){
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

