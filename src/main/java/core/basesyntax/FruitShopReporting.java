package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.ShopFileReader;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.ShopFileReaderImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import java.util.List;

public class FruitShopReporting {
    public static final String SOURCE_FILE_PATH = "src/main/java/core/basesyntax/files/actions.csv";
    public static final String TARGET_FILE_PATH = "src/main/java/core/basesyntax/files/report.csv";

    public static void main(String[] args) {
        OperationMap operationMap = new OperationMap();
        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(operationMap.get());
        TransactionService transactionService = new TransactionServiceImpl(transactionStrategy);
        ShopFileReader reader = new ShopFileReaderImpl();
        ReportWriter reportGenerator = new ReportWriterImpl();

        String info = reader.read(SOURCE_FILE_PATH);
        List<FruitTransaction> transactionList = transactionService
                .getListOfTransactionsFromString(info);
        transactionService.processAllTransactions(transactionList);
        reportGenerator.writeToFile(TARGET_FILE_PATH);
    }
}
