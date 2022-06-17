package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.AdditionHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.SubtractionHandler;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String inputPath = "src/main/resources/input.csv";
    private static final String resultPath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        //prepare map for strategies
        Map<String, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put("s", new AdditionHandler());
        operationHandlers.put("b", new AdditionHandler());
        operationHandlers.put("r", new AdditionHandler());
        operationHandlers.put("p", new SubtractionHandler());

        //prepare service to aggregate data
        StorageService storageService = new StorageServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        //getting data + iterator for each line + aggregating data to storage
        File input = new File(inputPath);
        FileReaderService fileReadToStorage = new FileReaderImpl();
        storageService.saveAll(fileReadToStorage.read(input), operationStrategy);

        //data is in Storage and we're transferring it to file
        ReportCreator reportCreator = new ReportCreatorImpl();
        File output = new File(resultPath);
        FileWriterService fileWriter = new FileWriterImpl();
        fileWriter.write(output, reportCreator.getReport());
    }
}
