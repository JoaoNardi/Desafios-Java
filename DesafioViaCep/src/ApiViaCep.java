import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiViaCep {
    protected String enderecoUrl;
    protected String json;

    //constroi o endereco
    public ApiViaCep(String cep) {
        try {
            this.enderecoUrl = "http://viacep.com.br/ws/" + cep + "/json/";
            }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    // base https conecta api retorna body
    public void conectaApi() throws IOException, InterruptedException {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoUrl))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();

           } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }


    public String getJson() {
        return json;
    }

    @Override
    public String toString() {
        return json + '\'';
    }
}