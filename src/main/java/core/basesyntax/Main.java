package core.basesyntax;

import core.basesyntax.service.ConverterCsvToTransactions;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<List<String>> fileStrings = fileReader.readFile("src/main/resources/testOK.csv");
        ConverterCsvToTransactions converter = new ConverterCsvToTransactions();
        List<Transaction> transactions = converter.convert(fileStrings);
        Storage storage = new Storage();
        storage.fillStorage(transactions);

        Map<String, Integer> fruitsQuantity = storage.getFruitsQuantityByType();
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry: fruitsQuantity.entrySet()) {
            result.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeToFile("src/main/resources/OutputFile.csv", result.toString());
    }
}
