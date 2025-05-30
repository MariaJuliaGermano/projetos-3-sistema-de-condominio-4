package view;

import abstrato.view.ChatViewAbstract;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import controller.ChatController;
import model.Mensagem;
import model.Usuario;
import repository.MensagemRepository;
import repository.UsuarioRepository;

public class ChatView extends ChatViewAbstract{
    private final Scanner scanner;
    private final ChatController chatController;

    public ChatView(Scanner scanner, UsuarioRepository userRepo, MensagemRepository mensagemRepo) {
        this.scanner = scanner;
        this.chatController = new ChatController(mensagemRepo, userRepo);
    }

    @Override
    public void exibirMenu(Usuario usuarioLogado) {
        int opcao;
        do {
            System.out.println("\n==== Chat do Condomínio ====");
            System.out.println("1 - Ver mensagens");
            System.out.println("2 - Enviar mensagem");
            System.out.println("3 - Ver moradores");
            System.out.println("0 - Voltar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    verMensagens();
                    break;
                case 2:
                    enviarMensagem(usuarioLogado);
                    break;
                case 3:
                    listarMoradores();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (true);
    }

    private void verMensagens() {
        List<Mensagem> mensagens = chatController.listarMensagensGrupo();
        
        if (mensagens.isEmpty()) {
            System.out.println("Não há mensagens no chat.");
            return;
        }
        
        System.out.println("\n=== Mensagens do Condomínio ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        for (Mensagem msg : mensagens) {
            String nomeRemetente = chatController.getNomeUsuario(msg.getRemetente());
            
            System.out.println("----------------------------------");
            System.out.println(nomeRemetente + " - " + msg.getDataHora().format(formatter));
            System.out.println(msg.getConteudo());
        }
        System.out.println("----------------------------------");
        
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private void enviarMensagem(Usuario usuarioLogado) {
        System.out.println("\n=== Nova Mensagem ===");
        System.out.println("Digite sua mensagem (ou 'cancelar' para voltar):");
        String conteudo = scanner.nextLine();
        
        if (conteudo.equalsIgnoreCase("cancelar")) {
            return;
        }
        
        chatController.enviarMensagemGrupo(usuarioLogado.getId(), conteudo);
        System.out.println("Mensagem enviada com sucesso!");
    }

    private void listarMoradores() {
        List<Usuario> usuarios = chatController.listarUsuarios();
        
        System.out.println("\n=== Moradores do Condomínio ===");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario.getNome() + " (" + usuario.getTipoUsuario() + ")");
        }
        
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}
