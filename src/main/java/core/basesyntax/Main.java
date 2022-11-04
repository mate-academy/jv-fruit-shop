package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GeneratorDataForWriting;
import core.basesyntax.service.MakerTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParserData;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.GeneratorDataFroWritingImpl;
import core.basesyntax.service.impl.MakerTransactionsImpl;
import core.basesyntax.service.impl.ParserDataImpl;
import core.basesyntax.service.impl.ReaderFromCsvService;
import core.basesyntax.service.impl.WriterToCsvService;
import core.basesyntax.service.impl.operation.service.BalanceOperationHandler;
import core.basesyntax.service.impl.operation.service.PurchaserOperationHandler;
import core.basesyntax.service.impl.operation.service.ReturnerOperationHandler;
import core.basesyntax.service.impl.operation.service.SupplierOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUT_PUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaserOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnerOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplierOperationHandler());
        ReaderService readerService = new ReaderFromCsvService();
        List<String> data = readerService.readData(INPUT_FILE_NAME);
        ParserData parserData = new ParserDataImpl();
        List<FruitTransaction> transactions = parserData.parseData(data);
        FruitsDao fruitsDao = new FruitDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);
        MakerTransaction makerTransaction
                = new MakerTransactionsImpl(operationStrategy, fruitsDao);
        makerTransaction.doTransactions(transactions);
        GeneratorDataForWriting generatorDataForWriting =
                new GeneratorDataFroWritingImpl(fruitsDao);
        String dataForWriting = generatorDataForWriting.generateData();
        WriterService writerService = new WriterToCsvService();
        writerService.createReportAfterDay(OUT_PUT_FILE_NAME, dataForWriting);
    }
}
