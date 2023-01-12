package core.basesyntax.strategy;

public class Balance implements FruitService {
    @Override
    public int calculateFruits(int startAmount, int amountToOperate) {
        return amountToOperate;
    }
}
