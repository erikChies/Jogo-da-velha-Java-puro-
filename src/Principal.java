import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

  static Scanner scan = new Scanner(System.in);
  private static boolean controleJogada = false;
  private static int continua = 2;
  private static int retornoValida = -1;
  private static int dimensoes = 0;

  public static void main(String[] args) throws Exception {

    Object[] options = { "Sim", "Não" };
    JFrame frame = new JFrame();

    // true = 'X' false = 'O'
    Jogador jogador1 = new Jogador(JOptionPane.showInputDialog("Digite o nome do primeiro participante: "), true);
    Jogador jogador2 = new Jogador(JOptionPane.showInputDialog("Digite o nome do segundo participante: "), false);

    do {
      try {

        dimensoes = Integer.parseInt(JOptionPane.showInputDialog("De qual tamanho será o tabuleiro?"));

        controleJogada = true;

      } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(frame,
            "Digite um número inteiro de preferência ímpar", "Dimensão inválida",
            JOptionPane.WARNING_MESSAGE);

        controleJogada = false;
      }
    } while (controleJogada == false);

    JogoDaVelha jogo = new JogoDaVelha(dimensoes);

    int linha = 0;
    int coluna = 0;

    do {

      do {

        if (!jogo.fimPosicoes()) {

          try {

            linha = Integer.parseInt(
                JOptionPane.showInputDialog(jogador1.getNome() + " Informe a linha onde deseja inserir sua jogada"));
            coluna = Integer.parseInt(
                JOptionPane.showInputDialog(jogador1.getNome() + " Informe a coluna onde deseja inserir sua jogada"));

            if (!jogo.realizaJogada(linha, coluna, jogador1.getMarca()))
              throw new ArrayIndexOutOfBoundsException();

            controleJogada = true;

          } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {

            JOptionPane.showMessageDialog(frame,
                "Jogada não realizada, posição já ocupada ou não existente, insira outra posição", "Falha na inserção",
                JOptionPane.WARNING_MESSAGE);
            controleJogada = false;

          }
        } else
          controleJogada = true;
      } while (controleJogada == false);

      System.out.println(jogo.toString());

      retornoValida = jogo.verificaGanhador();

      if (retornoValida == 0) {

        jogador1.setPontos();
        System.out.println(jogador1.toString());

      } else if (retornoValida == 1) {

        jogador2.setPontos();
        System.out.println(jogador2.toString());

      }

      if (retornoValida != -1)
        continua = JOptionPane.showOptionDialog(null, "Deseja jogar novamente?", "Fim de Jogo",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

      if (jogo.fimPosicoes() || retornoValida != -1)
        jogo.limpaTabuleiro();

      if (continua == 0 || continua == 2) {
        do {

          try {

            linha = Integer.parseInt(
                JOptionPane.showInputDialog(jogador2.getNome() + " Informe a linha onde deseja inserir sua jogada"));
            coluna = Integer.parseInt(
                JOptionPane.showInputDialog(jogador2.getNome() + " Informe a coluna onde deseja inserir sua jogada"));

            if (!jogo.realizaJogada(linha, coluna, jogador2.getMarca()))
              throw new ArrayIndexOutOfBoundsException();

            controleJogada = true;

          } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {

            JOptionPane.showMessageDialog(frame,
                "Jogada não realizada, posição já ocupada ou não existente, insira outra posição", "Falha na inserção",
                JOptionPane.WARNING_MESSAGE);
            controleJogada = false;

          }
        } while (controleJogada == false);

        System.out.println(jogo.toString());

        retornoValida = jogo.verificaGanhador();

        if (retornoValida == 0) {

          jogador1.setPontos();
          System.out.println(jogador1.toString());

        } else if (retornoValida == 1) {

          jogador2.setPontos();
          System.out.println(jogador2.toString());

        }

        if (retornoValida != -1)
          continua = JOptionPane.showOptionDialog(null, "Deseja jogar novamente?", "Fim de Jogo",
              JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if (jogo.fimPosicoes() || retornoValida != -1)
          jogo.limpaTabuleiro();
      }
    } while (continua == 0 || continua == 2);

    System.out.println("Obrigado por Jogar! Até a Próxima.");
  }
}
