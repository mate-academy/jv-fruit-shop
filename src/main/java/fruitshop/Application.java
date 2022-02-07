package fruitshop;

import fruitshop.db.ReportStorage;
import fruitshop.db.TransactionStorage;
import fruitshop.service.GenerateReportDataImpl;
import fruitshop.service.data.ProcessDataImpl;
import fruitshop.service.file.FileReadServiceImpl;
import fruitshop.service.file.FileWriteServiceImpl;

public class Application {
    private static final FileReadServiceImpl fileReadService = new FileReadServiceImpl();
    private static final FileWriteServiceImpl fileWriteService = new FileWriteServiceImpl();
    private static final ProcessDataImpl processData = new ProcessDataImpl();
    private static final GenerateReportDataImpl generateReportData = new GenerateReportDataImpl();
    private static final TransactionStorage transactionStorage = new TransactionStorage();
    private static final ReportStorage reportStorage = new ReportStorage();

    public static void main(String[] args) {
        String fileInput = "input.csv";
        String fileOut = "out.csv";
        Application application = new Application();
        application.generateReportToFile(fileInput, fileOut);
    }

    private void generateReportToFile(String fileInput, String fileOut) {
        fileReadService.readDataFromFile(fileInput);
        processData.process(transactionStorage.getAll());
        String report = generateReportData.report(reportStorage.getAll());
        fileWriteService.writeDataToFile(report, fileOut);
    }
}
