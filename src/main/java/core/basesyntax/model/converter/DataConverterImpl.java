package core.basesyntax.model.converter;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        inputReport.stream()
                .skip(1)
                .map(line -> line.split(","))
                .filter(parts -> parts.length == 3)
                .map(parts -> new FruitTransaction(
                        FruitTransaction.Operation.fromCode(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2])
                ))
                .forEach(transactions::add);

        return transactions;
    }
}
