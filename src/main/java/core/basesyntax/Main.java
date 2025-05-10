package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseHandlerImpl;
import core.basesyntax.strategy.impl.ReturnHandlerImpl;
import core.basesyntax.strategy.impl.SupplyHandlerImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/InputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/OutputFile.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        List<String> dataFromFile = reader.readFile(INPUT_FILE_PATH);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser.parseData(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                Operation.BALANCE, new BalanceHandlerImpl(),
                Operation.SUPPLY, new SupplyHandlerImpl(),
                Operation.PURCHASE, new PurchaseHandlerImpl(),
                Operation.RETURN, new ReturnHandlerImpl()));

        TransactionProcessor transactionProcessor = new TransactionProcessorImpl(operationStrategy);
        transactionProcessor.process(fruitTransactions);

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeDataToFile(report, OUTPUT_FILE_PATH);
    }
}
