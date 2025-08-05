package org.example.easy.two_nums;

import java.util.Scanner;

/**
 * Aplicação console que permite ao usuário escolher a estratégia
 * de Two Sum, inserir os dados manualmente e digitar 'sair' para encerrar.
 * Mede tempo de execução e memória utilizada em cada operação.
 */
public class TwoSumApp {

  /**
   * Seleciona a implementação de acordo com a opção informada.
   *
   * @param option código da estratégia (1, 2 ou 3)
   * @return instância de TwoSumSolver ou null se inválido
   */
  private static TwoSumSolver selectSolver(int option) {
    switch (option) {
      case 1:
        return new TwoSumHashMap();
      case 2:
        return new TwoSumSortedPointers();
      case 3:
        return new TwoSumBruteForce();
      default:
        return null;
    }
  }

  /**
   * Ponto de entrada: loop interativo que lê comandos do usuário:
   * - 'sair' para encerrar
   * - número da estratégia (1-3) seguido de array e target
   * Mede e exibe tempo (ms) e memória (KB) usados na resolução.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Runtime runtime = Runtime.getRuntime();
    while (true) {
      System.out.println("Escolha a implementação ou digite 'sair' para encerrar: 1-HashMap 2-SortedPointers 3-BruteForce");
      String line = scanner.nextLine().trim();
      if (line.equalsIgnoreCase("sair")) {
        System.out.println("Encerrando aplicação.");
        break;
      }
      int option;
      try {
        option = Integer.parseInt(line);
      } catch (NumberFormatException e) {
        System.out.println("Opção inválida. Digite 1, 2, 3 ou 'sair'.");
        continue;
      }
      TwoSumSolver solver = selectSolver(option);
      if (solver == null) {
        System.out.println("Opção inválida. Digite 1, 2, 3 ou 'sair'.");
        continue;
      }

      System.out.println("Digite os números separados por espaço ou 'sair' para encerrar:");
      String numsLine = scanner.nextLine().trim();
      if (numsLine.equalsIgnoreCase("sair")) {
        System.out.println("Encerrando aplicação.");
        break;
      }
      String[] parts = numsLine.split("\\s+");
      int[] nums = new int[parts.length];
      boolean parseError = false;
      for (int i = 0; i < parts.length; i++) {
        try {
          nums[i] = Integer.parseInt(parts[i]);
        } catch (NumberFormatException e) {
          System.out.println("Entrada inválida: '" + parts[i] + "' não é inteiro.");
          parseError = true;
          break;
        }
      }
      if (parseError) continue;

      System.out.println("Digite o target ou 'sair' para encerrar:");
      String targetLine = scanner.nextLine().trim();
      if (targetLine.equalsIgnoreCase("sair")) {
        System.out.println("Encerrando aplicação.");
        break;
      }
      int target;
      try {
        target = Integer.parseInt(targetLine);
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida: target deve ser inteiro.");
        continue;
      }

      // Medição de tempo e memória
      long startTime = System.nanoTime();
      long beforeUsedMem = runtime.totalMemory() - runtime.freeMemory();

      int[] result = solver.solve(nums, target);

      long endTime = System.nanoTime();
      long afterUsedMem = runtime.totalMemory() - runtime.freeMemory();

      long elapsedMs = (endTime - startTime) / 1_000_000;
      long usedMemKb = (afterUsedMem - beforeUsedMem) / 1024;

      if (result[0] >= 0) {
        System.out.printf("Índices: [%d, %d]%n", result[0], result[1]);
      } else {
        System.out.println("Nenhuma solução encontrada");
      }
      System.out.printf("Tempo: %d ms, Memória: %d KB%n", elapsedMs, usedMemKb);
    }
    scanner.close();
  }
}