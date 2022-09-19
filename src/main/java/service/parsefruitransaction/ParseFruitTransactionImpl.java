package service.parsefruitransaction;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class ParseFruitTransactionImpl implements ParseFruitTransaction {
    private final String skipTitleFile = Pattern.compile("(\\w+,){2}\\d+").pattern();
    private final int typeFruitOperation = 0;
    private final int nameFruit = 1;
    private final int quantityFruit = 2;

    @Override
    public List<FruitTransaction> parseToFruitTransactions(List<String> rowFruitTransaction) {
        return rowFruitTransaction.stream()
                .filter(c -> c.matches(skipTitleFile))
                .map(this::getFruitFromCsvRow)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction.Operation operation = getOperationFromRowCsv(fields[typeFruitOperation]);
        String nameFruit = fields[this.nameFruit];
        int quantity = Integer.parseInt(fields[quantityFruit]);
        return new FruitTransaction(operation,nameFruit,quantity);
    }

    private FruitTransaction.Operation getOperationFromRowCsv(String rowOperation) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(c -> c.getOperation().equals(rowOperation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Activities at the store is not valid, "
                        + "add new activity to Enum (Operation)"));
    }
}
