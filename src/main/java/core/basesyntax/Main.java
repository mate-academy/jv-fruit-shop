package core.basesyntax;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.StrategyOperation;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.Balance;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.RemoveOperation;
import core.basesyntax.service.impl.StrategyOperationImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, FruitOperationHandler> handlers = new HashMap<>();
        handlers.put("b", new Balance());
        handlers.put("s", new AddOperation());
        handlers.put("p", new RemoveOperation());
        handlers.put("r", new AddOperation());

        StrategyOperation strategyOperation = new StrategyOperationImpl(handlers);
        ReaderServiceImpl fileReader = new ReaderServiceImpl();
        List<String> newLinesOperation = fileReader.readFromFile("src/main/resources/file.csv");
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> allFruitRecordDto = parser.parse(newLinesOperation);
        WriterService writerService = new WriterServiceImpl();
        writerService.writeBalanceOfFruitToFile(strategyOperation.get(allFruitRecordDto));
    }
}
