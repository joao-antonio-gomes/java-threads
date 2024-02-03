package br.com.threads;

import javax.swing.*;
import java.math.BigInteger;

/*
 * É melhor implementar a interface Runnable do que extender a classe Thread para
 * evitar o uso de herança por preguiça, herdando métodos que não vamos utilizar.
 */
public class TarefaMultiplicacao implements Runnable {

    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

    public TarefaMultiplicacao(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }
    @Override
    public void run() {
        long valor1 = Long.parseLong(primeiro.getText());
        long valor2 = Long.parseLong(segundo.getText());
        BigInteger calculo = BigInteger.valueOf(0L);

        for (int i = 0; i < valor1; i++) {
            for (int j = 0; j < valor2; j++) {
                calculo = calculo.add(BigInteger.valueOf(1L));
            }
        }

        resultado.setText(calculo.toString());
    }
}
