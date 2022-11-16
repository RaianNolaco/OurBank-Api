package com.OurBank.OurBankApi.geral;

import java.util.Random;


public class ContaFunc {
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

    public static String agencia () {
        return "0081";
    }

    public static String codBanco () {
        return "217";
    }
}
