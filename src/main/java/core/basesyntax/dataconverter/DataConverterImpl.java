package core.basesyntax.dataconverter;

import core.basesyntax.exception.DataProcessingException;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();

        data.stream()
                .skip(1)
                .forEach(line -> {
                    try {
                        String[] fields = line.split(SPLITTER);
                        if (fields.length < 3) {
                            throw new DataProcessingException(
                                    "Error: the string does not contain all 3 fields: "
                                            +
                                            line);
                        }

                        FruitTransaction.Operation operation = FruitTransaction.Operation
                                        .fromCode(fields[OPERATION_INDEX].trim());
                        String fruit = fields[FRUIT_NAME_INDEX].trim();

                        int quantity;
                        try {
                            quantity = Integer.parseInt(fields[QUANTITY_INDEX].trim());
                            if (quantity < 0) {
                                throw new DataProcessingException(
                                        "\n"
                                                +
                                                "Error: negative amount of fruit in the line: "
                                                +
                                                line);
                            }
                        } catch (NumberFormatException e) {
                            throw new DataProcessingException(
                                    "Error: quantity is not a number in the string: "
                                            +
                                            line);
                        }

                        transactions.add(new FruitTransaction(operation, fruit, quantity));

                    } catch (DataProcessingException e) {
                        System.err.println(e.getMessage());
                    }
                });

        return transactions;
    }
}
