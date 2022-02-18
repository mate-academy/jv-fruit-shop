package fruitshop.strategy;

public class SubtractionHandler implements OperationHandler {

    @Override
    public int process(int quality, int balance) {
        return balance - quality;
    }
}
