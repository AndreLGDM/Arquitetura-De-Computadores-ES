# Arquitetura de Computadores — Simulador de Cache

Projeto da disciplina de Arquitetura de Computadores (Engenharia de Software,
Unipampa). Contém um simulador de **memória cache totalmente associativa (FAM)**
em Java, além do código base da disciplina.

## Simulador de cache (`FAM/`)

Simula uma cache totalmente associativa: carrega a memória principal, processa
uma sequência de endereços (`Enderecos.txt`) e imprime os resultados. É
implementado com uma tabela hash e lista de nós.

- `Cache.java`, `MapaHash.java`, `Memory.java`, `Noh.java` — estrutura da cache
- `Main.java` — ponto de entrada
- `Enderecos.txt`, `MemoriaPrincipal.txt` — dados de entrada

## Como executar

A partir da raiz do repositório:

```bash
javac FAM/*.java
java FAM.Main
```

> `Main.java` referencia o caminho `FAM\Enderecos.txt` (separador do Windows).
> Em Linux/macOS, rode a partir da raiz do projeto ou ajuste o separador para `/`.

## Outros arquivos

A pasta `Arquitetura/` contém código anterior da disciplina (pacote `Arquitetura`).

## Estado atual

Projeto de disciplina.
