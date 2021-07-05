package core.basesyntax;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.dto.FruitRecordDtoParser;
import core.basesyntax.dto.FruitRecordDtoParserImpl;
import core.basesyntax.fileservice.ReaderService;
import core.basesyntax.fileservice.ReaderServiceImpl;
import core.basesyntax.fileservice.WriteService;
import core.basesyntax.fileservice.WriteServiceImpl;
import core.basesyntax.model.FruitService;
import core.basesyntax.model.FruitServiceImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> linesFromFile = readerService.readFromFile("src/main/resources/text");
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        Map<Operation, FruitOperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperation());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyOperation());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperation());
        operationStrategyMap.put(Operation.RETURN, new ReturnOperation());
        List<FruitRecordDto> fruitRecordDto = parser.parse(linesFromFile);
        FruitService fruitService = new FruitServiceImpl();
        fruitService.save(fruitRecordDto, operationStrategyMap);
        String report = fruitService.getReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(report, "src/main/resources/text_result.csv");
    }
}
