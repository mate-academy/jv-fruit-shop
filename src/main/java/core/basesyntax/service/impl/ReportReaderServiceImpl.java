package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReportReaderServiceImpl implements ReportReaderService {
    @Override
    public List<FruitTransaction> readFile(String filePath) {
        List<String> inputReport;
        try {
            inputReport = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + filePath);
        }
        return inputReport.stream()
                .skip(1)
                .map(this::getDataLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction getDataLine(String line) {
        String[] field = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(fruitTransaction.getOperation(field[0]));
        fruitTransaction.setFruit(new Fruit(field[1]));
        fruitTransaction.setQuantity(Integer.parseInt(field[2]));
        return fruitTransaction;
    }
}
