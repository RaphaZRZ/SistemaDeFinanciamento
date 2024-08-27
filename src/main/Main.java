/*
Próxima meta: Persistência de dados
 */

package main;

import painel.Painel;
import modelo.Financiamento;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Criação do ArrayList para salvar os dados de cada financiamento
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        new Painel(financiamentos, 0);
    }
}
