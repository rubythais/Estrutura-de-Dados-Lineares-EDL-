package Deque;

public class DequeSimplesmenteEncadeada implements Deque {
    private No cabeca; // Ponteiro para o início
    private No cauda;  // Ponteiro para o fim
    private int tamanho;

    public DequeSimplesmenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public int size() { return tamanho; }
    public boolean isEmpty() { return tamanho == 0; }

    // O(1): Rápido, como esperado
    public void insertFirst(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    // O(1): Rápido (usamos o ponteiro 'cauda')
    public void insertLast(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            cabeca = cauda = novoNo;
        } else {
            cauda.setProximo(novoNo);
            cauda = novoNo;
        }
        tamanho++;
    }

    // O(1): Rápido, como esperado
    public Object removeFirst() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cabeca.getDado();
        cabeca = cabeca.getProximo();
        
        if (cabeca == null) {
            cauda = null;
        }
        tamanho--;
        return dadoRemovido;
    }

    // O(n): Esta é a operação lenta, pois exige percorrer a lista
    public Object removeLast() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cauda.getDado();

        if (tamanho == 1) { // Caso trivial
            cabeca = cauda = null;
        } else {
            // Lógica O(n): Preciso achar o penúltimo nó para fazê-lo ser a nova cauda
            No atual = cabeca;
            // Percorre a lista até que o próximo nó seja a cauda atual
            while (atual.getProximo() != cauda) { 
                atual = atual.getProximo();
            }
            // 'atual' agora é o penúltimo
            atual.setProximo(null); // O penúltimo não aponta mais para a cauda antiga
            cauda = atual;          // Atualiza a cauda
        }
        tamanho--;
        return dadoRemovido;
    }

    // O(1)
    public Object first() throws DequeExcecao {
        if (isEmpty()) { throw new DequeExcecao("Deque vazio."); }
        return cabeca.getDado();
    }

    // O(1)
    public Object last() throws DequeExcecao {
        if (isEmpty()) { throw new DequeExcecao("Deque vazio."); }
        return cauda.getDado();
    }

    public void print() {
        No atual = cabeca;
        System.out.print("Deque Simplesmente: ");
        while (atual != null) {
            System.out.print("[" + atual.getDado() + "] ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
