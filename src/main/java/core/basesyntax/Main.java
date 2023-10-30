package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorServiceImpl;
import java.util.List;

public class Main {
    public static final String INPUT = "\\src\\main\\resources\\input.csv";
    public static final String OUTPUT = "\\src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        ReaderService readerService = new CsvReaderServiceImpl();
        List<FruitTransaction> transactions = readerService.readFromFile(INPUT);

        ProcessorService processorService = new TransactionProcessorServiceImpl();
        FruitStorage storage = new FruitStorage();
        processorService.processTransactions(transactions, storage);

        WriterService writerService = new CsvWriterServiceImpl();
        writerService.writeToFile(OUTPUT, storage.getFruitQuantities());
    }
}
