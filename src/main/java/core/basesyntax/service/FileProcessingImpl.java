package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessingImpl implements FileProcessing {
    private static final String TRANSACTION_OF_DAY = "src/main/resources/movementPerDay.csv";
    private static final String DAILY_REPORT = "src/main/resources/dailyReport.csv";
    private static final String MASSAGE = "Can't get data from file ";
    private static final String TITLE_STRING = "type,fruit,quantity";
    private static final String TITLE_STRING_REPORT = "fruit,quantity";
    private static final String MASSAGE_OF_EXCESSIVE_QUANTITY = "Check the "
            + "data is a negative quantity of the product";

    @Override
    public void add(List<Fruit> fruitList) {
        if (fruitList.stream().filter(quan -> quan.getQuantity() < 0).count() > 0) {
            throw new RuntimeException(MASSAGE_OF_EXCESSIVE_QUANTITY);
        }
        String headReport = TITLE_STRING_REPORT + "\n";
        String fruitReport = headReport + fruitList.stream()
                .map(o -> o.getFruit() + "," + o.getQuantity())
                .collect(Collectors.joining("\n"));
        try {
            Files.write(Paths.get(DAILY_REPORT), fruitReport.getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + DAILY_REPORT);
        }
    }

    @Override
    public List<FruitTransaction> getListOfTransaction() {
        List<String> stringList;
        try {
            stringList = Files.readAllLines(Path.of(TRANSACTION_OF_DAY));
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + TRANSACTION_OF_DAY);
        }
        return stringList.stream()
                .filter(string -> !string.equals(TITLE_STRING))
                .map(str -> str.split(","))
                .map(transaction -> new FruitTransaction(transaction[0],
                        transaction[1], transaction[2]))
                .collect(Collectors.toList());
    }
}
