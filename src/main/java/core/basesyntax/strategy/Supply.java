package core.basesyntax.strategy;

public class Supply implements FruitService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount + amountToOperate;
    }
}
