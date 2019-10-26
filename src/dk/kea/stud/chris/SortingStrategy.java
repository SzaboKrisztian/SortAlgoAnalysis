package dk.kea.stud.chris;

import java.util.List;

public abstract class SortingStrategy {
  private String name;

  SortingStrategy(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  abstract long sort(List<Integer> data);
}