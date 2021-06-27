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
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.ServiceReader;
import core.basesyntax.service.ServiceReaderImpl;
import core.basesyntax.service.ServiceWriter;
import core.basesyntax.service.ServiceWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILE_PATH = "src/main/java/resources/shop_fruits.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/resources/fruits_report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReduceStrategy());

        ServiceReader fileReader = new ServiceReaderImpl();
        FruitShopService fruitService = new FruitShopServiceImpl(operationStrategyMap);
        ParseToList parser = new Parser();
        List<FruitRecordDto> fruitRecordDtos = parser.parseToDto(
                fileReader.readFile(INPUT_FILE_PATH));
        fruitService.applyOperationOnFruitsDto(fruitRecordDtos);
        ReportCreator reportCreator = new ReportCreatorImpl();

        ServiceWriter fileWriter = new ServiceWriterImpl();
        fileWriter.writeData(reportCreator.getFruitsReport(fileWriter,
                fruitService.getFruits()), OUTPUT_FILE_PATH);
    }
}
