import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public No buscaEmLargura() {
        List<No> borda = new ArrayList<>();
        borda.add(this.estado);

        //Debug
        List<String> explorados = this.explorados;
        List<String> expandidos = this.expandidos;
        expandidos.add(this.estado.getEstado());

        while (!borda.isEmpty()) {
            No no = borda.remove(0);

            //
            expandidos.remove(0);
            //
            
            this.explorados.add(no.getEstado());

            if (this.problema.objetivo(no.getEstado())) {
                return no;
            }

            for (No filho : no.explorar(this.problema)) {
                if (!this.explorados.contains(filho.getEstado()) && !borda.contains(filho)) {
                    borda.add(filho);
                    this.expandidos.add(filho.getEstado());
                }
            }
        }

        return null;
    }
}