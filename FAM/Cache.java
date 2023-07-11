package FAM;

import java.util.Random;

public class Cache {
    private Noh inicio;
    private Random random;

    public Cache() {
        this.inicio = null;
        this.random = new Random();
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
            int IndiceRandomico = random.nextInt(getTamanho() + 1);
            if (IndiceRandomico == 0) {
                novo.setProximo(inicio);
                inicio = novo;
            } else {
                Noh atual = inicio;
                for (int i = 1; i < IndiceRandomico; i++) {
                    atual = atual.getProximo();
                }
                novo.setProximo(atual.getProximo());
                atual.setProximo(novo);
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

    private int getTamanho() {
        int contador = 0;
        Noh atual = inicio;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }
}
