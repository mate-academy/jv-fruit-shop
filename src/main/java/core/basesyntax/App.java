package core.basesyntax;

import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.reader.ReaderServiceICsvImpl;
import core.basesyntax.service.writer.WriterServiceCsvImpl;

public class App {
    private static final String FILE_NAME_INPUT = "input.csv";
    private static final String FILE_NAME_OUTPUT = "result.csv";

    public static void main(String[] args) {
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl(
                new ReaderServiceICsvImpl(), new WriterServiceCsvImpl());
        fruitTransactionService.transaction(FILE_NAME_INPUT, FILE_NAME_OUTPUT);
    }

}
