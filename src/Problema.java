import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problema {
    private String estadoInicial;
    private String estadoFinal;
    private Map<String, Map<String, Integer>> mapaRomenia;

    public Problema(String estadoInicial, String estadoFinal) {
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
        this.mapaRomenia = new HashMap<>();

        // Map<String, Integer> aradConexoes = new HashMap<>();
        // aradConexoes.put("Sibiu", 140);
        // aradConexoes.put("Zerind", 75);
        // aradConexoes.put("Timisoara", 118);
        // mapaRomenia.put("Arad", aradConexoes);
        
        mapaRomenia.put("Arad", Map.of("Sibiu", 140, "Zerind", 75, "Timisoara", 118));
        mapaRomenia.put("Zerind", Map.of("Arad", 75, "Oradea", 71));
        mapaRomenia.put("Oradea", Map.of("Zerind", 71, "Sibiu", 151));
        mapaRomenia.put("Sibiu", Map.of("Arad", 140, "Oradea", 151, "Fagaras", 99, "Rimnicu Vilcea", 80));
        mapaRomenia.put("Timisoara", Map.of("Arad", 118, "Lugoj", 111));
        mapaRomenia.put("Lugoj", Map.of("Timisoara", 111, "Mehadia", 70));
        mapaRomenia.put("Mehadia", Map.of("Lugoj", 70, "Drobeta", 75));
        mapaRomenia.put("Drobeta", Map.of("Mehadia", 75, "Craiova", 120));
        mapaRomenia.put("Craiova", Map.of("Drobeta", 120, "Rimnicu Vilcea", 146, "Pitesti", 138));
        mapaRomenia.put("Rimnicu Vilcea", Map.of("Sibiu", 80, "Craiova", 146, "Pitesti", 97));
        mapaRomenia.put("Fagaras", Map.of("Sibiu", 99, "Bucharest", 211));
        mapaRomenia.put("Pitesti", Map.of("Rimnicu Vilcea", 97, "Craiova", 138, "Bucharest", 101));
        mapaRomenia.put("Bucharest", Map.of("Fagaras", 211, "Pitesti", 101, "Giurgiu", 90, "Urziceni", 85));
        mapaRomenia.put("Giurgiu", Map.of("Bucharest", 90));
        mapaRomenia.put("Urziceni", Map.of("Bucharest", 85, "Vaslui", 142, "Hirsova", 98));
        mapaRomenia.put("Hirsova", Map.of("Urziceni", 98, "Eforie", 86));
        mapaRomenia.put("Eforie", Map.of("Hirsova", 86));
        mapaRomenia.put("Vaslui", Map.of("Iasi", 92, "Urziceni", 142));
        mapaRomenia.put("Iasi", Map.of("Vaslui", 92, "Neamt", 87));
        mapaRomenia.put("Neamt", Map.of("Iasi", 87));
    }

    public List<String> acoes(String estado) {
        Map<String, Integer> conexoes = this.mapaRomenia.get(estado);
        return new ArrayList<>(conexoes.keySet());
    }

    public String transicao(String estado, String acao) {
        List<String> acoes = this.acoes(estado);
        if (acoes.contains(acao)) {
            return acao;
        }
        return null;
    }

    public boolean objetivo(String estado) {
        return estado.equals(this.estadoFinal);
    }

    public int custo(String estado1, String acao, String estado2) {
        return this.mapaRomenia.get(estado1).get(estado2);
    }

    public Map<String, Map<String, Integer>> getMapaRomenia() {
        return mapaRomenia;
    }
    
    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }
}