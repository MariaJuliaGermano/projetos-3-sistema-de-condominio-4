import java.util.Scanner;

import controller.LoginController;
import model.Usuario;
import repository.UsuarioRepository;
import service.AuthService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository repo = new UsuarioRepository();

        Usuario usuario1 = new Usuario( "admin", "12312312312", "admin@gmail.com", "admin", "12345678901", "1", true);

        repo.adicionarUsuario(usuario1);

        AuthService authService = new AuthService(repo);
        LoginController controller = new LoginController(authService, repo);

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

                    Usuario usuarioLogado = controller.fazerLogin(Nome, Senha);

                    if (usuarioLogado != null) {
                        System.out.println("\nLogin realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
                        mostrarMenuUsuario(scanner, usuarioLogado, repo);
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

        scanner.close();
        
    }

    private static void mostrarMenuUsuario(Scanner scanner, Usuario usuarioLogado, UsuarioRepository repo) {
        int opcao;
        do {
            System.out.println("\n========= Menu - CondTech =========");
            System.out.println("1 - Logout");

            if (usuarioLogado.getAdmin()) {
                System.out.println("2 - Criar novo usuário");
            }

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Logout realizado.");
                    return; // volta ao menu principal

                case 2:
                    if (usuarioLogado.getAdmin()) {
                        System.out.print("Nome do novo usuário: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Senha: ");
                        String novaSenha = scanner.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();

                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("É admin? (true/false): ");
                        boolean isAdmin = scanner.nextBoolean();
                        scanner.nextLine(); // limpar buffer

                        Usuario novoUsuario = new Usuario(novoNome, cpf, email, novaSenha, telefone, id, isAdmin);
                        repo.adicionarUsuario(novoUsuario);
                        System.out.println("Usuário criado com sucesso!");
                    } else {
                        System.out.println("Acesso negado. Apenas administradores podem criar usuários.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (true);
    }
}
