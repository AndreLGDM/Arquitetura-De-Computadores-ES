package FAM;

public class Memory {
    private int tamanho;
    private int[] dados;

    public Memory(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int[] getDados() {
        return dados;
    }

    public void setDados(int[] dados) {
        this.dados = dados;
    }

    public int leitura(int endereco) {
        return dados[endereco];
    }

    public void gravar(int endereco, int valor) {
        dados[endereco] = valor;
    }
}
