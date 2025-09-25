public class TestePilhaColorida {
    public static void main(String[] args) {
        PilhaColorida pilha = new PilhaColorida(5); //criando uma pilha colorida com capacidade inicial de 5

        System.out.println("=== Testando pushVermelha e pushPreta ===");
        pilha.pushVermelha("V1");
        pilha.pushVermelha("V2");
        pilha.pushPreta("P1");
        pilha.pushPreta("P2");

        System.out.println("Topo Vermelha: " + pilha.topVermelha()); //mostra V2
        System.out.println("Topo Preta: " + pilha.topPreta());       //mostra P2

        System.out.println("\n=== Testando popVermelha e popPreta ===");
        System.out.println("Pop Vermelha: " + pilha.popVermelha());  // remove a V2
        System.out.println("Pop Preta: " + pilha.popPreta());        // remove a P2

        System.out.println("\n=== Testando tamanho das pilhas e capacidade ===");
        System.out.println("Tamanho Vermelha: " + pilha.sizeVermelha()); 
        System.out.println("Tamanho Preta: " + pilha.sizePreta());       
        System.out.println("Capacidade do array: " + pilha.capacity());  

        System.out.println("\n=== Testando redimensionamento (push para encher) ===");
        pilha.pushVermelha("V3");
        pilha.pushVermelha("V4");
        pilha.pushPreta("P3"); // deve disparar redimensionamentp
        System.out.println("Capacidade após redimensionamento: " + pilha.capacity());

        System.out.println("\n=== Testando se pilhas estão vazias ===");
        System.out.println("Vermelha vazia? " + pilha.isEmptyVermelha());
        System.out.println("Preta vazia? " + pilha.isEmptyPreta());
    }
}
