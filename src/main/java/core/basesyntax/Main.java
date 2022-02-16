package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.FileService;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.FileServiceImpl;

import java.util.List;

public class Main {
    private static final String SOURCE_FILE_PATH = "src/main/java/core/basesyntax/source/input.csv";
    private static final String REPORT_FILE = "src/main/java/core/basesyntax/source/report.csv";
    private static final FileService fileService = new FileServiceImpl();
    private static final TransactionService transactionService = new TransactionServiceImpl();

    public static void main(String[] args) {

        List<String> rawDataFromFile = fileService.read(SOURCE_FILE_PATH);
        System.out.println(rawDataFromFile);

        List<FruitTransaction> fruitsTransactionList = transactionService.processData(rawDataFromFile);
        System.out.println(fruitsTransactionList);

    }
}
