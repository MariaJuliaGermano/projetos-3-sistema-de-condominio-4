package model;

import abstrato.model.MensagemAbstract;

import java.time.LocalDateTime;
import java.util.UUID;

public class Mensagem extends MensagemAbstract{
    private final String id;
    private String remetente;
    private String destinatario;
    private String conteudo;
    private LocalDateTime dataHora;
    private boolean lida;

    public Mensagem(String remetente, String destinatario, String conteudo) { //para criar uma nova mensagem
        this.id = UUID.randomUUID().toString();
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
        this.dataHora = LocalDateTime.now();
        this.lida = false;
    }

    public Mensagem(String id, String remetente, String destinatario, String conteudo, String dataHora) { //para uma mensagem consultada
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;

        LocalDateTime time = LocalDateTime.parse(dataHora);
        this.dataHora = time;

        this.lida = false;
    }

    @Override
    public String getId() { return id; }
    
    @Override
    public String getRemetente() { return remetente; }
    
    @Override
    public String getDestinatario() { return destinatario; }
    
    @Override
    public String getConteudo() { return conteudo; }
    
    @Override
    public LocalDateTime getDataHora() { return dataHora; }
    
    @Override
    public boolean isLida() { return lida; }
    
    @Override
    public void setLida(boolean lida) { this.lida = lida; }
}
