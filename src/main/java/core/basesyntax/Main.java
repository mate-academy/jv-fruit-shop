package core.basesyntax;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.OperationStrategy;
import core.basesyntax.service.operations.OperationStrategyImpl;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;
import core.basesyntax.service.readandwritetofile.CsvFileReader;
import core.basesyntax.service.readandwritetofile.CsvFileReaderImpl;
import core.basesyntax.service.readandwritetofile.CsvOutputFileWriter;
import core.basesyntax.service.readandwritetofile.CsvOutputFileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CsvFileReader dataReader = new CsvFileReaderImpl();
        List<String> transactions = dataReader.readFromFile();

        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler();
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler();
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler();

        TransactionParser transactionParser = new TransactionParserImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, balanceOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, supplyOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchaseOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, supplyOperationHandler);

        List<FruitTransaction> fruitTransaction =
                transactionParser.getFruitTransaction(transactions);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        for (FruitTransaction fruTrans : fruitTransaction) {
            OperationHandler operationHandler = operationStrategy.getOperation(fruTrans);
            operationHandler.proceedOperation(fruTrans);
        }
        CsvOutputFileWriter csvOutputFileWriter = new CsvOutputFileWriterImpl();
        csvOutputFileWriter.createCscWithTitle();
        csvOutputFileWriter.saveReportToCsv(Storage.report);
    }
}


