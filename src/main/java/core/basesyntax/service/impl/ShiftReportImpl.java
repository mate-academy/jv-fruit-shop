package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileProcessing;
import core.basesyntax.service.FileProcessingImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShiftReportImpl implements ShiftReport {

    @Override
    public void addReport() {
        FileProcessing fileProcessing = new FileProcessingImpl();
        List<FruitTransaction> fruitTransactions = fileProcessing.get();
        Map<String, Integer> datesReport = fruitTransactions.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.mapping(this::getSum, Collectors.summingInt(p -> p))));
        fileProcessing.update(datesReport);
    }

    private Integer getSum(FruitTransaction fruitTransaction) {
        Integer result = 0;
        if (fruitTransaction.getOperation().equals(FruitTransaction.Operation.BALANCE)) {
            return result + fruitTransaction.getQuantity();
        } else if (fruitTransaction.getOperation().equals(FruitTransaction.Operation.SUPPLY)) {
            return result + fruitTransaction.getQuantity();
        } else if (fruitTransaction.getOperation().equals(FruitTransaction.Operation.PURCHASE)) {
            return result - fruitTransaction.getQuantity();
        } else {
            return result + fruitTransaction.getQuantity();
        }
    }
}
