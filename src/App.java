public class App {
    public static void main(String[] args) throws Exception {
        Problema problema1 = new Problema("Arad", "Bucharest");
        Busca busca1 = new Busca(problema1);

        System.out.println(busca1.buscaDeCustoUniforme());
    }
}