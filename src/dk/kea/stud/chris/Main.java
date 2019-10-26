package dk.kea.stud.chris;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Main {
  private static final int ARRAY_SIZE = 50000;

  public static void main(String[] args) {
    Random random = new Random();

    SortingStrategy[] strategies = new SortingStrategy[4];

    strategies[0] = new BubbleSort();
    strategies[1] = new InsertionSort();
    strategies[2] = new MergeSort();
    strategies[3] = new QuickSort();

    ArrayList<ArrayList<Integer>> data = new ArrayList<>();
    for (int i = 0; i < strategies.length; i++) {
      data.add(new ArrayList<>());
    }

    long[] results = new long[strategies.length];

    int num;
    for (int i = 0; i < ARRAY_SIZE; i++) {
      num = random.nextInt(ARRAY_SIZE * 10);
      for (int j = 0; j < strategies.length; j++) {
        data.get(j).add(num);
      }
    }

    for (int i = 0; i < strategies.length; i++) {
//      System.out.println(data.get(i));
      long ops;
      LocalTime start = LocalTime.now();
      ops = strategies[i].sort(data.get(i));
      long time = LocalTime.now().toNanoOfDay() - start.toNanoOfDay();
//      System.out.println(data.get(i));
      System.out.println(time / 1000000 + " ms & " + ops + " char. operations.");
    }
  }
}
