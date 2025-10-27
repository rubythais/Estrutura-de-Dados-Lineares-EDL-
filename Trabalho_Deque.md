# EDL: Deque com Listas
## Tâmara Thais - Matricula: 20232014040040

## 1: Implementações do Deque (Código Fonte)

### 1.1. Arquivo: Deque.java (Interface)

```java
package Deque;

public interface Deque {
    public int size();
    public boolean isEmpty();
    public void insertLast(Object o);
    public void insertFirst(Object o);
    public Object removeFirst() throws DequeExcecao;
    public Object removeLast() throws DequeExcecao;
    public Object first() throws DequeExcecao;
    public Object last() throws DequeExcecao; 
    public void print();
}
```

### 1.2. Arquivo: No.java (Estrutura do Nó)

```java
package Deque;

public class No {
    private Object dado;
    private No proximo;
    private No anterior; // usado pela lista Duplamente Encadaeada p acesso O(1) ao nó anterior

    public No(Object dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

    // metodos de acesso
    public Object getDado() { return dado; }
    public void setDado(Object dado) { this.dado = dado; }

    public No getProximo() { return proximo; }
    public void setProximo(No proximo) { this.proximo = proximo; }

    public No getAnterior() { return anterior; }
    public void setAnterior(No anterior) { this.anterior = anterior; }
}
```

### 1.3. Arquivo: DequeDuplamenteEncadeada.java

```java
package Deque;

public class DequeDuplamenteEncadeada implements Deque {
    private No cabeca; // ponteiro pra o início do Deque
    private No cauda;  // ponteiro pra o fim do Deque
    private int tamanho;

    public DequeDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public int size() { return tamanho; }
    public boolean isEmpty() { return tamanho == 0; }

    // O(1): Inserir no início
    public void insertFirst(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setProximo(cabeca);   // 1. novo nó 
            cabeca.setAnterior(novoNo);  // 2. Cabeca antiga aponta de volta
            cabeca = novoNo;             // 3. atualiza a cabeça
        }
        tamanho++;
    }

    // O(1): inserir no fim
    public void insertLast(Object o) {
        No novoNo = new No(o);
        if (isEmpty()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setAnterior(cauda);  // 1. novo nó aponta pra a cauda antiga
            cauda.setProximo(novoNo);   // 2. cauda antiga aponta pra o novo nó
            cauda = novoNo;             // 3. atualiza a cauda
        }
        tamanho++;
    }

    public Object removeFirst() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cabeca.getDado();
        cabeca = cabeca.getProximo(); //
        
        if (cabeca != null) {
            cabeca.setAnterior(null); // remove a referencia circular do novo nó inicial
        } else {
            cauda = null; // lista vazia
        }
        tamanho--;
        return dadoRemovido;
    }

    // O(1): remover do fim
    public Object removeLast() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cauda.getDado();
        cauda = cauda.getAnterior(); // a nova cauda é o nó anterior
        
        if (cauda != null) {
            cauda.setProximo(null); // remove a referência 'proximo' do novo nó final
        } else {
            cabeca = null; // Lista vazia
        }
        tamanho--;
        return dadoRemovido;
    }

    // Consultas O(1)
    public Object first() throws DequeExcecao {
        if (isEmpty()) { throw new DequeExcecao("Deque vazio."); }
        return cabeca.getDado();
    }

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
```

### 1.4. Arquivo: DequeSimplesmenteEncadeada.java

```java
package Deque;

public class DequeSimplesmenteEncadeada implements Deque {
    private No cabeca; // ponteiro pra o inicio
    private No cauda;  // ponteiro ppra o fim
    private int tamanho;

    public DequeSimplesmenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public int size() { return tamanho; }
    public boolean isEmpty() { return tamanho == 0; }

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


    public Object removeLast() throws DequeExcecao {
        if (isEmpty()) {
            throw new DequeExcecao("Deque vazio.");
        }
        Object dadoRemovido = cauda.getDado();

        if (tamanho == 1) { // Caso trivial
            cabeca = cauda = null;
        } else {
            // A busca O(n) acontece aqui: é preciso percorrer desde a cabeca
            No atual = cabeca;
            while (atual.getProximo() != cauda) { 
                atual = atual.getProximo();
            }
            // 'atual' é agora o penúltimo
            atual.setProximo(null); // Desvincula a cauda
            cauda = atual;          // O penúltimo se torna a nova cauda
        }
        tamanho--;
        return dadoRemovido;
    }

    // consultas O(1)
    public Object first() throws DequeExcecao {
        if (isEmpty()) { throw new DequeExcecao("Deque vazio."); }
        return cabeca.getDado();
    }

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
```

## 2: Análise de Complexidade (Notação Big O)

### Tabela Comparativa de Complexidade de Tempo (Big O)

| Operação (Método do Deque) | Lista Duplamente Encadeada | Lista Simplesmente Encadeada |
| :--- | :--- | :--- |
| `insertFirst(o)` | $O(1)$ | $O(1)$ |
| `removeFirst()` | $O(1)$ | $O(1)$ |
| `insertLast(o)` | $O(1)$ | $O(1)$ |
| **`removeLast()`** | **$O(1)$** | **$O(n)$** |
| `first()` / `last()` | $O(1)$ | $O(1)$ |

### Justificativa da Análise

1.  **Tempo Constante ($O(1)$):**
    * Indica que o tempo de execução é constante, independentemente do número de elementos ($) na estrutura.
    * Todas as operações na **Lista Duplamente Encadeada** são $O(1)$ porque o acesso do início e dp fim é feito diretamente pelos ponteiros `cabeca` e `cauda`, e a manipulação dos nós adjacentes é imediata por causa dos ponteiros `proximo` e `anterior`.

2.  **Tempo Linear ($O(n)$):**
    * Indica q o tempo de execução cresce linearmente com o número de elementos ($).
    * Este custo ocorre no método **`removeLast()`** da **Lista Simplesmente Encadeada**. Devido a ausência do ponteiro `anterior`, o algoritmo é obrigado a percprrer a lista inteira desde o nó inicial (`cabeca`), pra localizar o penúltimo nó e redefinir o ponteiro `proximo`. Esse percurso acaba em uma complexidade $O(n)$.

**Conclusão Final:** A Lista Duplamente Encadeada é a implementação mais eficiente pra o Deque, pois ela sustenta o desempenho mais rápido ($O(1)$) pra todas as suas principais funcionalidades 
