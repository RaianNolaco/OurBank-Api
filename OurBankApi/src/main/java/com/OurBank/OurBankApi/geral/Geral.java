package com.OurBank.OurBankApi.geral;

public class Geral {

    // este metodo preenche os numeros de cartão e conta caso faltem numero 
    public static String adicionarZeros (String numero, int tam) {

        int tamanho = numero.length();
        for (int i = 0; i < tam - tamanho; i++) {
            numero = "0" + numero;
        }

        return numero;
    }
}
