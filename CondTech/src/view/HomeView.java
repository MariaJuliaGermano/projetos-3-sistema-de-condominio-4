package view;

import java.util.Scanner;

import controller.LoginController;
import model.Usuario;
import repository.AreaReservadaRepository;
import repository.UsuarioRepository;
import service.AuthService;

public class HomeView {
    private final Scanner scanner;

    private final LoginController loginController;
    private final UsuarioRepository  userRepo;
    private final AreaReservadaRepository arRepo;
    private final AuthService authService;

    public HomeView(Scanner scanner, LoginController loginController, UsuarioRepository userRepo, AreaReservadaRepository arRepo, AuthService authService) {
        this.scanner = scanner;
        this.loginController = loginController;
        this.userRepo = userRepo;
        this.arRepo = arRepo;
        this.authService = authService;
    }

    public void exibirMenu(Usuario usuarioLogado) {
        int opcao;
        do {
            System.out.println("\n========= Menu - CondTech =========");
            System.out.println("1 - Chat");
            System.out.println("2 - Ocorrencia");
            System.out.println("3 - Area Reservada");
            
            if (usuarioLogado.getAdmin()) {
                System.out.println("4 - Criar novo usuário");
            }
            
            System.out.println("0 - Logout");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
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

                        Usuario novoUsuario = new Usuario(nome, cpf, email, senha, telefone, tipoUsuario, admin);
                        userRepo.adicionarUsuario(novoUsuario);
                        System.out.println("Usuário criado com sucesso!");
                    }
                    break;
                    
                    case 0:
                        System.out.println("Logout realizado.");
                        return; // volta ao menu principal
                default:
                    System.out.println("Opção inválida.");
            }

        } while (true);
    }
}
