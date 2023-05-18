package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopFileReader;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopFileReaderImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import java.util.List;

public class FruitShopReporting {
    public static final String SOURCE_FILE_PATH = "src/main/java/core/basesyntax/files/actions.csv";
    public static final String TARGET_FILE_PATH = "src/main/java/core/basesyntax/files/report.csv";

    public static void main(String[] args) {
        TransactionService transactionService = new TransactionServiceImpl();
        ShopFileReader reader = new ShopFileReaderImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String info = reader.read(SOURCE_FILE_PATH);
        List<FruitTransaction> transactionList = transactionService
                .getListOfTransactionsFromString(info);
        transactionService.processAllTransactions(transactionList);
        reportGenerator.generate(TARGET_FILE_PATH);
    }
}
