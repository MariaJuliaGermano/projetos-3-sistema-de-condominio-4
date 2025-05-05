package view;

import java.util.Scanner;

import controller.LoginController;
import model.Usuario;
import repository.AreaReservadaRepository;
import repository.OcorrenciaRepository;
import repository.UsuarioRepository;
import service.AuthService;

public class LoginView {

    private final Scanner scanner;

    private final LoginController loginController;
    private final UsuarioRepository  userRepo;
    private final AreaReservadaRepository arRepo;
    private final OcorrenciaRepository ocRepo;

    public LoginView(Scanner scanner, UsuarioRepository userRepo, AreaReservadaRepository arRepo, OcorrenciaRepository ocRepo) {
        this.scanner = scanner;
        this.loginController = new LoginController(new AuthService(userRepo), userRepo);
        this.userRepo = userRepo;
        this.arRepo = arRepo;
        this.ocRepo = ocRepo;
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
                        new HomeView(scanner, userRepo, arRepo, ocRepo).exibirMenu(usuarioLogado);
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
