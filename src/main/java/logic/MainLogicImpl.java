package logic;

import dao.InputDao;
import dao.impl.InputDaoImpl;
import processor.DataProcessor;
import processor.DataProcessorImpl;
import service.DataCheckService;
import service.LegendFilter;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.DataCheckServiceImpl;
import service.impl.LegendFilterImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class MainLogicImpl implements MainLogic {
    private static final String DEFAULT_REPORT_FILE
            = "src/main/resources/OutGoingReports/Report.csv";
    private final InputDao inputDao = new InputDaoImpl();
    private final WriterService writerService = new WriterServiceImpl();
    private final DataProcessor dataProcessor = new DataProcessorImpl();
    private final ReportService reportService = new ReportServiceImpl();
    private final ReaderService reader = new ReaderServiceImpl();
    private final DataCheckService checkService = new DataCheckServiceImpl();
    private final LegendFilter legendFilter = new LegendFilterImpl();

    @Override
    public void generateReport(String inputFilePath) {
        generateReport(inputFilePath, DEFAULT_REPORT_FILE);
    }

    @Override
    public void generateReport(String inputFilePath, String reportFilePath) {
        System.out.println("Retrieving input from file " + inputFilePath + " ...\n");
        inputDao.saveInput(reader.readFile(inputFilePath));
        checkService.getDataChecked();
        legendFilter.getLegendFiltered();
        dataProcessor.makeProcessedData(inputDao.getStorageData());
        reportFilePath = writerService.writeToFile(
                reportService.getReport(),
                reportFilePath,
                DEFAULT_REPORT_FILE);
        System.out.println("\nReport creation finished, check " + reportFilePath);
    }
}
