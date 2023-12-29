package core.basesyntax;

import core.basesyntax.constants.Activity;
import core.basesyntax.db.DatabaseDaoService;
import core.basesyntax.db.impl.DatabaseDaoServiceImpl;
import core.basesyntax.service.ConvertDataService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreationService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConvertDataServiceCsvImpl;
import core.basesyntax.service.impl.ProcessServiceCsvImpl;
import core.basesyntax.service.impl.ReaderServiceCsvImpl;
import core.basesyntax.service.impl.ReportCreationServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.ActivitiesStrategy;
import core.basesyntax.strategy.ActivitiesStrategyImpl;
import core.basesyntax.strategy.handlers.ActivityHandler;
import core.basesyntax.strategy.handlers.impl.BalanceActivityHandler;
import core.basesyntax.strategy.handlers.impl.PurchaseActivityHandler;
import core.basesyntax.strategy.handlers.impl.ReturnActivityHandler;
import core.basesyntax.strategy.handlers.impl.SupplyActivityHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String CSV_FILE_TO_READ = "src/grocery.csv";
    public static final String CSV_FILE_TO_WRITE = "src/report.csv";
    private static final String CSV_FIRST_LINE = "product,quantity" + System.lineSeparator();
    private static final DatabaseDaoService databaseDaoService = new DatabaseDaoServiceImpl();
    private static final Map<String, ActivityHandler> ACTIVITIES_STRATEGY_MAP = Map.of(
            Activity.BALANCE.getActivity(), new BalanceActivityHandler(databaseDaoService),
            Activity.PURCHASE.getActivity(), new PurchaseActivityHandler(databaseDaoService),
            Activity.RETURN.getActivity(), new ReturnActivityHandler(databaseDaoService),
            Activity.SUPPLY.getActivity(), new SupplyActivityHandler(databaseDaoService)
    );
    private static final ActivitiesStrategy activitiesStrategy =
            new ActivitiesStrategyImpl(ACTIVITIES_STRATEGY_MAP);
    private static final ProcessServiceCsvImpl.DataLineProcessService dataLineProcessService =
            new ProcessServiceCsvImpl.DataLineProcessService();
    private static final StringBuilder reportStringBuilder = new StringBuilder(CSV_FIRST_LINE);

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceCsvImpl();
        ConvertDataService converter = new ConvertDataServiceCsvImpl();
        ProcessService processService =
                new ProcessServiceCsvImpl(activitiesStrategy, dataLineProcessService);
        ReportCreationService reportCreationService =
                new ReportCreationServiceImpl(databaseDaoService, reportStringBuilder);
        WriterService writerService = new WriterServiceImpl();

        String readData = reader.readData(CSV_FILE_TO_READ);
        List<String> convertedData = converter.convert(readData);
        processService.processInfo(convertedData);
        String report = reportCreationService.createReport();
        writerService.writeReport(report, CSV_FILE_TO_WRITE);
    }
}
