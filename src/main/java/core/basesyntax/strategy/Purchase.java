package core.basesyntax.strategy;

public class Purchase implements FruitService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return startAmount - amountToOperate;
    }
}
