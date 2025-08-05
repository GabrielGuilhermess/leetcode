package org.example.easy.two_nums;

/**
 * Implementação de Two Sum por força bruta em O(n²), sem uso de memória extra.
 */
public class TwoSumBruteForce implements TwoSumSolver{
  /**
   * Tenta todas as combinações possíveis de pares.
   *
   * @param nums   array de inteiros
   * @param target soma alvo
   * @return índices do par que soma target ou {-1, -1}
   */
  @Override
  public int[] solve(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++)
      for (int j = i + 1; j < nums.length; j++)
        if (nums[i] + nums[j] == target) return new int[]{i, j};
    return new int[]{-1, -1};
  }
}
