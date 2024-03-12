public class App {
    public static void main(String[] args) throws Exception {
        Problema problema1 = new Problema("Arad", "Bucharest");
        Problema problema2 = new Problema("Arad", "Bucharest");
        
        Busca busca1 = new Busca(problema1);
        Busca busca2 = new Busca(problema2);


        System.out.println(busca1.buscaEmLargura().solucao());
        System.out.println(busca2.buscaEmProfundidade().solucao());
    }
}
