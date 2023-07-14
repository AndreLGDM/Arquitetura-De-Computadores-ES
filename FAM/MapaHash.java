package FAM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapaHash {
    private Cache cache;
    private Memory memory;
    private int hits;
    private int misses;
    private int leituras;

    public MapaHash() {
        this.cache = new Cache(8);
        this.memory = new Memory(32);
        this.hits = 0;
        this.misses = 0;
        this.leituras = 0;
    }

    public void carregarMemoria() {
        try (BufferedReader reader = new BufferedReader(new FileReader("FAM\\MemoriaPrincipal.txt"))) {
            String linhas;
            int endereco = 0;

            while ((linhas = reader.readLine()) != null) {
                int valor = Integer.parseInt(linhas.trim(), 2);
                memory.gravar(endereco, valor);
                endereco++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simular(String Arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Arquivo))) {
            String linhas;

            while ((linhas = reader.readLine()) != null) {
                int endereco = Integer.parseInt(linhas.trim(), 2);

                if (cache.contem(endereco)) {
                    this.hits++;
                } else {
                    this.misses++;
                    cache.substituir(endereco);
                }

                this.leituras++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imprimirResultados() {
        int totalEntradas = hits + misses;
        double indiceDeErro = (double) misses / totalEntradas;
        double indiceDeExitos = (double) hits / totalEntradas;

        System.out.println("Total Leituras: " + this.leituras);
        System.out.println("Cache hits: " + this.hits);
        System.out.println("Cache Misses: " + this.misses);
        System.out.println("Miss rate: " + indiceDeErro * 100 + "%");
        System.out.println("Hit rate: " + indiceDeExitos * 100 + "%");
    }
}
