package core.basesyntax.service.usecases;

public interface SupplyFruitToBalance extends FruitUseService {
    void run(String fruitName, int amount);
}
