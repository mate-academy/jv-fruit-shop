package core.basesyntax.service;

import core.basesyntax.service.reader.ReaderService;
import core.basesyntax.service.writer.WriterService;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private ReaderService readerService;
    private WriterService writerService;

    public FruitTransactionServiceImpl(ReaderService readerService, WriterService writerService) {
        this.readerService = readerService;
        this.writerService = writerService;
    }

    @Override
    public void transaction(String inputFile, String outputFile) {
        readerService.readFromFile(inputFile);
        writerService.writeToFile(outputFile);
    }
}
