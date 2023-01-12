package core.basesyntax.service.fileWorkWith;

import core.basesyntax.model.FruitTransaction;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVFileWriterServiceImpl implements CSVFileWriterService {
    @Override
    public void writeToFile(String writeToFilePath, List<FruitTransaction> data) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(writeToFilePath))){
            data.stream()
                    .map(this::convertToCSV)
                    .forEach(printWriter::println);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to this path: "
                    + writeToFilePath, e);
        }
    }

    private String convertToCSV(FruitTransaction transaction) {
        return String.join(",", transaction.getFruit(), String.valueOf(transaction.getQuantity()));
    }
}
