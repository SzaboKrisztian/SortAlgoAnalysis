package dk.kea.stud.chris;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Main {
  private static final int ARRAY_SIZE = 10000;
  private static final int NO_ITERATIONS = 10000;

  public static void main(String[] args) {
    Random random = new Random();

    SortingStrategy[] strategies = new SortingStrategy[5];

    strategies[0] = new MergeSort();
    strategies[1] = new QuickSort();
    strategies[2] = new InsertionSort();
    strategies[3] = new BubbleSort();
    strategies[4] = new BSTSort();



    long[][] results = new long[NO_ITERATIONS][strategies.length];

    for (int iter = 0; iter < NO_ITERATIONS; iter++) {

      ArrayList<ArrayList<Integer>> data = new ArrayList<>();
      for (int i = 0; i < strategies.length; i++) {
        data.add(new ArrayList<>());
      }

      int num;
      for (int i = 0; i < ARRAY_SIZE; i++) {
        num = random.nextInt(ARRAY_SIZE * 10);
        for (int j = 0; j < strategies.length; j++) {
          data.get(j).add(num);
        }
      }

      for (int i = 0; i < strategies.length; i++) {
//        System.out.println(data.get(i));
        long ops;
//        LocalTime start = LocalTime.now();
        ops = strategies[i].sort(data.get(i));
        results[iter][i] = ops;
//        long time = LocalTime.now().toNanoOfDay() - start.toNanoOfDay();
//        System.out.println(data.get(i));
//        System.out.println(time / 1000000 + " ms & " + ops + " char. operations.");
      }
      System.out.printf("Finished %d / %d iterations.%n", iter + 1, NO_ITERATIONS);
    }

    BigInteger[] grandTotals = new BigInteger[strategies.length];
    for (int i = 0; i < strategies.length; i++) {
      grandTotals[i] = BigInteger.ZERO;
    }
    for (int i = 0; i < NO_ITERATIONS; i++) {
      for (int j = 0; j < strategies.length; j++) {
        grandTotals[j] = grandTotals[j].add(BigInteger.valueOf(results[i][j]));
      }
    }

    System.out.printf("Average number of characteristic operations for array size of %d over %d iterations:%n", ARRAY_SIZE, NO_ITERATIONS);
    for (int i = 0; i < strategies.length; i++) {
      System.out.printf("%s: %,d%n", strategies[i].getName(), grandTotals[i].divide(BigInteger.valueOf(NO_ITERATIONS)));
    }
  }
}
