package FAM;

public class Main {
    public static void main(String[] args) {
        MapaHash cache = new MapaHash();
        cache.carregarMemoria();
        cache.simular("FAM\\Enderecos.txt");
        cache.imprimirResultados();
    }
}
