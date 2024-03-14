package core.basesyntax;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.impl.FruitTransactionParserImpl;
import core.basesyntax.impl.FruitTransactionProcessorImpl;
import core.basesyntax.impl.ReaderServiceImplFromCsv;
import core.basesyntax.impl.ReportCreatorImpl;
import core.basesyntax.impl.WriterServiceImplToCsv;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategy =
                Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        ReaderService readerFromFile = new ReaderServiceImplFromCsv();

        List<String> dataFromFile = readerFromFile
                .readFromFile("src\\main\\resources\\inputFile.csv");

        TransactionParser parser = new FruitTransactionParserImpl();
        List<FruitTransaction> fruitTransactions = parser.converterToTransactions(dataFromFile);

        TransactionProcessor processor = new FruitTransactionProcessorImpl();
        processor.transactionProcessor(fruitTransactions, strategy);

        ReportCreator report = new ReportCreatorImpl();
        String string = report.reportCreator(FruitStorage.fruitTransactionStorage);

        WriterService writerService = new WriterServiceImplToCsv();
        writerService.writeToFile(string, "src\\main\\resources\\outputFile.csv");
    }
}
