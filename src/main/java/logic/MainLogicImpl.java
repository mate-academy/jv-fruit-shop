package logic;

import processor.DataProcessor;
import processor.DataProcessorImpl;
import processor.FalseCheckUnit;
import processor.FalseCheckUnitImpl;
import service.general.InputStorageService;
import service.general.ReportService;
import service.general.WriterService;
import service.impl.InputStorageServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class MainLogicImpl implements MainLogic {
    private static final String DEFAULT_REPORT_FILE = "./res/OutGoingReports/Report.csv";
    private final InputStorageService inputStorageService = new InputStorageServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();
    private final DataProcessor dataProcessor = new DataProcessorImpl();
    private final FalseCheckUnit falseCheckUnit = new FalseCheckUnitImpl();
    private final ReportService reportService = new ReportServiceImpl();

    @Override
    public void generateReport(String inputFilePath) {
        generateReport(inputFilePath, DEFAULT_REPORT_FILE);
    }

    @Override
    public void generateReport(String inputFilePath, String reportFilePath) {
        System.out.println("Making report from file " + inputFilePath + "\n");

        inputStorageService.saveInput(inputFilePath);

        dataProcessor.makeProcessedData(inputStorageService.getStorageData());
        falseCheckUnit.checkData();

        reportFilePath = writerService
                .writeToFile(reportService.getReport(), reportFilePath, DEFAULT_REPORT_FILE);

        System.out.println("\nReport creation finished, check " + reportFilePath);
    }
}
