package core.basesyntax;

import core.basesyntax.impl.ActivitiesStrategyImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionProcess;
import core.basesyntax.strategy.ActivitiesHandler;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.BalanceActivitiesHandler;
import core.basesyntax.strategy.PurchaseActivitiesHandler;
import core.basesyntax.strategy.ReturnActivitiesHandler;
import core.basesyntax.strategy.SupplyActivitiesHandler;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final String reportFile = "report.csv";
        final String path = "src/main/resources/file.csv";
        final FileReader readFromFile = new FileReader();
        final HashMap<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();

        activitiesHandlerMap.put("b", new BalanceActivitiesHandler());
        activitiesHandlerMap.put("p", new PurchaseActivitiesHandler());
        activitiesHandlerMap.put("r", new ReturnActivitiesHandler());
        activitiesHandlerMap.put("s", new SupplyActivitiesHandler());

        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        final TransactionProcess dataProcess = new TransactionProcess(activitiesStrategy);
        final ReportGenerator createReport = new ReportGenerator();
        final FileWriter writeToFile = new FileWriter();

        System.out.println(Arrays.toString(readFromFile.read(path)));
        System.out.println("--------------------");
        HashMap<String, Integer> print = dataProcess.process(readFromFile.read(path));
        print.forEach((key, value) -> System.out.println(key + "," + value));
        System.out.println("--------------------");
        System.out.println(createReport.create(dataProcess.process(readFromFile.read(path))));
        writeToFile.write(createReport
                .create(dataProcess.process(readFromFile.read(path))), reportFile);
    }
}
