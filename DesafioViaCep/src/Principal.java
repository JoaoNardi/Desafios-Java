import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        //cria o gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Instancia Scanner
        Scanner leitura = new Scanner(System.in);
        //inicializa cep vazio
        var cepBuscado = "";
        //cria lista para objeto
        List<Endereco> lista = new ArrayList<>();
        //Inicializa o gravador de aquivos e define local e nome
        FileWriter gravaJson = new FileWriter("Endereços.json");

        System.out.println("********************Busca CEP*********************");

        //cria um loop
        while (true) {
            try {
                // Capturar o cep a ser buscado

                System.out.println("Digite o cep a ser buscado!");
                System.out.println("(ou digite *sair* para encerrar a aplicacao e salvar o arquivo .json.)");
                cepBuscado = leitura.nextLine();

                //Saida do loop para encerrar o programa
                if (cepBuscado.equalsIgnoreCase("sair")) {
                    break;
                }

                //Verifica se o cep é valido
                if (cepBuscado.length() != 8){
                    System.out.println("ATENÇÃO!");
                    System.out.println("Digite um cep valido!");
                    System.out.println("(Um cep deve conter 8 digitos)");
                    System.out.println(" " +
                            " " +
                            " ");
                    continue;
                }



                //Aplica o cep buscado na classe que possui a api https
                ApiViaCep cepApi = new ApiViaCep(cepBuscado);
                cepApi.conectaApi();
                if (cepApi.json.contains("erro") || cepApi.json == null){
                    throw new RuntimeException("Erro ao acessar api: cep invalido");
                } else {
                    System.out.println("Cep " + cepBuscado + " consultado com sucesso");
                }

                    //traduz json para parametros locais
                    Endereco cepApiLocal = gson.fromJson(cepApi.getJson(), Endereco.class);

                    //adiciona o json cep a lista
                lista.add(cepApiLocal);
                }catch (RuntimeException e){
                System.out.println(e.getMessage());

            }
        }
        //fecha leitra para nao vazar
        leitura.close();

        // cria gson para json
        // escreve e fecha arquivo gravado
        gravaJson.write(gson.toJson(lista));
        System.out.println("Dados gravado com sucesso!");
        gravaJson.close();
    }
}