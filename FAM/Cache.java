package FAM;

import java.util.Random;

public class Cache {
    private Noh inicio;
    private Random random;
    private int tamanhoMaximo;
    private Memory memory;

    public Cache(int tamanhoMaximo) {
        this.inicio = null;
        this.tamanhoMaximo = tamanhoMaximo;
        this.random = new Random();
        this.memory = new Memory(32);
    }

    public boolean contem(int endereco) {
        Noh atual = inicio;
        while (atual != null) {
            if (atual.getEndereco() == endereco) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public void substituir(int endereco) {
        Noh novo = new Noh(endereco);
        if (inicio == null) {
            inicio = novo;
        } else {
            // Gerar aleatoriamente a posição de substituição
            int posicao = random.nextInt(tamanho() + 1);

            if (posicao == 0) {
                novo.setProximo(inicio);
                inicio = novo;
            } else {
                Noh anterior = null;
                Noh atual = inicio;
                for (int i = 0; i < posicao; i++) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                anterior.setProximo(novo);
                novo.setProximo(atual);
            }

            if (tamanho() > tamanhoMaximo) {
                // Remover o endereço mais antigo se o cache estiver cheio
                Noh anterior = null;
                Noh atual = inicio;
                while (atual.getProximo() != null) {
                    anterior = atual;
                    atual = atual.getProximo();
                }
                if (anterior != null) {
                    anterior.setProximo(null);
                } else {
                    inicio = null;
                }
                int valor = memory.leitura(endereco);
                novo.setValor(valor);
            }
        }
    }

    public void imprimir() {
        System.out.println("Conteudo do Cache:");
        Noh atual = inicio;
        while (atual != null) {
            System.out.println("endereço: " + atual.getEndereco());
            atual = atual.getProximo();
        }
        System.out.println();
    }

    private int tamanho() {
        int tamanho = 0;
        Noh atual = inicio;
        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }
        return tamanho;
    }
}
