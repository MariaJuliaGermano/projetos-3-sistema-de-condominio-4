package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Mensagem {
    private final String id = UUID.randomUUID().toString();
    private String remetente;
    private String destinatario;
    private String conteudo;
    private LocalDateTime dataHora;
    private boolean lida;

    public Mensagem(String remetente, String destinatario, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
        this.dataHora = LocalDateTime.now();
        this.lida = false;
    }

    public String getId() { return id; }
    public String getRemetente() { return remetente; }
    public String getDestinatario() { return destinatario; }
    public String getConteudo() { return conteudo; }
    public LocalDateTime getDataHora() { return dataHora; }
    public boolean isLida() { return lida; }
    public void setLida(boolean lida) { this.lida = lida; }
}
