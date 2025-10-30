package service.basesyntax.service;

import java.util.List;

public class TransactionReaderService {
    private final ReaderService readerService;

    public TransactionReaderService(ReaderService readerService) {
        if (readerService == null) {
            throw new NullPointerException("readerService is null");
        }
        this.readerService = readerService;
    }

    public List<String> readTransactions(String path) {
        if (path == null) {
            throw new NullPointerException("path is null");
        }
        return readerService.readLines(path);
    }
}
