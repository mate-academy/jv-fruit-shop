package core.basesyntax.model;

public class CsvTransactionParser implements TransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction[] parseTransaction(String[] csvLines) {
        FruitTransaction[] transactions = new FruitTransaction[csvLines.length - 1];
        for (int i = 1; i < csvLines.length; i++) {
            String csvLine = csvLines[i];
            String[] parts = csvLine.split(",");
            Operation operation = Operation.getByCode(parts[OPERATION_INDEX]);
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            transactions[i - 1] = new FruitTransaction(operation, fruit, quantity);
        }
        return transactions;
    }
}
