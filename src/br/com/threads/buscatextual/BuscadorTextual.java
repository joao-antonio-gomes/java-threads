package br.com.threads.buscatextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscadorTextual implements Runnable {

    private String nomeArquivo;
    private String nome;

    public BuscadorTextual(String nomeArquivo,
            String nome) {
        this.nomeArquivo = nomeArquivo;
        this.nome = nome;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            int numeroLinha = 1;
            while (scanner.hasNextLine()) {
                numeroLinha++;
                String linha = scanner.nextLine();

                if (linha.toLowerCase().contains(nome.toLowerCase())) {
                    String mensagem = String.format("%s - %d - %s", nomeArquivo, numeroLinha, linha);
                    System.out.println(mensagem);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
