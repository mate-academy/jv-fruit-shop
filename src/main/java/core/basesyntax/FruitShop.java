package core.basesyntax;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionHandlerService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.TransactionHandlerServiceImpl;

import java.io.File;
import java.util.List;

public class FruitShop {
    public static void main(String[] args) {
        File file = new File("src/main/resources/file.txt");
        ReaderService readerService = new ReaderServiceImpl();
        List<String> list =readerService.readFromFile(file);

        TransactionHandlerService transactionHandlerService = new TransactionHandlerServiceImpl();
        List<String> report = transactionHandlerService.getReport(list);
    }
}
