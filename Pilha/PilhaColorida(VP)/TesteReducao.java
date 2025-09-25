public class TesteReducao {
    public static void main(String[] args) {
        PilhaColorida pilha = new PilhaColorida(12);
        
        System.out.println("=== TESTE DE REDUÇÃO (1/3 de uso) ===");
        System.out.println("Capacidade inicial: " + pilha.capacity());
        
        // Adicionar elementos
        pilha.pushVermelha("V1"); pilha.pushVermelha("V2"); pilha.pushVermelha("V3"); pilha.pushVermelha("V4");
        pilha.pushPreta("P1"); pilha.pushPreta("P2"); pilha.pushPreta("P3"); pilha.pushPreta("P4");
        
        System.out.println("Após adicionar 8 elementos: " + pilha.capacity());
        
        // Remover até ficar com 1/3 (4 elementos em capacidade 12)
        pilha.popVermelha(); pilha.popVermelha(); pilha.popVermelha();
        pilha.popPreta(); pilha.popPreta(); pilha.popPreta();
        
        System.out.println("Após remover 6 elementos: " + pilha.capacity());
        System.out.println("Elementos restantes: " + (pilha.sizeVermelha() + pilha.sizePreta()));
    }
}
