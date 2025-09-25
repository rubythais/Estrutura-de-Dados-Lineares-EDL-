public class PilhaColorida { // implementa duas pilhas independentes (ermelha e preta) usando um  array só
    private String[] array; 
    private int topVermelha;    
    private int topPreta;  /
    private int capacidade;

    public PilhaColorida(int capacidadeInicial) {
        this.capacidade = capacidadeInicial;
        this.array = new String[capacidadeInicial];
        this.topVermelha = -1;     //a pilha vermelha começa vazia
        this.topPreta = capacidadeInicial;  //a pilha preta começa vazia, igual a capacidade
    }


    public void pushVermelha(String elemento) {
        if (estaCheio()) redimensionar(capacidade * 2); // senão tem espaço entre as pilhas, dobra a capacidade do array
        topVermelha++;
        array[topVermelha] = elemento; // coloca o elemento no topo da linha vermelha
    }

    public String popVermelha() {
        if (isEmptyVermelha()) throw new RuntimeException("Pilha vermelha vazia!"); // garanteque não vai remover de uma pilha vermelha vazia
        String elem = array[topVermelha]; // Salva o elemento do topo para retornar
        topVermelha--;
        if (deveReduzir()) redimensionar(capacidade / 2);
        return elem;
    }

    public String topVermelha() {
        if (isEmptyVermelha()) throw new RuntimeException("Pilha vermelha vazia!");
        return array[topVermelha]; // sava o elemento do topo para retornar
    }

    public boolean isEmptyVermelha() { return topVermelha == -1; }




    public void pushPreta(String elemento) {
        if (estaCheio()) redimensionar(capacidade * 2);
        topPreta--;
        array[topPreta] = elemento; // coloca o elemento no topo da linha preta
    }

    public String popPreta() {
        if (isEmptyPreta()) throw new RuntimeException("Pilha preta vazia!"); // garanteque não vai remover de uma pilha preta vazia
        String elem = array[topPreta];
        topPreta++;
        if (deveReduzir()) redimensionar(capacidade / 2);
        return elem; 
    }

    public String topPreta() {
        if (isEmptyPreta()) throw new RuntimeException("Pilha preta vazia!");
        return array[topPreta];
    }

    public boolean isEmptyPreta() { return topPreta == capacidade; }
    private boolean estaCheio() {
        return topVermelha + 1 >= topPreta; // Retorna true se as pilhas se encontraram, ou seja, não tem mais espaco livre
    }

    private boolean deveReduzir() {
        int total = (topVermelha + 1) + (capacidade - topPreta);
        return capacidade > 10 && total <= capacidade / 3;
    }

    private void redimensionar(int novaCapacidade) {
        String[] novoArray = new String[novaCapacidade];

        for (int i = 0; i <= topVermelha;i++) {
            novoArray[i] = array[i];
        }

        int tamanhoPreto = capacidade - topPreta;
        int novoTopoPreto = novaCapacidade - tamanhoPreto;
        for (int i = 0; i < tamanhoPreto; i++) {
            novoArray[novoTopoPreto + i] = array[topPreta + i];
        }

        array = novoArray;
        capacidade = novaCapacidade;
        topPreta = novoTopoPreto;
    }

    public int sizeVermelha() { return topVermelha + 1; }
    public int sizePreta() { return capacidade - topPreta; }
    public int capacity() { return capacidade; }
}
