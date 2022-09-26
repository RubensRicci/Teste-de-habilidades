package com.mycompany.ex2emjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ex2EmJava {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner tecla = new Scanner(System.in);
        
        System.out.println("Informe a localização do arquivo list.txt");
        System.out.println("O caminho deve estar assim: /Users/ruben/Documents/NetBeansProjects/ex2EmJava/list.txt \n");
        System.out.print("Caminho: ");
        String caminho = tecla.nextLine();
        
        String[] nomes = leArquivo(caminho);
        String[] UserName = geradorDeNome(nomes);
        String[] resulFinal = juntaUserESenha(UserName);
        geraCsv(resulFinal);
        
    }
    
    public static String[] leArquivo(String caminho) throws FileNotFoundException {
        if (caminho.equals("")) {
            System.out.println("\n O Caminho estava vazio \n");
            System.exit(0);
        }
        File arquivo = new File(caminho);
        Scanner scan = new Scanner(arquivo);
        int numLinhas = 0;
       
        while(scan.hasNextLine()) {
            scan.nextLine();
            numLinhas++;
        }
        scan = new Scanner(arquivo);
        String[] linhas = new String[numLinhas];
        
        for (int i = 0; i < numLinhas; i++) {
            linhas[i] = scan.nextLine();
        }
        return linhas;
    }
    
    public static String geradorDeSenha(){
        Random random = new Random();
        String password;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 4; i++) {
            char randomizedCharacter;
            if (random.nextInt(9) < 5) {
                randomizedCharacter = (char) (random.nextInt(26) + 'A');    
            }
            else{
                randomizedCharacter = (char) (random.nextInt(26) + 'a');
            }
            sb.append(randomizedCharacter);
        }
        for (int i = 0; i < 4; i++) {
            int j = random.nextInt(9);
            sb.append(j);    
        }
        password = sb.toString();
        return password;
    }
    
    public static String[] geradorDeNome (String[] nomes){
        String[] usserName = new String [nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            int espaco = nomes[i].indexOf(' ');
            usserName[i] = nomes[i].substring(0, espaco) + ".";
            usserName[i] += nomes[i].substring(espaco+1);
            usserName[i] += "@matchit.com.br";
            usserName[i] = usserName[i].toLowerCase();
        }
        return usserName;
    }
    
    public static String[] juntaUserESenha (String[] userName){
        String[] linhaUser = new String[userName.length];
        
        for (int i = 0; i < userName.length; i++) {
            linhaUser[i] = userName[i] +";"+ geradorDeSenha();
        }
        
        return linhaUser;
    }
    
    public static void geraCsv(String[] resulFinal) throws IOException{
        List<String[]> linhas = new ArrayList<>();
        for (int i = 0; i < resulFinal.length; i++) {
            linhas.add(new String[]{resulFinal[i]});
        }

        Writer writer = Files.newBufferedWriter(Paths.get("list.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeAll(linhas);
        csvWriter.flush();
        writer.close();
    }
    
    
}
