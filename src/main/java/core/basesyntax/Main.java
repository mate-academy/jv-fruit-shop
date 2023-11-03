package core.basesyntax;

import core.basesyntax.serviceinterfaces.Mapper;
import core.basesyntax.serviceinterfaces.FileReader;
import core.basesyntax.serviceinterfaces.ReportCreator;
import core.basesyntax.serviceinterfaces.Writer;
import core.basesyntax.services.MapperImpl;
import core.basesyntax.services.CsvReader;
import core.basesyntax.services.CsvReportCreatorImpl;
import core.basesyntax.services.CsvWriter;
import core.basesyntax.services.FruitShopServiceImpl;
import core.basesyntax.services.OperationsHandlersBuilder;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

public class Main {
    private static final String FILE_FROM = "src/main/CsvFiles/Input.Csv";
    private static final String FILE_TO = "src/main/CsvFiles/Output.csv";

    public static void main(String[] args) {
        OperationsHandlersBuilder builder = new OperationsHandlersBuilder();
        OperationStrategy operationStrategy = new OperationStrategyImpl(builder
                .getNewOperationHandlersMap());
        FileReader dataReader = new CsvReader();
        Mapper dataProcessing = new MapperImpl(operationStrategy);
        ReportCreator reportCreator = new CsvReportCreatorImpl();
        Writer writer = new CsvWriter();
        FruitShopServiceImpl fruitShopService = new FruitShopServiceImpl(dataReader,
                dataProcessing, reportCreator, writer);
        fruitShopService.createDailyReport(FILE_FROM, FILE_TO);
    }
}
