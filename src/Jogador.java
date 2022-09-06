public class Jogador {

    private String nome;
    private int pontos;
    private boolean marca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos() {
        this.pontos += 1;
    }

    public boolean getMarca() {
        return this.marca;
    }

    public Jogador(String nome, boolean marca) {
        this.nome = nome;
        this.pontos = 0;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "INFORMAÇÕES DO JOGADOR: \n NOME: " + nome + "\n Pontuação: " + pontos;
    }
}