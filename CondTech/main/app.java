package main;
import avisos.QuadroAvisos;
import comunicacaoInterna.Chat;
import comunicacaoInterna.Mensagem;

import java.util.Scanner;

public class app{

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Bem vindo ao CondTech!");
        final Usuario usuario = new Usuario("12345678910", "teste", "2");
        final Mensagem mensagemPadrao = new Mensagem(usuario, "esta é a mensagem padrao, adicione mensagens para dar continuidade ao chat");
        final Chat chatInterno = new Chat(mensagemPadrao);
        final QuadroAvisos quadroAvisos = new QuadroAvisos(usuario, mensagemPadrao);

        while(true){
            System.out.print("\nqual o seu nome? ");
            String userResponse;
            userResponse = scan.nextLine();

            try{
                usuario.setNome(userResponse);
            }
            catch(IllegalArgumentException a){
                System.out.println(a.getMessage());
                continue;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        while(true){
            System.out.print("\nqual o seu CPF? ");
            String userResponse;
            userResponse = scan.nextLine();

            try{
                usuario.setCpf(userResponse);
            }
            catch(IllegalArgumentException a){
                System.out.println(a.getMessage());
                continue;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        while(true){
            System.out.println("\nqual ao seu email para contato? ");
            String userResponse;
            userResponse = scan.nextLine();

            try{
                usuario.setEmail(userResponse);
            }
            catch(IllegalArgumentException a){
                System.out.println(a.getMessage());
                continue;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        while(true){
            System.out.println("\ndigite uma senha para o seu perfil: ");
            String userResponse;
            userResponse = scan.nextLine();

            try{
                usuario.setSenha(userResponse);
            }
            catch(IllegalArgumentException a){
                System.out.println(a.getMessage());
                continue;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        while(true){
            System.out.println("\ndigite um telefone para contato: ");
            String userResponse;
            userResponse = scan.nextLine();

            try{
                usuario.setTelefone(userResponse);
            }
            catch(IllegalArgumentException a){
                System.out.println(a.getMessage());
                continue;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        while(true){
            System.out.println("\nqual ao seu categoria de usuário?\n\n[1] Condômino\n[2] Sindico\n[3] Funcionário\n\n");
            String userResponse;
            userResponse = scan.nextLine();

            try{
                usuario.setTipoUsuario(userResponse);
            }
            catch(IllegalArgumentException a){
                System.out.println(a.getMessage());
                continue;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }

        while(true){
            System.out.print("\nqual ação você deseja realizar?\n\n[1]acessar o chat de conversas\n[2]acessar o quadro de avisos\n[3] sair do programa\n\n");
            String userResponse;
            int userSwitch = 0;
            userResponse = scan.nextLine();

            try{
                userSwitch = Integer.parseInt(userResponse);
            }
            catch(NumberFormatException n){
                System.out.println("\nsua resposta deve ser numérica, tente novamente");
            }
            catch(Exception e){
                System.out.println("\num erro inesperado ocorreu, tente novamente");
            }

            switch (userSwitch) {
                case 1:

                    while(true){
                        System.out.print("\no que você deseja fazer?\n\n[1] consultar as mensagens do chat\n[2] enviar uma mensagen\n[3] deletar uma mensagem\n[4] sair do chat de conversas\n\n");
                        String userChat;
                        int chatSwitch = 0;
                        userChat = scan.nextLine();

                        try{
                            chatSwitch = Integer.parseInt(userChat);
                        }
                        catch(NumberFormatException n){
                            System.out.println("\nsua resposta deve ser numérica, tente novamente");
                        }
                        catch(Exception e){
                            System.out.println("\num erro inesperado ocorreu, tente novamente");
                        }

                        switch (chatSwitch) {
                            case 1:
                                Mensagem mensagenChat[] = chatInterno.getMensagens();
                                System.out.print("\n");
                                for(Mensagem mensagem : mensagenChat){
                                    System.out.println("\n" + mensagem.getMensagem() + "\nid: " + mensagem.getId());
                                }
                                break;
                            
                            case 2:
                                Mensagem userMensagem = new Mensagem(usuario, "temp");
                                while(true){
                                    System.out.println("\ndigite um texto para a sua mensagem: ");
                                    String userTextoMensagem = scan.nextLine();

                                    try{
                                        userMensagem.setMensagem(userTextoMensagem);
                                    }
                                    catch(IllegalArgumentException i){
                                        System.out.println(i.getMessage());
                                        continue;
                                    }
                                    catch(Exception e){
                                        System.out.println("um erro inesperado ocorreu ao tentar definir o texto da sua mensagem, tente novamente");
                                        continue;
                                    }

                                    break;
                                }

                                chatInterno.addMensagem(userMensagem);
                                System.out.println("\n sua mensagem foi adicionada com sucesso!");

                                break;

                            case 3:
                                Mensagem mensagensChat[] = chatInterno.getMensagens();
                                int controle = 0;
                                
                                while(controle != 1){
                                    System.out.println("digite o id da mensagem que você deseja apagar: ");
                                    String deleteResponse;
                                    deleteResponse = scan.nextLine();

                                    for(Mensagem mensagem : mensagensChat){
                                        if(mensagem.getId().equals(deleteResponse)){
                                            //System.out.println("teste");
                                            chatInterno.removeMensagem(mensagem);
                                            System.out.println("\nmensagem removida com sucesso!");
                                            controle = 1;
                                        }
                                    }

                                    if(controle != 1){
                                        System.out.println("\nnão existe uma mensagem com id correspondente ao is digitado, tente novamente");
                                    }
                                }
                                break;
                            default:
                                if(chatSwitch != 4){
                                    System.out.println("\nSua resposta deve coreesponder a uma das opções, tente novamente");
                                }
                                break;
                        }

                        if(chatSwitch == 4){
                            break;
                        }
                    }
                    break;
                
                case 2:
                    while(true){
                        System.out.print("\no que você deseja fazer?\n\n[1] consultar os avisos\n[2] criar um novo aviso\n[3] deletar um aviso\n[4] sair quadro de avisos\n\n");
                        String userAvisos;
                        int avisosSwitch = 0;
                        userAvisos = scan.nextLine();

                        try{
                            avisosSwitch = Integer.parseInt(userAvisos);
                        }
                        catch(NumberFormatException n){
                            System.out.println("\nsua resposta deve ser numérica, tente novamente");
                        }
                        catch(Exception e){
                            System.out.println("\num erro inesperado ocorreu, tente novamente");
                        }

                        switch (avisosSwitch) {
                            case 1:
                                Mensagem mensagenAvisos[] = quadroAvisos.getMensagens();
                                System.out.print("\n");
                                for(Mensagem mensagem : mensagenAvisos){
                                    System.out.println("\n" + mensagem.getMensagem() + "\nid: " + mensagem.getId());
                                }
                                break;
                            
                            case 2:
                                if(usuario.getTipoUsuario().equals("Síndico")){
                                    Mensagem userMensagem = new Mensagem(usuario, "temp");
                                    while(true){
                                        System.out.println("\ndigite um texto para a seu aviso: ");
                                        String userTextoMensagem = scan.nextLine();

                                        try{
                                            userMensagem.setMensagem(userTextoMensagem);
                                        }
                                        catch(IllegalArgumentException i){
                                            System.out.println(i.getMessage());
                                            continue;
                                        }
                                        catch(Exception e){
                                            System.out.println("\num erro inesperado ocorreu ao tentar definir o texto da seu aviso, tente novamente\n");
                                            continue;
                                        }

                                        break;
                                    }
                                    
                                    quadroAvisos.addMensagem(userMensagem);
                                    System.out.println("\n seu aviso foi adicionada com sucesso!");
                                    break;
                                } else{
                                    System.out.println("\nvoce não possui autorização para adicionar avisos, apenas síndicos podem adicionar avisos");
                                    break;
                                }

                            case 3:
                                Mensagem mensagensAvisos[] = quadroAvisos.getMensagens();
                                int controle = 0;
                                
                                while(controle != 1){
                                    System.out.println("digite o id do aviso que você deseja apagar: ");
                                    String deleteResponse;
                                    deleteResponse = scan.nextLine();

                                    for(Mensagem mensagem : mensagensAvisos){
                                        if(mensagem.getId().equals(deleteResponse)){
                                            quadroAvisos.removeMensagen(mensagem);
                                            System.out.println("\naviso removido com sucesso!");
                                            controle = 1;
                                        }
                                    }

                                    if(controle != 1){
                                        System.out.println("\nnão existe um aviso com id correspondente ao id digitado, tente novamente");
                                    }
                                }
                                break;
                            default:
                                if(avisosSwitch != 4){
                                    System.out.println("\nSua resposta deve coresponder a uma das opções, tente novamente");
                                }
                                break;
                        }

                        if(avisosSwitch == 4){
                            break;
                        }
                    }
                    break;

                default:
                    if(userSwitch != 3){
                        System.out.println("\nSua resposta deve coresponder a uma das opções, tente novamente");
                    }
                    break;
            }

            if(userSwitch == 3){
                break;
            }
        }

        System.out.println("\nobrigado por usar a nossa aplicação, volte sempre que quiser!");

    }
}