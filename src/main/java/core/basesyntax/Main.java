package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ParserServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE = "src/main/resources/output.csv";
    public static final ReaderService READER_FILE = new ReaderServiceImpl();
    public static final ParserService PARSER_FILE = new ParserServiceImpl();
    public static final WriterService WRITER_FILE = new WriterServiceImpl();

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationStrategyMap.put(Operation.SUPPLY, new AddOperationHandler());
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyMap.put(Operation.RETURN, new AddOperationHandler());
        List<String> contentFromFile = READER_FILE.readFromFile(INPUT_FILE);
        contentFromFile.remove(0);
        contentFromFile.stream()
                .map(PARSER_FILE::parseLine)
                .forEach(transaction -> operationStrategyMap
                        .get(Operation.checkTypeOperation(transaction.getOperation()))
                        .handle(transaction));
        FruitService reportService = new FruitServiceImpl();
        String report = reportService.getReport();
        WRITER_FILE.writeToFile(OUTPUT_FILE, report);
    }
}
