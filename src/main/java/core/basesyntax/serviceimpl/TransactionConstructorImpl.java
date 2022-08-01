package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionConstructor;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionConstructorImpl implements TransactionConstructor {
    private FruitTransaction transaction;

    @Override
    public FruitTransaction packToObject(String fromFile) {
        transaction = new FruitTransaction();
        String[] splitted = fromFile.split(",");
        transaction.setOperation(FruitTransaction.Operation
                .getOperationBySymbol(splitted[0]));
        transaction.setFruitType(splitted[1]);
        transaction.setQuantity(Integer.parseInt(splitted[2]));
        return transaction;
    }

    @Override
    public List<FruitTransaction> packToObject(List<String> fromFile) {
        return fromFile.stream()
                .skip(1)
                .map(this::packToObject)
                .collect(Collectors.toList());
    }
}

