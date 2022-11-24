package com.OurBank.OurBankApi.geral;

import java.util.Random;

// Esta classe serve para gerar os numero aleatorios da conta
public class ContaFunc {

    // este metodo serve para gerar um numero de conta aleatorio neste formato 00000000-0
    public static String numConta () {
        Random rdn = new Random();
        
        String numero = "";
        for (int i = 0; i < 10; i++) {
            numero = numero + rdn.nextInt((9));
        }

        String num = numero.substring(0, 8);
        num += "-" + numero.substring(9);

        return num;
    }

    // Este metodo retorna o numero correspondente a agencia do banco ourbank
    public static String agencia () {
        return "0081";
    }

    //este metodo retorna o numero correspondente ao banco ourbank
    public static String codBanco () {
        return "217";
    }
}
