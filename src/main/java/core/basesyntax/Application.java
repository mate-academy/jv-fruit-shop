package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.AdditionStrategy;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ParseToList;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReduceStrategy;
import core.basesyntax.service.ServiceReader;
import core.basesyntax.service.ServiceReaderImpl;
import core.basesyntax.service.ServiceWriter;
import core.basesyntax.service.ServiceWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReduceStrategy());

        ServiceReader fileReader = new ServiceReaderImpl();
        FruitShopService fruitService = new FruitShopServiceImpl(operationStrategyMap);
        ParseToList parse = new Parser();
        List<FruitRecordDto> fruitRecordDtos = parse.parseToTransactions(
                fileReader.readFile("src/main/java/resources/shop_fruits.csv"));
        fruitService.applyOperationOnFruitsDt(fruitRecordDtos);

        ServiceWriter fileWriter = new ServiceWriterImpl();
        fileWriter.writeReport("src/main/java/resources/fruits_report.csv",
                fruitService.getFruitsReport());
    }
}
