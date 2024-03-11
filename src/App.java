import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Problema problema = new Problema("Arad", "Bucharest");
        Busca busca = new Busca(problema);


        System.out.println(busca.buscaEmLargura().solucao());
    }
}
