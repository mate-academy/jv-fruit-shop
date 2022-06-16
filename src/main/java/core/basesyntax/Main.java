package core.basesyntax;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.strategy.AdditionHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.SubtractionHandler;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputPath = "src/main/resources/input.csv";
    private static final String resultPath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        // getting file with data
        File input = new File(inputPath);

        //prepare service to get data
        FileReaderService fileReaded = new FileReaderImpl();

        //prepare map for strategies
        Map<String, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put("s", new AdditionHandler());
        operationHandlers.put("b", new AdditionHandler());
        operationHandlers.put("r", new AdditionHandler());
        operationHandlers.put("p", new SubtractionHandler());

        //prepare service to aggregate data
        OperationStrategy operationStrategy = new OperationStrategyImpl();

        //all preparations are done so let's getting to rumble
        //getting data + iterator for each line + aggregating data to storage
        List<String[]> csvEntries = fileReaded.read(input);
        Iterator<String[]> iterator = csvEntries.iterator();
        String[] passHead = iterator.next(); // first not needed push to iterator
        while (iterator.hasNext()) {
            String[] line = iterator.next();
            operationStrategy.getStrategy(operationHandlers, line)
                    .execute(line[1], Integer.parseInt(line[2]));
        }

        //data is in Storage and we're transferring it to file
        ReportWriterService reportWriter = new ReportWriterImpl();
        File output = new File(resultPath);
        FileWriterService fileWriter = new FileWriterImpl();
        fileWriter.writeTheResult(output, reportWriter.getReport());
    }
}
