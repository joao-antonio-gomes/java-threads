package br.com.threads.buscatextual;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String nome = "da";

        Thread threadBuscaAssinaturas1 = new Thread(new BuscadorTextual("assinaturas1.txt", nome));
        Thread threadBuscaAssinaturas2 = new Thread(new BuscadorTextual("assinaturas2.txt", nome));
        Thread threadAutores = new Thread(new BuscadorTextual("autores.txt", nome));

        List<Thread> threadList = Stream.of(threadAutores, threadBuscaAssinaturas1, threadBuscaAssinaturas2).toList();

        threadList.forEach(Thread::start);
    }
}
