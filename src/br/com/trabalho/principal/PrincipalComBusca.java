package br.com.trabalho.principal;

import br.com.trabalho.models.CapturaFilme;

import java.io.IOException;


public class PrincipalComBusca {


    public static void main(String[] args) throws IOException, InterruptedException {

     CapturaFilme bora = new CapturaFilme();
     try {
         bora.setBusca();
     }catch(NullPointerException e){
         System.out.println("Erro Formatacao de numero");
         bora.setBusca();
     }
    }
}
