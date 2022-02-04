package fruitshop;

import fruitshop.db.ReportStorage;
import fruitshop.db.TransactionStorage;
import fruitshop.service.GenerateReportDataImpl;
import fruitshop.service.data.ProcessDataImpl;
import fruitshop.service.file.FileReadServiceImpl;
import fruitshop.service.file.FileWriteServiceImpl;

public class MainTest {
    private FileReadServiceImpl fileReadService = new FileReadServiceImpl();
    private FileWriteServiceImpl fileWriteService = new FileWriteServiceImpl();
    private ProcessDataImpl processData = new ProcessDataImpl();
    private GenerateReportDataImpl generateReportData = new GenerateReportDataImpl();
    private TransactionStorage transactionStorage = new TransactionStorage(); // storage tr
    private ReportStorage reportStorage = new ReportStorage(); // storage per

    public static void main(String[] args) {
        String filePath = "input.csv";
        MainTest mainTest = new MainTest();
        mainTest.mainMethod(filePath);
    }

    private void mainMethod(String filePath) {
        fileReadService.readDataFromFile(filePath);
        processData.process(transactionStorage.getAll());
        String report = generateReportData.report(reportStorage.getAll());
        fileWriteService.writeDataToFile(report, "out.csv");
    }
}
