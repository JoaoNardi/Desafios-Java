public class Endereco {
    protected String cep;
    protected String logradouro;
    protected String complemento;
    protected String bairro;
    protected String localidade;
    protected String estado;
    protected String regiao;

    @Override
    public String toString() {
        return
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + localidade + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' ;
    }


}
