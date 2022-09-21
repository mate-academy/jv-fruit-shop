package service.fruittransactionparser;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_CODE = 0;
    private static final int NAME_FRUIT = 1;
    private static final int QUANTITY_FRUIT = 2;

    @Override
    public List<FruitTransaction> parseToFruitTransactions(List<String> rowFruitTransaction) {
        return rowFruitTransaction.stream()
                .skip(1)
                .map(this::getFruitFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .getByCode(fields[OPERATION_CODE]);
        String nameFruit = fields[this.NAME_FRUIT];
        int quantity = Integer.parseInt(fields[QUANTITY_FRUIT]);
        return new FruitTransaction(operation,nameFruit,quantity);
    }
}
