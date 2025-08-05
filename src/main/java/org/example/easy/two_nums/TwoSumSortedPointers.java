package org.example.easy.two_nums;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementação de Two Sum ordenando o array com pares (valor, índice)
 * e usando dois ponteiros para busca em O(n log n).
 */
public class TwoSumSortedPointers implements TwoSumSolver {
  /**
   * Monta um array de pares [valor, índice], ordena e aplica dois ponteiros
   * para encontrar a soma desejada.
   *
   * @param nums   array original de inteiros
   * @param target soma alvo
   * @return índices do par que soma target ou {-1, -1}
   */
  @Override
  public int[] solve(int[] nums, int target) {
    int[][] valorIndice = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
      valorIndice[i][0] = nums[i];
      valorIndice[i][1] = i;
    }
    Arrays.sort(valorIndice, Comparator.comparingInt(v -> v[0]));
    int esquerda = 0, direita = valorIndice.length - 1;
    while (esquerda < direita) {
      int soma = valorIndice[esquerda][0] + valorIndice[direita][0];
      if (soma == target) return new int[]{valorIndice[esquerda][1], valorIndice[direita][1]};
      if (soma < target) esquerda++;
      else direita--;
    }
    return new int[]{-1, -1};
  }
}
