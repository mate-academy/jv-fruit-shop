package core.basesyntax.service.usecases;

public interface PushareFruit extends FruitUseService {
    void run(String fruitName, int amount);
}
