package core.storage;

public interface FruitOperations {

    public boolean supply(FruitPackageDTO fruitPackageDTO, int quantity);

    public boolean buy(FruitPackageDTO fruitPackageDTO, int quantity);

    public boolean refund(FruitPackageDTO fruitPackageDTO, int quantity);
}
