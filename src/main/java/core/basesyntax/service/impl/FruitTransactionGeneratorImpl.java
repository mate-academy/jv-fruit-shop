package core.basesyntax.service.impl;

public class FruitTransactionGeneratorImpl implements FruitTransactionGenerator {
    @Override
    public FruitTransaction createFruitTransaction(String[] metadata) {
        FruitTransaction.Operation operation = FruitTransaction
                .Operation
                .getByCodeOperation(metadata[0]);
        String name = metadata[1];
        int quantity = Integer.parseInt(metadata[2]);
        return new FruitTransaction(operation, name,quantity);
    }
}
