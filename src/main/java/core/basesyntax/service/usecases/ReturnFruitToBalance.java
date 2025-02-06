package core.basesyntax.service.usecases;

public interface ReturnFruitToBalance extends FruitUseService {
    void run(String fruitName, int amount);
}
