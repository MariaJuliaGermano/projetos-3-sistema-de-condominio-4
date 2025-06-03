package view;

import abstrato.view.HomeViewAbstract;

import java.util.Scanner;

import model.Usuario;
import repository.AreaReservadaRepository;
import repository.OcorrenciaRepository;
import repository.UsuarioRepository;
import repository.MensagemRepository;

public class HomeView extends HomeViewAbstract{

    private final Scanner scanner;
    private final UsuarioRepository  userRepo;
    private final AreaReservadaRepository arRepo;
    private final OcorrenciaRepository ocRepo;
    private final MensagemRepository msgRepo;

    public HomeView(Scanner scanner, UsuarioRepository userRepo, AreaReservadaRepository arRepo, 
                   OcorrenciaRepository ocRepo, MensagemRepository msgRepo) {
        this.scanner = scanner;
        this.userRepo = userRepo;
        this.arRepo = arRepo;
        this.ocRepo = ocRepo;
        this.msgRepo = msgRepo;
    }

    @Override
    public void exibirMenu(Usuario usuarioLogado) {
        int opcao;
        do {
            System.out.println("\n========= Menu - CondTech =========");
            System.out.println("1 - Chat");
            System.out.println("2 - Ocorrencia");
            System.out.println("3 - Area Reservada");
            
            if (usuarioLogado.getAdmin()) {
                System.out.println("4 - Admin");
            }
            
            System.out.println("0 - Logout");

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
                    ChatView chatView = new ChatView(scanner, userRepo, msgRepo);
                    chatView.exibirMenu(usuarioLogado);
                    break;

                case 2:
                    OcorrenciaView ocorrenciaView = new OcorrenciaView(scanner, ocRepo);
                    ocorrenciaView.exibirMenu(usuarioLogado);
                    break;
                case 3:
                    AreaReservadaView areaReservadaView = new AreaReservadaView(scanner, arRepo);
                    areaReservadaView.exibirMenu(usuarioLogado);
                    break;
                case 4:
                if (usuarioLogado.getAdmin()) {
                        System.out.print("Nome do novo usuário: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("Tipo de usuario (1: Morador, 2: sindico, 3: funcionario): ");
                        String tipoUsuario = scanner.nextLine();
                        
                        System.out.print("É admin? (true/false): ");
                        boolean admin = scanner.nextBoolean();
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

                        Usuario novoUsuario = new Usuario(nome, cpf, email, senha, telefone, tipoUsuario, admin);
                        userRepo.adicionarUsuario(novoUsuario);
                        System.out.println("Usuário criado com sucesso!");
                    }
                    break;
                    
                    case 0:

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

                        System.out.println("Logout realizado.");
                        return; // volta ao menu principal
                default:

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

                    System.out.println("Opção inválida.");
            }

        } while (true);
    }
}
