package view;

import java.util.Scanner;

import controller.LoginController;
import model.Usuario;
import repository.AreaReservadaRepository;
import repository.UsuarioRepository;
import service.AuthService;
import view.HomeView;

public class LoginView {

    private final Scanner scanner;

    private final LoginController loginController;
    private final UsuarioRepository  userRepo;
    private final AreaReservadaRepository arRepo;
    private final AuthService authService;

    public LoginView(Scanner scanner, LoginController loginController, UsuarioRepository userRepo, AreaReservadaRepository arRepo, AuthService authService) {
        this.scanner = scanner;
        this.loginController = loginController;
        this.userRepo = userRepo;
        this.arRepo = arRepo;
        this.authService = authService;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n==================================");
            System.out.println("        Bem-vindo a CondTech");
            System.out.println("==================================\n");
            System.out.println("1 - Fazer Login");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String Nome = scanner.nextLine();

                    System.out.print("Senha: ");
                    String Senha = scanner.nextLine();

                    Usuario usuarioLogado = loginController.fazerLogin(Nome, Senha);

                    if (usuarioLogado != null) {
                        System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                        new HomeView(scanner, loginController, userRepo, arRepo, authService).exibirMenu(usuarioLogado);
                    } else {
                        System.out.println("Login falhou. Nome ou senha incorretos.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o CondTech. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}
