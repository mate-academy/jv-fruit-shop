package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        List<String> strings = csvFileReaderService.fileReader("src/main/resources/before.csv");

        FruitTransaction fruitTransaction = new FruitTransactionImpl();
        fruitTransaction.dateProcessing(strings);

        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        csvFileWriterService.fileWriter("src/main/resources/after.csv");

        System.out.println(Storage.fruitStorage);
    }
}
