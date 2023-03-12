package logic;

import processor.DataProcessor;
import processor.DataProcessorWithStrategy;
import service.DataPreparationService;
import service.InputStorageService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.DataPreparationServiceImpl;
import service.impl.InputStorageServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class MainLogicImpl implements MainLogic {
    private static final String DEFAULT_REPORT_FILE
            = "src/main/resources/OutGoingReports/Report.csv";
    private final InputStorageService inputStorageService = new InputStorageServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();
    private final DataProcessor dataProcessor = new DataProcessorWithStrategy();
    private final ReportService reportService = new ReportServiceImpl();
    private final ReaderService reader = new ReaderServiceImpl();
    private final DataPreparationService preparationService = new DataPreparationServiceImpl();

    @Override
    public void generateReport(String inputFilePath) {
        generateReport(inputFilePath, DEFAULT_REPORT_FILE);
    }

    @Override
    public void generateReport(String inputFilePath, String reportFilePath) {
        System.out.println("Retrieving input from file " + inputFilePath + " ...\n");

        inputStorageService.saveInput(reader.readFile(inputFilePath));

        boolean isDataPrepared = preparationService.getDataPrepared();
        if (isDataPrepared) {
            System.out.println("Input data prepared successfully! Creating report...");
        }

        dataProcessor.makeProcessedData(inputStorageService.getStorageData());

        reportFilePath = writerService.writeToFile(
                reportService.getReport(),
                reportFilePath,
                DEFAULT_REPORT_FILE);

        System.out.println("\nReport creation finished, check " + reportFilePath);
    }
}
