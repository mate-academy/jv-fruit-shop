package core.basesyntax;

import core.basesyntax.dao.CsvDataReader;
import core.basesyntax.dao.CsvDataReaderImpl;
import core.basesyntax.dao.CsvOutputFileWriter;
import core.basesyntax.dao.CsvOutputFileWriterImpl;
import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionParserImpl;
import core.basesyntax.service.operations.BalanceOperationHandler;
import core.basesyntax.service.operations.OperationStrategy;
import core.basesyntax.service.operations.OperationStrategyImpl;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperationHandler;
import core.basesyntax.service.operations.SupplyOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler();
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler();
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,balanceOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,supplyOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,purchaseOperationHandler);
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,supplyOperationHandler);

        TransactionParser transactionParser = new TransactionParserImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        CsvDataReader dataReader = new CsvDataReaderImpl();
        List<String> transactions = dataReader.readFromFile();
        //receiving List of transactions
        List<FruitTransaction> fruitTransaction = transactionParser.getFruitTransaction(transactions);

        for(FruitTransaction fruTrans: fruitTransaction) {
            OperationHandler operationHandler = operationStrategy.getOperation(fruTrans);
            operationHandler.proceedOperation(fruTrans);
        }
        CsvOutputFileWriter csvOutputFileWriter = new CsvOutputFileWriterImpl();
        csvOutputFileWriter.createCscWithTitle();
        csvOutputFileWriter.saveResultsToCsv(Storage.fruits);


        System.out.println(Storage.fruits);


    }
}


