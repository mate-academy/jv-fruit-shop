package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileProcessingImpl implements FileProcessing {
    private static final String TRANSACTION_OF_DAY = "src/main/resources/movementPerDay.csv";
    private static final String DAILY_REPORT = "src/main/resources/dailyReport.csv";
    private static final String MASSAGE = "Can't get data from file ";
    private static final String TITLE_STRING = "type,fruit,quantity";
    private static final String TITLE_STRING_REPORT = "fruit,quantity";

    @Override
    public void add(FruitTransaction fruitTransaction) {
        String fruitTransactionString = String.join(",",
                String.valueOf(fruitTransaction.getOperation().getCode()),
                String.valueOf(fruitTransaction.getFruit()),
                fruitTransaction.getQuantity() + "\n");
        try {
            Files.write(Paths.get(TRANSACTION_OF_DAY), fruitTransactionString.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + TRANSACTION_OF_DAY);
        }
    }

    @Override
    public List<FruitTransaction> get() {
        List<String> stringList;
        try {
            stringList = Files.readAllLines(Path.of(TRANSACTION_OF_DAY));
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + TRANSACTION_OF_DAY);
        }
        return stringList.stream()
                .filter(string -> !string.equals(TITLE_STRING))
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Map<String, Integer> newData) {
        String newTitle = TITLE_STRING + System.lineSeparator()
                + newData.entrySet().stream()
                .map(p -> "b," + p.getKey() + "," + p.getValue())
                .collect(Collectors.joining(System.lineSeparator()))
                + System.lineSeparator();
        String newString = TITLE_STRING_REPORT + System.lineSeparator()
                + newData.entrySet().stream()
                .map(p -> p.getKey() + "," + p.getValue())
                        .collect(Collectors.joining(System.lineSeparator()))
                + System.lineSeparator();
        try {
            Files.write(Paths.get(TRANSACTION_OF_DAY), newTitle.getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + TRANSACTION_OF_DAY);
        }
        try {
            Files.write(Paths.get(DAILY_REPORT), newString.getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + DAILY_REPORT);
        }

    }

    private FruitTransaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE.getEnum(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
