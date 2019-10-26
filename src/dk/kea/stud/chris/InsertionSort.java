package dk.kea.stud.chris;

import java.util.List;

public class InsertionSort extends SortingStrategy {

  InsertionSort() {
    super("Insertion Sort");
  }

  @Override
  public long sort(List<Integer> data) {
    int n = data.size();
    long noOps = 0;
    for (int i = 1; i < n; ++i) {
      int key = data.get(i);
      int j = i - 1;
      while (j >= 0 && data.get(j) > key) {
        noOps++;
        data.set(j + 1, data.get(j));
        j = j - 1;
      }
      data.set(j + 1, key);
    }
    return noOps;
  }
}
