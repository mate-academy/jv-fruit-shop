package core.basesyntax;

import core.basesyntax.dao.FruitTransaction;
import core.basesyntax.dao.impl.FruitTransactionImpl;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitShopImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportMakerImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String INPUT_FILE = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE = "src/main/resources/output.txt";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        Reader reader = new ReaderImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        FruitShop fruitShop = new FruitShopImpl(
                new OperationStrategyImpl(operationHandlerMap), new FruitTransactionImpl()
        );
        ReportMaker reportMaker = new ReportMakerImpl();
        Writer writer = new WriterImpl();
        List<List<String>> parsed = transactionParser.parse(reader.readFrom(INPUT_FILE));
        Map<String, Integer> preparedMap = fruitShop.report(parsed);
        String preparedReport = reportMaker.make(preparedMap);
        writer.write(preparedReport, OUTPUT_FILE);
    }
}
