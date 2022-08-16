package core.basesyntax.service.csvfileservice;

import core.basesyntax.model.FruitTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderService {
    private static final String FILE_NAME = "jv-fruit-shop/src/main/resources/input_data.csv";
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_FRUIT_TYPE = 1;
    private static final int INDEX_FRUIT_QUANTITY = 2;

    public List<FruitTransaction> getFruitTransactionsFromCsv() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file" + FILE_NAME, e);
        }
        return lines.stream()
                .filter(l -> !l.startsWith("t"))
                .map(this::getDataFromCsvRow).collect(Collectors.toList());
    }

    private FruitTransaction getDataFromCsvRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        Arrays.stream(FruitTransaction.Operation.values())
                        .filter(o -> o.getOperation().equals(fields[INDEX_OPERATION_TYPE]))
                                .forEach(fruitTransaction::setOperation);
        fruitTransaction.setFruit(fields[INDEX_FRUIT_TYPE]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_FRUIT_QUANTITY]));
        return fruitTransaction;
    }
}
