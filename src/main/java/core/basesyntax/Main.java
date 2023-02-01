package core.basesyntax;

import core.basesyntax.dao.DataReader;
import core.basesyntax.dao.DataReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvTransactionParser;
import core.basesyntax.service.CsvTransactionParserImpl;
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

        CsvTransactionParser csvTransactionParser = new CsvTransactionParserImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        DataReader dataReader = new DataReaderImpl();
        List<String> transactions = dataReader.readFromFile();

        FruitTransaction fruitTransaction = csvTransactionParser.getFruitTransaction(transactions);



    }
}


