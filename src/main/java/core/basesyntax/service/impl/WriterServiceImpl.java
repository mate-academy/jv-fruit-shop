package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WriterServiceImpl implements WriterService {
    private final String fileName = "src/main/resources/report.csv";

    @Override
    public void writeToFile(List<Fruit> fruits) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(generateReport(fruits));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fileName, e);
        }
    }

    private String generateReport(List<Fruit> fruits) {
        String firstRow = "fruit,quantity\n";
        return firstRow.concat(fruits.stream()
                .map(item -> String.format("%s,%s", item.getFruit(),item.getQuantity()))
                .collect(Collectors.joining("\n")));
    }
}
