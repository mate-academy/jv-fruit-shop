package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReductionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        CsvFileReader reader = new CsvFileReaderImpl();
        List<TransactionDto> transactionDtos =
                reader.readDate("src/main/resources/test-fruit.csv");
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        fruitService.applyOperationOnFruitDto(transactionDtos);
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        csvFileWriter.createReportFile(fruitService.getDefaultReport(),
                "src/main/resources/report.csv");
    }
}
