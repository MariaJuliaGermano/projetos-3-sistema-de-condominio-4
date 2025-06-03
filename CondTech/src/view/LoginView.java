package view;

import abstrato.view.LoginViewAbstract;

import java.util.Scanner;

import controller.LoginController;
import model.Usuario;
import repository.AreaReservadaRepository;
import repository.OcorrenciaRepository;
import repository.UsuarioRepository;
import repository.MensagemRepository;
import service.AuthService;

public class LoginView extends LoginViewAbstract{

    private final Scanner scanner;

    private final LoginController loginController;
    private final UsuarioRepository  userRepo;
    private final AreaReservadaRepository arRepo;
    private final OcorrenciaRepository ocRepo;
    private final MensagemRepository msgRepo;

    public LoginView(Scanner scanner, UsuarioRepository userRepo, AreaReservadaRepository arRepo, 
                    OcorrenciaRepository ocRepo, MensagemRepository msgRepo) {
        this.scanner = scanner;
        this.userRepo = userRepo;
        this.arRepo = arRepo;
        this.ocRepo = ocRepo;
        this.msgRepo = msgRepo;
        this.loginController = new LoginController(new AuthService(userRepo), userRepo);
    }

    @Override
    public void exibirMenu() {
        int opcao;

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

        do {
            System.out.println("\n==================================");
            System.out.println("        Bem-vindo a CondTech");
            System.out.println("==================================\n");
            System.out.println("1 - Fazer Login");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
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

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String Nome = scanner.nextLine();

                    System.out.print("Senha: ");
                    String Senha = scanner.nextLine();

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

                    Usuario usuarioLogado = loginController.fazerLogin(Nome, Senha);

                    if (usuarioLogado != null) {
                        System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                        new HomeView(scanner, userRepo, arRepo, ocRepo, msgRepo).exibirMenu(usuarioLogado);
                    } else {
                        System.out.println("Login falhou. Nome ou senha incorretos.");
                    }
                    break;

                case 0:
                    System.out.println("\nEncerrando o CondTech. Até logo!\n");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }
}
