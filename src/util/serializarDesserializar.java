package util;

import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class serializarDesserializar {
    public static ArrayList<Financiamento> lerSerializado(String caminhoArquivo) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            financiamentos = (ArrayList<Financiamento>) inputStream.readObject();
        } catch (EOFException | FileNotFoundException e) {
            // Ignorada, indica fim do arquivo.
            // Se o arquivo não existir, o retorno será um array vazio.
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return financiamentos;
    }

    public static void serializar(ArrayList<Financiamento> financiamentos, String caminhoArquivo) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));
            outputStream.writeObject(financiamentos);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
