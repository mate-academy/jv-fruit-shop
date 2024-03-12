package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.impl.FruitTransactionParserImpl;
import core.basesyntax.impl.FruitTransactionProcessorImpl;
import core.basesyntax.impl.ReaderServiceImplFromCsv;
import core.basesyntax.impl.ReportCreatorImpl;
import core.basesyntax.impl.WriterServiceImplToCsv;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.ReaderService;
import core.basesyntax.servise.ReportCreator;
import core.basesyntax.servise.TransactionParser;
import core.basesyntax.servise.TransactionProcessor;
import core.basesyntax.servise.WriterService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategy = new HashMap<>();
        strategy.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        strategy.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        strategy.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        strategy.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        ReaderService readerFromFile = new ReaderServiceImplFromCsv();

        List<String> dataFromFile = readerFromFile
                .readFromFile("src\\main\\resources\\inputFile.csv");

        TransactionParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactions = parser.dataConverter(dataFromFile);

        TransactionProcessor processor = new FruitTransactionProcessorImpl();
        processor.transactionProcessor(fruitTransactions, strategy);

        ReportCreator report = new ReportCreatorImpl();
        String string = report.reportCreator(FruitStorage.fruitTransactionStorage);

        WriterService writerService = new WriterServiceImplToCsv();
        writerService.writeToFile(string, "src\\main\\resources\\outputFile.csv");
    }
}
