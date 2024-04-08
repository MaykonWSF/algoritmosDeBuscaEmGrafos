import java.util.ArrayList;
import java.util.List;

public class No {

    private String estado;
    private No pai;
    private String acao;
    private int custo;

    public No(String estado, No pai, String acao, int custo) {
        this.estado = estado;
        this.pai = pai;
        this.acao = acao;
        this.custo = custo;
    }

    //Retorna o nó filho dado uma ação
    public No noFilho(Problema problema, String acao) {
        String proximoEstado = problema.transicao(this.estado, acao);
        int custoFilho = problema.custo(this.estado, acao, proximoEstado);
        return new No(proximoEstado, this, acao, custoFilho);
    }

    //Retorna todos os nós filhos possíveis a partir deste nó
    public List<No> explorar(Problema problema) {
        List<No> nos = new ArrayList<>();
        for (String acao : problema.acoes(this.estado)) {
            nos.add(noFilho(problema, acao));
        }
        return nos;
    }

    //Retorna o caminho do estado inicial até este nó
    public List<No> caminho() {
        List<No> caminho = new ArrayList<>();
        No noAtual = this;
        while (noAtual != null) {
            caminho.add(0, noAtual);
            noAtual = noAtual.pai;
        }
        return caminho;
    }

    //Retorna uma lista de ações que levam do estado inicial até este nó
    public List<String> solucao(List<No> caminho) {
        List<String> solucao = new ArrayList<>();
        for (No no : caminho) {
            solucao.add(no.getEstado());
        }
        return solucao;
    }
    
    //Retorna a profundidade do nó
    public int getProfundidade() {
        int profundidade = 0;
        No noAtual = this;
        while (noAtual != null && noAtual.pai != null) {
            profundidade++;
            noAtual = noAtual.pai;
        }
        return profundidade;
    }

    //Retorna a heurística do nó
    public int getHeuristica(Problema problema) {
        return problema.heuristica(this.estado);
    }

    //Retorna o custo real do nó
    public int getDistanciaPercorrida() {
        int custoReal = 0;
        No noAtual = this;
        while (noAtual != null) {
            custoReal += noAtual.custo;
            noAtual = noAtual.pai;
        }
        return custoReal;
    }

    // Getters e Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

}