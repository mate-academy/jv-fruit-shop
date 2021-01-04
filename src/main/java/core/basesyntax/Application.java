package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.AdditionalStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionalStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionalStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionalStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        FileReader fileReader = new CsvFileReaderImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        FileWriter fileWriter = new CsvFileWriterImpl();

        List<TransactionDto> transactionDtos = fileReader.readData("src/main/fruit_shop.csv");
        fruitService.applyAllOperators(transactionDtos);
        Map<String, Long> report = fruitService.getReport();
        fileWriter.writeDataInFile(report, "src/main/fruit_report.csv");
    }
}
