package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.operation.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void generateReport(String inputFile,
                               Map<FruitTransaction.Operation, OperationHandler> handler) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(inputFile);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactionList = parserService.parse(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(handler);

        ProcessService processService = new ProcessServiceImpl();
        processService.processData(fruitTransactionList, operationStrategy);

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile();
    }
}
