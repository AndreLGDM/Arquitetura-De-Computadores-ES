package FAM;

public class Main {
    public static void main(String[] args) {
        MapaHash cache = new MapaHash();
        cache.simular("FAM\\Enderecos.txt");
        cache.imprimirResultados();
    }
}
