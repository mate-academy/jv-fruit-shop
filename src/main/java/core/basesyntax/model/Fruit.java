package core.basesyntax.model;

public class Fruit {
  private int amount;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Fruit(int amount) {
    this.amount = amount;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
