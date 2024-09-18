/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    // List<List<String>> linhas = new ArrayList<>();
    // linhas.add(Arrays.asList("123", "juca", "j@email"));
    // escreve(linhas, "usuarios.csv");
    public static void escreve(List<List<String>> linhas, String filename) {
        try {
            FileWriter arquivo = new FileWriter(filename, true);
            for (List<String> elem : linhas) {
                arquivo.append(String.join(",", elem));
                arquivo.append("\n");
            }
            arquivo.flush();
            arquivo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ArrayList<ArrayList<String>> linhas = le(usuarios.csv);
    public static ArrayList<ArrayList<String>> le(String pathname) {
        ArrayList<ArrayList<String>> linhas = new ArrayList<ArrayList<String>>(0);
        try {
            File entrada = new File(pathname);
            Scanner linha = new Scanner(entrada);

            while (linha.hasNext()) {
                String[] registro = linha.nextLine().split(",");

                ArrayList<String> list = new ArrayList<>(Arrays.asList(registro));
                linhas.add(list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public static void main(String[] args) {
        System.out.println("Cafeteira System");

        boolean continua = true;
        int opcao = 0;
        int id = 0;
        int tipo = 0;

        Scanner in = new Scanner(System.in);

        while (continua) {
            System.out.println("================");
            System.out.println("Digite 1: Para informações de usuário");
            System.out.println("Digite 2: Para histórico de cafés");
            System.out.println("Digite 3: Para informações da cafeteira");
            System.out.println("Digite 4: Para adicionar novo usuário");
            System.out.println("Digite 5: Para remover usuário");
            System.out.println("Digite 6: Para servir café");
            System.out.println("Digite 7: Para reabastecer cafeteira");
            System.out.println("Digite 8: Para sair");
            System.out.print("Sua opção: ");
            opcao = in.nextInt();

            if(opcao == 1) {
                System.out.print("Entre com o id do usuário: ");
                id = in.nextInt();
                //System.out.println("\tId " + id + " selecionado para informações de usuário");
                ArrayList<ArrayList<String>>  linhas = le("/home/aluno/BCD/aula1/usuarios.csv");
                for(ArrayList<String> linha : linhas) {
                    if(linha.get(0).equals(String.valueOf(id))){
                        System.out.println("Usuário: " + linha.get(0));
                        System.out.println("Nome: " + linha.get(1));
                        System.out.println("Email: " + linha.get(2));

                    }
                }
                System.out.println("-------------------------------------------------------------");

            } else if (opcao == 2) {
                System.out.print("Entre com o id do usuário: ");
                id = in.nextInt();
                ArrayList<ArrayList<String>> linhas = le("/home/aluno/BCD/aula1/consumo.csv");
                for (ArrayList<String> linha : linhas){
                    if(linha.get(0).equals(String.valueOf(id))){
                        System.out.println("Usuário: " + linha.get(0));
                        System.out.println("Cafés Consumidos: " + linha.get(1));
                        System.out.println("Timestamp: " + linha.get(2));
                    }
                }
                System.out.println("-------------------------------------------------------------");

            } else if (opcao == 3) {
                System.out.println("Informações da cafeteira:");
                System.out.println("\tÓtima cafeteira");
            } else if (opcao == 4) {
                System.out.println("Adicionando novo usuário:");
                System.out.print("Entre com o id do usuário: ");
                id = in.nextInt();
                System.out.println("\tUsuário de id " + id + " adicionado");
            } else if (opcao == 5) {
                System.out.println("Removendo usuário:");
                System.out.print("Entre com o id do usuário: ");
                id = in.nextInt();
                System.out.println("\tUsuário de " + id + " removido");
            } else if (opcao == 6) {
                System.out.println("Servindo café:");
                System.out.print("Entre com o id do usuário: ");
                id = in.nextInt();
                System.out.print("Entre com o tipo de café (1 ou 2): ");
                tipo = in.nextInt();
                System.out.println("\tId " + id + " servindo café tipo " + tipo);
            } else if (opcao == 7) {
                System.out.println("\tReabastecendo cafeteira ...");
            } else if (opcao == 8) {
                continua = false;
            }
        }
    }
}
