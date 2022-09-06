
public class JogoDaVelha {

    private char[][] tabuleiro;
    private int tamanho;
    private int j1MesmoValor;
    private int j2MesmoValor;

    public JogoDaVelha(int dimensoes) {
        this.tabuleiro = new char[dimensoes][dimensoes];
        this.tamanho = dimensoes;
    }

    public boolean realizaJogada(int linha, int coluna, boolean jogada) {
        if (tabuleiro[linha][coluna] != 'X' && tabuleiro[linha][coluna] != 'O') {
            if (jogada == true)
                tabuleiro[linha][coluna] = 'X';
            else
                tabuleiro[linha][coluna] = 'O';

            return true;
        } else
            return false;
    }

    public int verificaGanhador() {

        if (validaLinhas() == 0)
            return 0;
        else if (validaLinhas() == 1)
            return 1;

        if (validaColunas() == 0)
            return 0;
        else if (validaColunas() == 1)
            return 1;

        if (validaDiagonais() == 0)
            return 0;
        else if (validaDiagonais() == 1)
            return 1;

        return -1;
    }

    public int validaLinhas() {

        j1MesmoValor = 0;
        j2MesmoValor = 0;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {

                if (j + 1 == tamanho && tabuleiro[i][j] == tabuleiro[i][0] && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;

                } else if (j + 1 == tamanho && tabuleiro[i][j] == tabuleiro[i][0] && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                } else if (j + 1 < tamanho && tabuleiro[i][j] == tabuleiro[i][j + 1] && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;

                } else if (j + 1 < tamanho && tabuleiro[i][j] == tabuleiro[i][j + 1] && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                }
            }

            if (j1MesmoValor == tamanho) {
                return 0;
            } else if (j2MesmoValor == tamanho)
                return 1;
        }

        return -1;
    }

    public int validaColunas() {

        j1MesmoValor = 0;
        j2MesmoValor = 0;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {

                if (i + 1 == tamanho && tabuleiro[i][j] == tabuleiro[0][j] && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;

                } else if (i + 1 == tamanho && tabuleiro[i][j] == tabuleiro[0][j] && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                } else if (i + 1 < tamanho && tabuleiro[i][j] == tabuleiro[i + 1][j] && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;

                } else if (i + 1 < tamanho && tabuleiro[i][j] == tabuleiro[i + 1][j] && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                }
            }
        }

        if (j1MesmoValor == tamanho) {
            return 0;
        } else if (j2MesmoValor == tamanho) {
            return 1;
        }

        return -1;
    }

    public int validaDiagonais() {

        j1MesmoValor = 0;
        j2MesmoValor = 0;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i + 1 < tamanho && i == j && tabuleiro[i][j] == tabuleiro[i + 1][j + 1] && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;
                
                } else if (i + 1 == tamanho && tabuleiro[i][j] == tabuleiro[0][0] && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;

                } else if (i + 1 < tamanho && i == j && tabuleiro[i][j] == tabuleiro[i + 1][j + 1] && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                } else if (i + 1 == tamanho && tabuleiro[i][j] == tabuleiro[0][0] && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                } else if (i + j == tamanho - 1 && tabuleiro[i][j] == 'X') {

                    j1MesmoValor += 1;

                } else if (i + j == tamanho - 1 && tabuleiro[i][j] == 'O') {

                    j2MesmoValor += 1;

                }
            }
        }

        if (j1MesmoValor == tamanho) {
            return 0;
        } else if (j2MesmoValor == tamanho) {
            return 1;
        }

        return -1;
    }

    public void limpaTabuleiro() {
        tabuleiro = new char[tamanho][tamanho];
    }

    public boolean fimPosicoes() {
        int valida = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiro[i][j] == 'X' || tabuleiro[i][j] == 'O') {
                    valida += 1;
                }
            }
        }

        if (valida == tamanho * tamanho) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String retorna = "";

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {

                if (tabuleiro[i][j] == 'X' || tabuleiro[i][j] == 'O') {
                    retorna += String.valueOf(tabuleiro[i][j] + " | ");
                } else 
                    retorna += "- | ";
                

                if (j == tamanho - 1)
                    retorna += '\n';
            }
        }

        return retorna;
    }
}