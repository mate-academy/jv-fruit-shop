package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.AdditionStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aplication {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());

        ReaderService readerService = new ReaderServiceImpl();
        List<TransactionDto> dtos = readerService.readData("src\\main\\resource\\text.csv");

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategyMap);
        fruitShopService.applyOperationOnFruitsDto(dtos);

        ReportService reportService = new ReportServiceImpl();
        List<String> fruitReport = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(fruitReport, "src\\main\\resource\\destination.csv");
    }
}
