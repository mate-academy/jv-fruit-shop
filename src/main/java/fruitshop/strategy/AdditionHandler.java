package fruitshop.strategy;

public class AdditionHandler implements OperationHandler {

    @Override
    public int process(int quality, int balance) {
        return balance + quality;
    }
}
