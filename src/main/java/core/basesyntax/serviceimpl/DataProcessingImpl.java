package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessing;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessingImpl implements DataProcessing {
    private static final List<String> REPORT = List.of("fruit,quantity");

    @Override
    public List<String> getReport(Map<String, List<FruitTransaction>> fruits) {
        return Stream.concat(REPORT.stream(), getFruitsRemainder(fruits).stream())
                .collect(Collectors.toList());
    }

    private List<String> getFruitsRemainder(Map<String, List<FruitTransaction>> fruits) {
        return fruits.entrySet().stream()
                .map(this::getFruitFinalBalance)
                .collect(Collectors.toList());
    }

    private String getFruitFinalBalance(Map.Entry<String, List<FruitTransaction>> e) {
        int balanceQuantity = getQuantityByOperationType(e.getValue(),
                FruitTransaction.Operation.BALANCE);
        int supplyQuantity = getQuantityByOperationType(e.getValue(),
                FruitTransaction.Operation.SUPPLY);
        int purchaseQuantity = getQuantityByOperationType(e.getValue(),
                FruitTransaction.Operation.PURCHASE);
        int returnQuantity = getQuantityByOperationType(e.getValue(),
                FruitTransaction.Operation.RETURN);

        int finalBalance = balanceQuantity + supplyQuantity
                + returnQuantity - purchaseQuantity;
        return "" + e.getKey() + "," + finalBalance;
    }

    private int getQuantityByOperationType(List<FruitTransaction> transaction,
                                           FruitTransaction.Operation operation) {
        int quantity;
        try {
            quantity = getTransactionByOperationType(transaction, operation).getQuantity();
        } catch (NoSuchElementException e) {
            return 0;
        }
        return quantity;
    }

    private FruitTransaction getTransactionByOperationType(List<FruitTransaction> transaction,
                                                           FruitTransaction.Operation operation) {
        return transaction.stream()
                .filter(t -> t.getOperation() == operation)
                .findFirst().get();
    }
}
