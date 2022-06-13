package Entities;

// Para o futuro
public class Administrador {

    // Funcao para validar login de Admin
    public boolean Validarlogin(String senhaAdmin) {
        if (senhaAdmin.equals("admin")) {
            System.out.println("Administrador Logado !");
            return true;
        } else {
            System.err.println("Senha Incorreta ! Tente novamente");
            return false;
        }
    }

}
