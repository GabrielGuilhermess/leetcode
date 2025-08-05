package two_nums;

import org.example.easy.two_nums.TwoSumHashMap;
import org.example.easy.two_nums.TwoSumSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumHashMapTest {

  private final TwoSumSolver solver = new TwoSumHashMap();

  @Test
  void exampleTest() {
    assertArrayEquals(new int[]{0, 1}, solver.solve(new int[]{2, 7, 11, 15}, 9));
  }

  @Test
  void negativeNumbersTest() {
    assertArrayEquals(new int[]{0, 2}, solver.solve(new int[]{-3, 4, 3}, 0));
  }

  @Test
  void noSolutionTest() {
    assertArrayEquals(new int[]{-1, -1}, solver.solve(new int[]{1, 2, 3}, 7));
  }

  @Test
  void duplicateValuesTest() {
    assertArrayEquals(new int[]{0, 1}, solver.solve(new int[]{3, 3, 4}, 6));
  }
}