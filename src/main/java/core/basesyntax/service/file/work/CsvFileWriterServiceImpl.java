package core.basesyntax.service.file.work;

import core.basesyntax.model.FruitTransaction;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String writeToFilePath, List<FruitTransaction> data) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(writeToFilePath))) {
            data.stream()
                    .map(transaction -> String.join(",",
                            transaction.getFruit(),
                            String.valueOf(transaction.getQuantity())))
                    .forEach(printWriter::println);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to this path: "
                    + writeToFilePath, e);
        }
    }
}
