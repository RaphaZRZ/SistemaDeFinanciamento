package main;

import painel.PainelPrincipal;
import modelo.Financiamento;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "dadosFinanciamentos.arrayOBJ";
        // Leitura do ArrayList já serializado, caso inexistente, cria-se um novo ArrayList.
        ArrayList<Financiamento> financiamentos = util.serializarDesserializar.lerSerializado(caminhoArquivo);

        new PainelPrincipal(financiamentos, 0, caminhoArquivo);
    }
}
