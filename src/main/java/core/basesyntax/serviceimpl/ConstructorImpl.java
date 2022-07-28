package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Constructor;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstructorImpl implements Constructor {
    @Override
    public Map<String, List<FruitTransaction>> processTheData(List<String> fromFile) {
        if (fromFile.isEmpty()) {
            throw new RuntimeException("The current list is empty: " + fromFile);
        }
        return fromFile.stream()
                .skip(1)
                .map(s -> {
                    String[] splitted = s.split(",");
                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(FruitTransaction.Operation
                            .getOperationBySymbol(splitted[0]));
                    transaction.setFruitType(splitted[1]);
                    transaction.setQuantity(Integer.parseInt(splitted[2]));
                    return transaction;
                })
                .collect(Collectors.groupingBy(FruitTransaction::getFruitType));
    }
}
