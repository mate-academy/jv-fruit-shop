package logic;

import processor.Processor;
import processor.ProcessorImpl;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class MainLogicImpl implements MainLogic {
    private static final String DEFAULT_REPORT_FILE
            = "src/main/resources/OutGoingReports/Report.csv";
    private final WriterService writerService = new WriterServiceImpl();
    private final ReportService reportService = new ReportServiceImpl();
    private final ReaderService reader = new ReaderServiceImpl();
    private final String inputFilePath;
    private final String reportFilePath;
    private Processor processor;

    public MainLogicImpl(String inputFilePath, String reportFilePath) {
        this.inputFilePath = inputFilePath;
        this.reportFilePath = reportFilePath;
    }

    public MainLogicImpl(String inputFilePath) {
        this.inputFilePath = inputFilePath;
        this.reportFilePath = DEFAULT_REPORT_FILE;
    }

    @Override
    public void generateReport() {
        processor = new ProcessorImpl(reader.readFile(inputFilePath));
        processor.makeTransactions();
        writerService.writeToFile(reportService.getReport(), reportFilePath);
    }
}
