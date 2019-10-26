package dk.kea.stud.chris;

import java.util.List;

public class BubbleSort extends SortingStrategy {
  @Override
  public long sort(List<Integer> data) {
    int n = data.size();
    int temp;
    long noOps = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        noOps++;
        if (data.get(j) > data.get(j + 1)) {
          // swap arr[j+1] and arr[i]
          temp = data.get(j);
          data.set(j, data.get(j + 1));
          data.set(j + 1, temp);
        }
      }
    }
    return noOps;
  }
}
