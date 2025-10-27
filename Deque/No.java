package Deque;

public class No {
    private Object dado;
    private No proximo;
    private No anterior; // Importante para o Deque Duplamente Encadaeado (permite voltar)

    public No(Object dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

    // Métodos de acesso
    public Object getDado() { return dado; }
    public void setDado(Object dado) { this.dado = dado; }

    public No getProximo() { return proximo; }
    public void setProximo(No proximo) { this.proximo = proximo; }

    public No getAnterior() { return anterior; }
    public void setAnterior(No anterior) { this.anterior = anterior; }
}
