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

    //Busca em largura (sem pesos)
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

    //Busca em profundidade (sem pesos)
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

    //Analisa se a borda já contém um estado
    private boolean contemEstado(List<No> borda, String estado) {
        for (No no : borda) {
            if (no.getEstado().equals(estado)) {
                return true;
            }
        }
        return false;
    }
}