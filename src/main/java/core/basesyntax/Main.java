package core.basesyntax;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.StrategyOperation;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.AddOperationHandler;
import core.basesyntax.service.impl.BalanceHandler;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.RemoveOperationHandler;
import core.basesyntax.service.impl.StrategyOperationImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/file.csv";

    public static void main(String[] args) {
        Map<String, FruitOperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceHandler());
        handlers.put("s", new AddOperationHandler());
        handlers.put("p", new RemoveOperationHandler());
        handlers.put("r", new AddOperationHandler());

        StrategyOperation strategyOperation = new StrategyOperationImpl(handlers);
        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        List<String> newLinesOperation = fileReader.readFromFile(INPUT_FILE_PATH);
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> allFruitRecordDto = parser.parse(newLinesOperation);

        WriterService writerService = new WriterServiceImpl();
        writerService.writeBalanceOfFruitToFile(strategyOperation
                .writeBalance(strategyOperation.get(allFruitRecordDto)));
    }
}
