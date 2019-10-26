package dk.kea.stud.chris;

import java.util.List;

public class QuickSort extends SortingStrategy {
  private static long NoOps;

  @Override
  long sort(List<Integer> data) {
    NoOps = 0;
    quickSort(data, 0, data.size() - 1);
    return NoOps;
  }

  public static void quickSort(List<Integer> arr, int start, int end) {

    int partition = partition(arr, start, end);

    if (partition - 1 > start) {
      NoOps++;
      quickSort(arr, start, partition - 1);
    }
    if (partition + 1 < end) {
      NoOps++;
      quickSort(arr, partition + 1, end);
    }
  }

  public static int partition(List<Integer> arr, int start, int end) {
    int pivot = arr.get(end);

    for (int i = start; i < end; i++) {
      if (arr.get(i) < pivot) {
        NoOps++;
        Integer temp = arr.get(start);
        arr.set(start, arr.get(i));
        arr.set(i, temp);
        start++;
      }
    }

    Integer temp = arr.get(start);
    arr.set(start, pivot);
    arr.set(end, temp);

    return start;
  }
}
