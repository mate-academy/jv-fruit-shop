package core.storage;

public interface FruitOperations {
    public boolean supply(Fruit fruit, int quantity);
    public boolean buy(Fruit fruit, int quantity);
    public boolean refund(Fruit fruit, int quantity);
}
