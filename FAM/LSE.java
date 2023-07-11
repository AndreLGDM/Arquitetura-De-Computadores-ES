package FAM;

public class LSE implements Lista {

    private Noh inicio;
    private int tamanho = 0;

    public Noh getInicio() {
        return inicio;
    }

    public LSE() {
        this.inicio = null;
    }

    @Override
    public void insereInicio(Object o) {
        Noh novo = new Noh(o);
        if (inicio == null)
            inicio = novo;
        else {
            novo.setProximo(inicio);
            inicio = novo;
        }

    }

    @Override
    public void insereFim(Object o) {
        Noh novo = new Noh(o);
        if (inicio == null)
            inicio = novo;
        else {
            Noh ultimo = null;
            for (Noh i = inicio; i != null; i = i.getProximo())
                ultimo = i;
            ultimo.setProximo(novo);
        }
    }

    @Override
    public boolean remove(Object o) {
        Noh ant = null, p;
        p = inicio;
        while (p != null && p.getObjeto() != o) { // busca
            ant = p;
            p = p.getProximo();
        }
        if (p == null)
            return false;
        if (ant == null)
            inicio = p.getProximo();
        else
            ant.setProximo(p.getProximo());
        return true;
    }

    @Override
    public int tamanho() {
        Noh temp = this.inicio;
        tamanho = 0;
        while (temp != null) {
            tamanho++;
            temp = temp.getProximo();
        }
        return tamanho;
    }

    @Override
    public void imprime() {
        Noh print = inicio;
        while (print != null) {
            System.out.print(print.getObjeto() + " ");
            print = print.getProximo();
        }
    }
}
