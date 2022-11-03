package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.fileservice.FileReaderService;
import core.basesyntax.service.fileservice.FileReaderServiceImpl;
import core.basesyntax.service.fileservice.FileWriterService;
import core.basesyntax.service.fileservice.FileWriterServiceImpl;
import core.basesyntax.service.fileservice.ReportService;
import core.basesyntax.service.fileservice.ReportServiceImpl;
import core.basesyntax.service.impl.AddOperationHandlerImpl;
import core.basesyntax.service.impl.BalanceOperationHandlerImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.ReturnOperationHandlerImpl;
import core.basesyntax.service.impl.SubtractOperationHandlerImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String READ_FROM = "src/main/resources/input.csv";
    private static final String WRITE_TO = "src/main/resources/report.csv";
    private static final Map<FruitTransaction.Operation,
            OperationHandler> handlerMap = new HashMap<>();

    public static void main(String[] args) {
        final FruitDao fruitDao = new FruitDaoImpl();
        final FileReaderService fileReader = new FileReaderServiceImpl();
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl(fruitDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new AddOperationHandlerImpl(fruitDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new SubtractOperationHandlerImpl(fruitDao));
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl(fruitDao));

        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        TransactionService transactionService =
                new TransactionServiceImpl(new OperationStrategyImpl(handlerMap));
        transactionService.doOperationService(fruitTransactionParser
                .parseData(fileReader.readFile(READ_FROM)));
        ReportService reportService = new ReportServiceImpl(fruitDao);
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeDataToFile(WRITE_TO, reportService.getReport());
    }
}
