package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.service.operation.Add;
import core.basesyntax.service.operation.Handler;
import core.basesyntax.service.operation.Purchase;
import core.basesyntax.service.strategy.ActionStrategy;
import core.basesyntax.service.strategy.ActionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_DESTINATION = "src/main/resources/fruitInput.csv";
    private static final String OUTPUT_FILE_DESTINATION = "src/main/resources/fruitOutput.csv";
    private static final String BALANCE_OPERATION = "b";
    private static final String PURCHASE_OPERATION = "p";
    private static final String RETURN_OPERATION = "r";
    private static final String SUPPLY_OPERATION = "s";

    public static void main(String[] args) {
        Map<String, Handler> handlers = new HashMap<>();
        handlers.put(BALANCE_OPERATION, new Add());
        handlers.put(PURCHASE_OPERATION, new Purchase());
        handlers.put(RETURN_OPERATION, new Add());
        handlers.put(SUPPLY_OPERATION, new Add());
        Parser parser = new ParserImpl();
        Writer myWriter = new WriterImpl();
        List<String> list = new ReaderImpl().readFromFile(INPUT_FILE_DESTINATION);
        List<TransactionDto> transactionDtos = parser.parseLine(list);
        ActionStrategy actionStrategy = new ActionStrategyImpl(handlers);
        for (TransactionDto result : transactionDtos) {
            Handler handler = actionStrategy.get(result.getOperation());
            handler.apply(result);
        }
        FruitService fruitService = new FruitServiceImpl();
        String report = fruitService.createReport();
        myWriter.writeToFile(report, OUTPUT_FILE_DESTINATION);
    }
}
