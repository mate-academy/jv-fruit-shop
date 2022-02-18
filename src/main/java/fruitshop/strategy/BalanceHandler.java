package fruitshop.strategy;

public class BalanceHandler implements OperationHandler {

    @Override
    public int process(int quality, int balance) {
        return quality;
    }
}
