package controller;

import java.util.List;

import model.Mensagem;
import model.Usuario;
import repository.MensagemRepository;
import repository.UsuarioRepository;

public class ChatController {
    private final MensagemRepository mensagemRepo;
    private final UsuarioRepository usuarioRepo;

    public ChatController(MensagemRepository mensagemRepo, UsuarioRepository usuarioRepo) {
        this.mensagemRepo = mensagemRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public void enviarMensagemGrupo(String idRemetente, String conteudo) {
        Mensagem mensagem = new Mensagem(
            idRemetente, 
            MensagemRepository.getIdGrupo(), 
            conteudo
        );
        mensagemRepo.adicionarMensagem(mensagem);
    }

    public List<Mensagem> listarMensagensGrupo() {
        return mensagemRepo.listarMensagensGrupo();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepo.listarUsuarios();
    }
    
    public String getNomeUsuario(String id) {
        for (Usuario usuario : usuarioRepo.listarUsuarios()) {
            if (usuario.getId().equals(id)) {
                return usuario.getNome();
            }
        }
        return "Usuário Desconhecido";
    }
}