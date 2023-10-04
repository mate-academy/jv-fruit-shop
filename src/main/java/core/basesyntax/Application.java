package core.basesyntax;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionListParserService;
import core.basesyntax.service.TransferToDbService;
import core.basesyntax.service.impl.FileReaderServiceCsvImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.ReportWriterToFileServiceToCsvImpl;
import core.basesyntax.service.impl.TransactionListParserServiceImpl;
import core.basesyntax.service.impl.TransferToDbServiceImpl;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceProcessor;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseProcessor;
import core.basesyntax.strategy.impl.ReturnProcessor;
import core.basesyntax.strategy.impl.SupplyProcessor;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Map<FruitTransaction.Operation, OperationProcessor> strategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceProcessor(new ProductDaoImpl()),
                FruitTransaction.Operation.SUPPLY, new SupplyProcessor(new ProductDaoImpl()),
                FruitTransaction.Operation.PURCHASE, new PurchaseProcessor(new ProductDaoImpl()),
                FruitTransaction.Operation.RETURN, new ReturnProcessor(new ProductDaoImpl()));
        FileReaderService fileReaderService =
                new FileReaderServiceCsvImpl("src/main/resources/input/testFile.csv");
        TransactionListParserService transactionListParserService =
                new TransactionListParserServiceImpl();
        OperationStrategy strategy = new OperationStrategyImpl(strategyMap);
        TransferToDbService transferToDbService =
                new TransferToDbServiceImpl(strategy);
        ReportCreatorService reportCreatorService =
                new ReportCreatorServiceImpl(new ProductDaoImpl());
        ReportWriterToFileServiceToCsvImpl writerToCsv =
                new ReportWriterToFileServiceToCsvImpl("src/main/resources/output");

        List<FruitTransaction> fruitTransactions =
                transactionListParserService.parse(fileReaderService.readFile());
        transferToDbService.transfer(fruitTransactions);
        writerToCsv.writeToFile(reportCreatorService.createReport());
    }
}
