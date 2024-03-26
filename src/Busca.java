import java.util.ArrayList;
import java.util.List;

public class Busca {
    private Problema problema;
    private No estado;
    private List<String> explorados;
    private List<String> expandidos;

    public Busca(Problema problema) {
        this.problema = problema;
        this.estado = new No(problema.getEstadoInicial(), null, null, 0);
        this.explorados = new ArrayList<>();
        this.expandidos = new ArrayList<>();
    }

    // Busca em largura
    public List<String> buscaEmLargura() {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        while (!borda.isEmpty()) {
            No no = borda.remove(0);
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                no.solucao(explorados);
                return explorados;
            }

            for (No filho : no.explorar(this.problema)) {
                if (!this.explorados.contains(filho.getEstado()) && !contemEstado(borda, filho.getEstado())) {
                    borda.add(filho);
                    this.expandidos.add(filho.getEstado());
                }
            }
        }

        return null;
    }

    // Busca em profundidade
    public List<String> buscaEmProfundidade() {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        while (!borda.isEmpty()) {
            No no = borda.remove(borda.size() - 1);
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                no.solucao(explorados);
                return explorados;
            }

            for (No filho : no.explorar(this.problema)) {
                if (!this.explorados.contains(filho.getEstado()) && !contemEstado(borda, filho.getEstado())) {
                    borda.add(filho);
                    this.expandidos.add(filho.getEstado());
                }
            }
        }

        return null;
    }

    // Busca em profundidade limitada
    public List<String> buscaEmProfundidadeLimitada(int limite) {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        while (!borda.isEmpty()) {
            No no = borda.remove(borda.size() - 1);
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                no.solucao(explorados);
                return explorados;
            }

            if (no.getProfundidade() < limite) {
                for (No filho : no.explorar(this.problema)) {
                    if (!this.explorados.contains(filho.getEstado()) && !contemEstado(borda, filho.getEstado())) {
                        borda.add(filho);
                        this.expandidos.add(filho.getEstado());
                    }
                }
            }
        }

        return null;
    }

    // Busca em profundidade iterativa
    public List<String> buscaEmProfundidadeIterativa() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            this.explorados.clear();
            this.expandidos.clear();
            List<String> resultado = this.buscaEmProfundidadeLimitada(i);
            if (resultado != null) {
                return resultado;
            }
        }

        return null;
    }

    // Busca de custo uniforme
    public List<String> buscaDeCustoUniforme() {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        while (!borda.isEmpty()) {
            No no = borda.remove(0);
            borda.clear();
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                no.solucao(explorados);
                return explorados;
            }

            for (No filho : no.explorar(this.problema)) {
                if (!this.explorados.contains(filho.getEstado()) && !contemEstado(borda, filho.getEstado())) {
                    borda.add(filho);
                    this.expandidos.add(filho.getEstado());
                    ordenarBordaPorCusto(borda);
                }
            }
        }

        return null;
    }

    // Busca gulosa
    public List<String> buscaGulosa() {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        while (!borda.isEmpty()) {
            No no = borda.remove(0);
            borda.clear();
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                no.solucao(explorados);
                return explorados;
            }

            for (No filho : no.explorar(this.problema)) {
                if (!this.explorados.contains(filho.getEstado()) && !contemEstado(borda, filho.getEstado())) {
                    borda.add(filho);
                    this.expandidos.add(filho.getEstado());
                    ordenarBordaPorHeuristica(borda);
                }
            }
        }

        return null;
    }

    // Busca A*
    public List<String> buscaAEstrela() {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        while (!borda.isEmpty()) {
            No no = borda.remove(0);
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                List<String> melhorCaminho = new ArrayList<>();
                for (No noCaminho : no.caminho()) {
                    melhorCaminho.add(noCaminho.getEstado());
                }
                return melhorCaminho;
            }

            for (No filho : no.explorar(this.problema)) {
                borda.add(filho);
                this.expandidos.add(filho.getEstado());
                ordenarBordaPorCustoReal(borda);
            }
        }

        return null;
    }

    // Analisa se a borda já contém um estado
    private boolean contemEstado(List<No> borda, String estado) {
        for (No no : borda) {
            if (no.getEstado().equals(estado)) {
                return true;
            }
        }
        return false;
    }

    // Ordenar a borda pelo custo
    private void ordenarBordaPorCusto(List<No> borda) {
        borda.sort((No no1, No no2) -> {
            if (no1.getCusto() < no2.getCusto()) {
                return -1;
            } else if (no1.getCusto() > no2.getCusto()) {
                return 1;
            }
            return 0;
        });
    }

    // Ordenar a borda pela heurística
    private void ordenarBordaPorHeuristica(List<No> borda) {
        borda.sort((No no1, No no2) -> {
            if (no1.getHeuristica(this.problema) < no2.getHeuristica(this.problema)) {
                return -1;
            } else if (no1.getHeuristica(this.problema) > no2.getHeuristica(this.problema)) {
                return 1;
            }
            return 0;
        });
    }

    // Calcula o custo real de um nó
    private int custoReal(No no) {
        int custoReal = no.getDistanciaPercorrida() + no.getHeuristica(this.problema);
        return custoReal;
    }

    // Ordenar por custo real
    private void ordenarBordaPorCustoReal(List<No> borda) {
        borda.sort((No no1, No no2) -> {
            if (custoReal(no1) < custoReal(no2)) {
                return -1;
            } else if (custoReal(no1) > custoReal(no2)) {
                return 1;
            }
            return 0;
        });
    }
}