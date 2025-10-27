package Deque;

public class DequeTeste {
    public static void main(String args[]){
        
        // Teste da implementação O(1) em todas as pontas
        System.out.println("----- TESTE DO DEQUE COM LISTA DUPLAMENTE ENCADEADA -----");
        Deque dDupla = new DequeDuplamenteEncadeada();

        // Insere para testar as duas pontas
        dDupla.insertFirst("A");
        dDupla.insertLast("B");
        dDupla.insertFirst("C"); 
        dDupla.insertLast("D"); 
        dDupla.print(); // Esperado: [C, A, B, D]

        try {
            System.out.println("Removendo Primeiro (C): " + dDupla.removeFirst());
            System.out.println("Removendo Ultimo (D): " + dDupla.removeLast());
            dDupla.print(); // Esperado: [A, B]
        } catch (DequeExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Tamanho final: " + dDupla.size());
        
        System.out.println("\n----- TESTE DO DEQUE COM LISTA SIMPLESMENTE ENCADEADA -----");
        
        // Teste para ilustrar a implementação O(n) na remoção do fim
        Deque dSimples = new DequeSimplesmenteEncadeada();
        
        // Insere 4 elementos
        dSimples.insertFirst(10);
        dSimples.insertFirst(20);
        dSimples.insertLast(30);
        dSimples.insertLast(40);
        dSimples.print(); // Esperado: [20, 10, 30, 40]

        try {
            System.out.println("Removendo Primeiro (20 - O(1)): " + dSimples.removeFirst());
            dSimples.print(); // Esperado: [10, 30, 40]
            
            // Esta remoção executa a lógica O(n) no código
            System.out.println("Removendo Ultimo (40 - O(n) loop): " + dSimples.removeLast()); 
            dSimples.print(); // Esperado: [10, 30]

            System.out.println("Primeiro: " + dSimples.first()); // 10
            System.out.println("Ultimo: " + dSimples.last());   // 30

        } catch (DequeExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Tamanho final: " + dSimples.size());
    }
}
