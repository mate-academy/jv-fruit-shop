package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriteServiceImpl implements FileWriterService {
    private static final String NEW_FILE_NAME =
            "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/fileReport.csv";

    @Override
    public void writeReport(List<Fruit> inputList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NEW_FILE_NAME))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Fruit fruit : inputList) {
                bufferedWriter.write(fruit.getName() + "," + fruit.getAmount()
                        + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write information ito the file " + NEW_FILE_NAME);
        }
    }
}
