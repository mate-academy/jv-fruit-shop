package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(a -> a.trim())
                .map(a -> a.split(","))
                .filter(a -> isDataCorrect(a))
                .map(el -> {
                    FruitTransaction transaction = new FruitTransaction();
                            transaction.setOperation(el[0]);
                            transaction.setFruit(el[1]);
                            transaction.setQuantity(Integer.valueOf(el[2]));
                            return transaction;
                }
                )
                .collect(Collectors.toList());
    }

    private boolean isDataCorrect(String[] line) {
        if (line.length == 3) {
            return true;
        }
        throw new RuntimeException("Incorrect input data");
    }
}
