package Deque;

public interface Deque {
    // Retorna o número de elementos no Deque
    public int size();
    // Verifica se o Deque está vazio
    public boolean isEmpty();
    // Insere um elemento no final do Deque
    public void insertLast(Object o);
    // Insere um elemento no início do Deque
    public void insertFirst(Object o);
    // Remove e retorna o primeiro elemento (lança exceção se vazio)
    public Object removeFirst() throws DequeExcecao;
    // Remove e retorna o último elemento (lança exceção se vazio)
    public Object removeLast() throws DequeExcecao;
    // Retorna (mas não remove) o primeiro elemento
    public Object first() throws DequeExcecao;
    // Retorna (mas não remove) o último elemento
    public Object last() throws DequeExcecao; 
    // Exibe o conteúdo do Deque
    public void print();
}
