import java.util.Scanner;

import model.Usuario;
import repository.AreaReservadaRepository;
import repository.OcorrenciaRepository;
import repository.UsuarioRepository;
import view.LoginView;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioRepository userRepo = new UsuarioRepository();
        AreaReservadaRepository arRepo = new AreaReservadaRepository();
        OcorrenciaRepository ocRepo = new OcorrenciaRepository();

        Usuario usuario1 = new Usuario( "admin", "12312312312", "admin@gmail.com", "admin", "12345678901", "1", true);

        userRepo.adicionarUsuario(usuario1);

        new LoginView(scanner, userRepo, arRepo, ocRepo).exibirMenu();        

        scanner.close();
        
    }

}
