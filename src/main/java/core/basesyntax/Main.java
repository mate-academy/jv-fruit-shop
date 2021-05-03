package core.basesyntax;

import core.basesyntax.Strategy.BalanceOperation;
import core.basesyntax.Strategy.FruitOperationHandler;
import core.basesyntax.Strategy.PurchaseOperation;
import core.basesyntax.Strategy.ReturnOperation;
import core.basesyntax.Strategy.SupplyOperation;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> linesFromFile = readerService.readFromFile("src/main/resources/text");

        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = parser.parse(linesFromFile);

        Map<Operation, FruitOperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceOperation());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyOperation());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseOperation());
        operationStrategyMap.put(Operation.RETURN, new ReturnOperation());

        FruitService fruitService = new FruitServiceImpl();
        fruitService.save(fruitRecordDtos, operationStrategyMap);
        String report = fruitService.getReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, "src/main/resources/text_result");
    }
}
