package tuple;

public class Tuple {
  private String key;
  private int value;

  public Tuple(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public int getValue() {
    return this.value;
  }

  public String toString() {
    return "(" + this.key + ", " + this.value + ")";
  }
}
