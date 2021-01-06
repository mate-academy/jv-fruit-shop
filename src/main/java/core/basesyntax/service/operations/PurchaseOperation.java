package core.basesyntax.service.operations;

public class PurchaseOperation implements Operation {
    @Override
    public Integer operation(Integer oldValue, Integer input) {
        if (oldValue < input) {
            throw new RuntimeException("Can't purchase. Haven't enough fruit");
        }
        return oldValue - input;
    }
}
