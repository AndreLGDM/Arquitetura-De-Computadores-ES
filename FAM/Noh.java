package FAM;

public class Noh {

    private int endereco;
    private int valor;
    private Noh proximo;

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Noh getProximo() {
        return proximo;
    }

    public void setProximo(Noh proximo) {
        this.proximo = proximo;
    }

    public Noh(int endereco) {
        this.endereco = endereco;
        this.proximo = null;
    }

}
