package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        if (report == null) {
            throw new IllegalArgumentException("Provided report is null."
                    + " Can't be processed.");
        }
        try {
            for (String line : report) {
                if (line.equals(HEADER)) {
                    continue;
                }
                String[] split = line.split(COMMA);
                String operation = split[OPERATION_INDEX];
                String fruit = split[FRUIT_INDEX];
                int quantity = Integer.parseInt(split[QUANTITY_INDEX]);
                FruitTransaction transaction = new FruitTransaction(operation,
                        fruit, quantity);
                transactionsList.add(transaction);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Wrong text format, unable to parse the string."
                    + "Check input file.", e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong number format, unable to parse. "
                    + "Check input file.", e);
        }
        return transactionsList;
    }
}
