package com.jumbo.cliente;

import org.openswing.swing.mdi.client.*;

public class Fachada implements ClientFacade {

    public Fachada() {
    }

    public void getCadastroCliente(){
        new CadastroClienteController();
    }
}
