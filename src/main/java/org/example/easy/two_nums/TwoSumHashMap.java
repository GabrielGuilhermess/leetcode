package org.example.easy.two_nums;

import java.util.HashMap;

/**
 * Implementação de Two Sum utilizando HashMap para busca em tempo O(n).
 */
public class TwoSumHashMap implements TwoSumSolver {

  /**
   * Varre o array uma única vez, armazenando cada valor e seu índice em um map.
   * Para cada elemento, verifica se o complemento já foi visto.
   *
   * @param nums   array de inteiros
   * @param target soma alvo
   * @return índices do par que soma target ou {-1, -1}
   */
  @Override
  public int[] solve(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(nums.length * 2);
    for (int i = 0; i < nums.length; i++) {
      int need = target - nums[i];
      Integer j = map.get(need);
      if (j != null) {
        return new int[]{j, i};
      }
      map.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }
}
