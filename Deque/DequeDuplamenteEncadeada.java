package Deque;

public class DequeDuplamenteEncadeada implements Deque {
    private No cabeca; // Ponteiro para o início (fácil acesso ao 'first')
    private No cauda;  // Ponteiro para o fim (fácil acesso ao 'last')
    private int tamanho;

    public DequeDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public int size() { return tamanho; }
    public boolean isEmpty() { return tamanho == 0; }

    // O(1): Inserir no início é rápido
    public void insertFirst(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setProximo(cabeca);   // Novo nó aponta para o nó que era a cabeça
            cabeca.setAnterior(novoNo);  // A cabeça antiga aponta de volta para o novo nó
            cabeca = novoNo;             // Atualiza a cabeça
        }
        tamanho++;
    }

    // O(1): Inserir no fim é rápido
    public void insertLast(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setAnterior(cauda);  // Novo nó aponta para a cauda antiga
            cauda.setProximo(novoNo);   // Cauda antiga aponta para o novo nó
            cauda = novoNo;             // Atualiza a cauda
        }
        tamanho++;
    }

    // O(1): Remover do início é rápido
    public Object removeFirst() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cabeca.getDado();
        cabeca = cabeca.getProximo(); // A nova cabeça é o próximo nó
        
        if (cabeca != null) {
            cabeca.setAnterior(null); // Remove a referência 'anterior' do novo nó inicial
        } else {
            cauda = null; // Lista vazia
        }
        tamanho--;
        return dadoRemovido;
    }

    // O(1): Remover do fim é rápido (graças ao ponteiro 'anterior')
    public Object removeLast() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cauda.getDado();
        cauda = cauda.getAnterior(); // A nova cauda é o nó anterior
        
        if (cauda != null) {
            cauda.setProximo(null); // Remove a referência 'proximo' do novo nó final
        } else {
            cabeca = null; // Lista vazia
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
        System.out.print("Deque Duplamente: ");
        while (atual != null) {
            System.out.print("[" + atual.getDado() + "] ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
