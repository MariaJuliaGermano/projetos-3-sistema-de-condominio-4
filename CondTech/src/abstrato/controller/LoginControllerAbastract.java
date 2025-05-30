package abstrato.controller;

import model.Usuario;

abstract public class LoginControllerAbastract {
    abstract public Usuario fazerLogin(String Nome, String Senha);
}
