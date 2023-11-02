package core.basesyntax;

import core.basesyntax.serviceinterfaces.CsvMapper;
import core.basesyntax.serviceinterfaces.FileReader;
import core.basesyntax.serviceinterfaces.ReportCreator;
import core.basesyntax.serviceinterfaces.Writer;
import core.basesyntax.services.CsvMapperImpl;
import core.basesyntax.services.CsvReader;
import core.basesyntax.services.CsvReportCreatorImpl;
import core.basesyntax.services.CsvWriter;
import core.basesyntax.services.FruitShopServiceImpl;
import core.basesyntax.services.OperationsHandlersBuilder;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

public class Main {
    private static final String FILE_FROM = "src/main/java/core/basesyntax/Files/input.Csv";
    private static final String FILE_TO = "src/main/java/core/basesyntax/Files/Output.Csv";

    public static void main(String[] args) {
        OperationsHandlersBuilder builder = new OperationsHandlersBuilder();
        OperationStrategy operationStrategy = new OperationStrategyImpl(builder
                .getNewOperationHandlersMap());
        FileReader dataReader = new CsvReader();
        CsvMapper dataProcessing = new CsvMapperImpl(operationStrategy);
        ReportCreator reportCreator = new CsvReportCreatorImpl();
        Writer writer = new CsvWriter();
        FruitShopServiceImpl fruitShopService = new FruitShopServiceImpl(dataReader,
                dataProcessing, reportCreator, writer);
        fruitShopService.createDailyReport(FILE_FROM, FILE_TO);
    }
}
