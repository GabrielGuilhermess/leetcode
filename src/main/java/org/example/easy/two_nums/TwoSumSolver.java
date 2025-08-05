package org.example.easy.two_nums;

/**
 * Interface que define a operação Two Sum.
 * Toda implementação deve receber um array de inteiros e um target, retornando
 * os índices de dois elementos cuja soma seja igual ao target.
 */
public interface TwoSumSolver {
  /**
   * Resolve o problema Two Sum.
   *
   * @param nums   array de inteiro não ordenado
   * @param target valor alvo para soma de dois elementos
   * @return par de índices [i, j] tal que nums[i] + nums[j] == target,
   *         ou {-1, -1} se não existir solução
   */
  int[] solve(int[] nums, int target);
}
