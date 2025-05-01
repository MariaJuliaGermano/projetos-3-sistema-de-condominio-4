import java.util.Scanner;

import controller.LoginController;
import model.AreaReservada;
import model.Usuario;
import repository.AreaReservadaRepository;
import repository.UsuarioRepository;
import service.AuthService;
import view.HomeView;
import view.LoginView;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository userRepo = new UsuarioRepository();
        AreaReservadaRepository arRepo = new AreaReservadaRepository();
        AuthService authService = new AuthService(userRepo);
        LoginController loginController = new LoginController(authService, userRepo);

        Usuario usuario1 = new Usuario( "admin", "12312312312", "admin@gmail.com", "admin", "12345678901", "1", true);

        userRepo.adicionarUsuario(usuario1);

        new LoginView(scanner, loginController, userRepo, arRepo, authService).exibirMenu();        

        scanner.close();
        
    }

}
