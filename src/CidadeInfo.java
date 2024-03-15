import java.util.Map;

class CidadeInfo {
    Map<String, Integer> conexoes;
    int heuristica;

    public CidadeInfo(Map<String, Integer> conexoes, int heuristica) {
        this.conexoes = conexoes;
        this.heuristica = heuristica;
    }

    public Map<String, Integer> getConexoes() {
        return conexoes;
    }

    public int getHeuristica() {
        return heuristica;
    }
}


///// Mapa com heurísticas estimadas /////

/* 
mapaRomenia.put("Arad", new CidadeInfo(Map.of("Sibiu", 140, "Zerind", 75, "Timisoara", 118), 366));
mapaRomenia.put("Zerind", new CidadeInfo(Map.of("Arad", 75, "Oradea", 71), 374));
mapaRomenia.put("Oradea", new CidadeInfo(Map.of("Zerind", 71, "Sibiu", 151), 380));
mapaRomenia.put("Sibiu", new CidadeInfo(Map.of("Arad", 140, "Oradea", 151, "Fagaras", 99, "Rimnicu Vilcea", 80), 253));
mapaRomenia.put("Timisoara", new CidadeInfo(Map.of("Arad", 118, "Lugoj", 111), 329));
mapaRomenia.put("Lugoj", new CidadeInfo(Map.of("Timisoara", 111, "Mehadia", 70), 244));
mapaRomenia.put("Mehadia", new CidadeInfo(Map.of("Lugoj", 70, "Drobeta", 75), 241));
mapaRomenia.put("Drobeta", new CidadeInfo(Map.of("Mehadia", 75, "Craiova", 120), 242));
mapaRomenia.put("Craiova", new CidadeInfo(Map.of("Drobeta", 120, "Rimnicu Vilcea", 146, "Pitesti", 138), 160));
mapaRomenia.put("Rimnicu Vilcea", new CidadeInfo(Map.of("Sibiu", 80, "Craiova", 146, "Pitesti", 97), 193));
mapaRomenia.put("Fagaras", new CidadeInfo(Map.of("Sibiu", 99, "Bucharest", 211), 176));
mapaRomenia.put("Pitesti", new CidadeInfo(Map.of("Rimnicu Vilcea", 97, "Craiova", 138, "Bucharest", 101), 100));
mapaRomenia.put("Bucharest", new CidadeInfo(Map.of("Fagaras", 211, "Pitesti", 101, "Giurgiu", 90, "Urziceni", 85), 0));
mapaRomenia.put("Giurgiu", new CidadeInfo(Map.of("Bucharest", 90), 77));
mapaRomenia.put("Urziceni", new CidadeInfo(Map.of("Bucharest", 85, "Vaslui", 142, "Hirsova", 98), 80));
mapaRomenia.put("Hirsova", new CidadeInfo(Map.of("Urziceni", 98, "Eforie", 86), 151));
mapaRomenia.put("Eforie", new CidadeInfo(Map.of("Hirsova", 86), 161));
mapaRomenia.put("Vaslui", new CidadeInfo(Map.of("Iasi", 92, "Urziceni", 142), 199));
mapaRomenia.put("Iasi", new CidadeInfo(Map.of("Vaslui", 92, "Neamt", 87), 226));
mapaRomenia.put("Neamt", new CidadeInfo(Map.of("Iasi", 87), 234));
*/