package br.com.trabalho.models;

public class Titulo implements Comparable<Titulo>{

    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (!meuTituloOmdb.year().equalsIgnoreCase("N/A") || meuTituloOmdb.year() != null) {
            meuTituloOmdb.year().replace(" ","");
            this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        }else{
            this.anoDeLancamento =0;
        }
        meuTituloOmdb.runtime().replace(" ", "");
        if (!meuTituloOmdb.runtime().equalsIgnoreCase("N/A")) {
            this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().replace(" min", ""));
        } else {
            this.duracaoEmMinutos = 0;
        }
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do br.com.trabalho.calculadora.models.Filme: " + nome);
        System.out.println("Ano de Lançamento: "+anoDeLancamento);
        System.out.println("Está incluido no /plano? " + incluidoNoPlano);
        System.out.println("avaliações: " + somaDasAvaliacoes);

    }
    public void somaAvaliacao(int nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Nome: " + nome +"\n" + "Data de lançamento: " + anoDeLancamento + "\nDuraçao do filme em minutos: " + duracaoEmMinutos;
    }
}
