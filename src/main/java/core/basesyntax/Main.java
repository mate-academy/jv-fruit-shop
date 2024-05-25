package core.basesyntax;

import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        final FileReader readFromFile = new FileReader();
        final HashMap<String, OperationHandler> operationHandlerHashMap = new HashMap<>();
        mapInitializer(operationHandlerHashMap);

        OperationStrategy activitiesStrategy = new OperationStrategyImpl(operationHandlerHashMap);
        final TransactionProcess dataProcess = new TransactionProcess(activitiesStrategy);
        final ReportGenerator createReport = new ReportGenerator();
        final FileWriterService writeToFile = new FileWriterService();

        System.out.println(Arrays.toString(readFromFile.read(INPUT_FILE)));
        System.out.println("--------------------");
        HashMap<String, Integer> print = dataProcess.process(readFromFile.read(INPUT_FILE));
        print.forEach((key, value) -> System.out.println(key + "," + value));
        System.out.println("--------------------");
        System.out.println(createReport.create(dataProcess.process(readFromFile.read(INPUT_FILE))));
        writeToFile.write(createReport
                .create(dataProcess.process(readFromFile.read(INPUT_FILE))), OUTPUT_FILE);
    }

    private static void mapInitializer(HashMap<String, OperationHandler> map) {
        map.put("b", new BalanceOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("s", new SupplyOperationHandler());
    }
}
