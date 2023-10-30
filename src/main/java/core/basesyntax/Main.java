package core.basesyntax;

import java.util.List;

public class Main {
    public static final String INPUT = "input.csv";
    public static final String OUTPUT = "output.csv";

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
