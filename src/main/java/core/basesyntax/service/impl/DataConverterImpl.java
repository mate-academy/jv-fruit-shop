package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Converter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements Converter {

    private static final int HEADER_OFFSET = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {

        if (inputReport == null) {
            throw new RuntimeException("Input list cannot be null");
        }

        List<FruitTransaction> transactions = new ArrayList<>();
        try {
            for (int i = HEADER_OFFSET; i < inputReport.size(); i += 3) {
                String type = inputReport.get(i);
                String fruit = inputReport.get(i + 1);
                int quantity = Integer.parseInt(inputReport.get(i + 2));

                transactions.add(new FruitTransaction(
                        FruitTransaction.Operation.fromCode(type),
                        fruit,
                        quantity
                ));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input file contains invalid quantity value "
                    + "– expected an integer.", e);
        }
        return transactions;
    }
}
