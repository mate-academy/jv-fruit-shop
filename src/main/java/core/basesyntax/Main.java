package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.DataParsedImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE = "src/main/resources/source.csv";
    private static final String TARGET = "src/main/resources/target.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl(),
                        FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl(),
                        FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl(),
                        FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());

        ReaderService readerService = new CsvReaderServiceImpl();
        List<String> dataFromCsvFile = readerService.readFromCsvFile(SOURCE);

        ParserService parserService = new DataParsedImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseData(dataFromCsvFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);

        TransactionService calculationService = new TransactionServiceImpl(operationStrategy);
        calculationService.processTransactions(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();

        WriterService writerService = new CsvWriterServiceImpl();
        writerService.writeToFile(TARGET, report);

    }
}
