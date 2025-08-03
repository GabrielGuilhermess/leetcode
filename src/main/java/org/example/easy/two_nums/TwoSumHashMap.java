package org.example.easy.two_nums;

import java.util.HashMap;

public class TwoSumHashMap {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> mapa = new HashMap<>(nums.length * 2);
    for (int i = 0; i < nums.length; i++) {
      int complemento = target - nums[i];
      if (mapa.containsKey(complemento))
        return new int[] { mapa.get(complemento), i };
      mapa.put(nums[i], i);
    }
    return new int[] { -1, -1 };
  }
}
