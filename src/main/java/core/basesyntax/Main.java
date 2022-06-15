package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImp;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.imp.*;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImp;
import core.basesyntax.strategy.activities.ActivitiesHandler;
import core.basesyntax.strategy.activities.AddActivitiesHandler;
import core.basesyntax.strategy.activities.SubstractActivitiesHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_FILE_NAME = "src/main/resources/DayRecords.csv";
    private static final String DESTINATION_FILE_NAME = "src/main/resources/Report.csv";
    private static final String DAY_RECORDS_HEADER = "type,fruit,quantity";
    private static final String REPORT_HEADER = "fruit,quantity";

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImp();
        ActivitiesHandler addActivitiesHandler = new AddActivitiesHandler(productDao);
        ActivitiesHandler subActivitiesHandler = new SubstractActivitiesHandler(productDao);

        Map<ProductTransaction.Operation, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(ProductTransaction.Operation.BALANCE, addActivitiesHandler);
        activitiesHandlerMap.put(ProductTransaction.Operation.SUPPLY, addActivitiesHandler);
        activitiesHandlerMap.put(ProductTransaction.Operation.PURCHASE, subActivitiesHandler);
        activitiesHandlerMap.put(ProductTransaction.Operation.RETURN, addActivitiesHandler);
        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImp(activitiesHandlerMap);

        List<String> records = new ReaderServiceImp().readRecords(Path.of(SOURCE_FILE_NAME));
        records = new CSVValidatorImp(DAY_RECORDS_HEADER).validate(records);

        TransactionParser transactionParser = new TransactionParserImp();

        records.stream()
                .map(transactionParser::parse)
                .forEach(e -> activitiesStrategy.get(e.getOperation()).process(e));
        records.clear();

        ReportService reportService = new ReportServiceImp();
        records = reportService.createReport(productDao);
        records.add(0, REPORT_HEADER);

        WriterService writerService = new WriterServiceImp();
        writerService.writeToFile(records, Path.of(DESTINATION_FILE_NAME));
    }
}
