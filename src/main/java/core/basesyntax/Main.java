package core.basesyntax;

import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitValidator;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OPERATION_BALANCE = "b";
    private static final String OPERATION_SUPPLY = "s";
    private static final String OPERATION_PURCHASE = "p";
    private static final String OPERATION_RETURN = "r";
    private static final String FILE_NAME_FRUIT_STATISTIC = "src/main/resources/fruit_file.csv";
    private static final String FILE_NAME_FRUIT_REPORT = "src/main/resources/fruit_report_from_";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put(OPERATION_BALANCE, new BalanceOperationHandler());
        handlers.put(OPERATION_SUPPLY, new AddOperationHandler());
        handlers.put(OPERATION_PURCHASE, new PurchaseOperationHandler());
        handlers.put(OPERATION_RETURN, new AddOperationHandler());

        List<String> linesFromFile = new FileReaderImpl()
                .read(FILE_NAME_FRUIT_STATISTIC);
        Parser parser = new ParserImpl(new FruitValidator());
        linesFromFile.stream()
                .skip(1)
                .map(parser::parseLine)
                .forEach(operation -> new OperationStrategy(handlers)
                        .get(operation.getOperation())
                        .apply(operation));

        String report = new FruitServiceImpl().createReport();
        new FileWriterImpl()
                .write(FILE_NAME_FRUIT_REPORT + LocalDate.now(), report);
    }
}
