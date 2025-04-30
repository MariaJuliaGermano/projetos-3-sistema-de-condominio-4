import java.util.Scanner;

import controller.LoginController;
import model.Usuario;
import repository.UsuarioRepository;
import service.AuthService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository repo = new UsuarioRepository();

        Usuario usuario1 = new Usuario( "João Silva", "12312312312", "joao@gmail.com", "senha123", "12345678901", "1");
        Usuario usuario2 = new Usuario( "Maria", "12312312312", "maria@gmail.com", "senha456", "98765432101", "2");

        repo.adicionarUsuario(usuario1);
        repo.adicionarUsuario(usuario2);

        AuthService authService = new AuthService(repo);
        LoginController controller = new LoginController(authService);

        int opcao;
        do {
            System.out.println("\n==================================");
            System.out.println("        Bem-vindo a CondTech");
            System.out.println("==================================\n");
            System.out.println("1 - Fazer Login");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String Nome = scanner.nextLine();

                    System.out.print("Senha: ");
                    String Senha = scanner.nextLine();

                    controller.fazerLogin(Nome, Senha);
                    break;

                case 0:
                    System.out.println("Encerrando o CondTech. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
        
    }
}
