package com.OurBank.OurBankApi.geral;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

// Está classe serve para inserir os dados do cartão como o numero e a data  de validade
public class CartaoFunc {

    // Este metodo gera uma numero de cartão aleatorio neste formato 0000 0000 0000 0000
    public static String numCartao () {
        Random rdn = new Random();
        
        String cartao = "";

        for (int i = 0; i < 4; i ++) {
            String numero = ""+ rdn.nextInt(9999);

            int tam = numero.length();
            if (tam < 4) {
                numero = Geral.adicionarZeros(numero, 4);
            }

            cartao += numero + " " ;
        }

        return cartao.substring(0, 19);
    }


    // Este metodo gera um cvc aleatorio neste formato 000
    public static String cvc () {
        Random rdm = new Random();

        String cvc = "";
        cvc = ""+ rdm.nextInt(999);

        if (cvc.length() < 3) {
            cvc = Geral.adicionarZeros(cvc, 3);
        }

        return cvc;

    }
    

    // Este metodo gera uma data de validado 6 anos a frente da criação do cartão
    public static String validade () {

        Date x = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(x);
        calendar.add(Calendar.YEAR, 6);
        calendar.add(Calendar.MONTH, -1);
        Date novaData = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        return sdf.format(novaData);
    }

}
