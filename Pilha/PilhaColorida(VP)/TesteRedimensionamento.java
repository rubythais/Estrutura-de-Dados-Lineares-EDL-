public class TesteRedimensionamento {
    public static void main(String[] args) {
        PilhaColorida pilha = new PilhaColorida(3);
        
        System.out.println("=== TESTE DE REDIMENSIONAMENTO ===");
        System.out.println("Capacidade inicial: " + pilha.capacity());
        
        //enchr a pilha para forçar redimensionamento
        pilha.pushVermelha("V1");
        pilha.pushVermelha("V2");
        pilha.pushPreta("P1");
        pilha.pushPreta("P2"); 
        
        System.out.println("Capacidade após encher: " + pilha.capacity());
        System.out.println("Tamanho Vermelha: " + pilha.sizeVermelha());
        System.out.println("Tamanho Preta: " + pilha.sizePreta());
        
        //teste de reduçao
        System.out.println("\n=== TESTE DE REDUÇÃO ===");
        pilha.popVermelha();
        pilha.popVermelha();
        pilha.popPreta();
        System.out.println("Capacidade após remoções: " + pilha.capacity());
    }
}
