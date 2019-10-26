package dk.kea.stud.chris;

import java.util.ArrayList;
import java.util.List;

public class MergeSort extends SortingStrategy {
  static long noOps = 0;

  @Override
  public long sort(List<Integer> data) {
    sort(data, 0, data.size() - 1);
    return noOps;
  }

  private void merge(List<Integer> arr, int l, int m, int r)
  {
    int n1 = m - l + 1;
    int n2 = r - m;

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int i=0; i<n1; ++i)
      left.add(arr.get(l + i));
    for (int j=0; j<n2; ++j)
      right.add(arr.get(m + 1+ j));

    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2)
    {
      noOps++;
      if (left.get(i) <= right.get(j))
      {
        arr.set(k, left.get(i));
        i++;
      }
      else
      {
        arr.set(k, right.get(j));
        j++;
      }
      k++;
    }

    while (i < n1)
    {
      noOps++;
      arr.set(k, left.get(i));
      i++;
      k++;
    }

    while (j < n2)
    {
      noOps++;
      arr.set(k, right.get(j));
      j++;
      k++;
    }
  }

  private void sort(List<Integer> arr, int l, int r)
  {
    if (l < r)
    {
      int m = (l+r)/2;

      sort(arr, l, m);
      sort(arr , m+1, r);

      merge(arr, l, m, r);
    }
  }
}
