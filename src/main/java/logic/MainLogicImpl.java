package logic;

import java.util.List;
import processor.DataProcessorImpl;
import service.general.InputStorageService;
import service.general.WriterService;
import service.impl.InputStorageServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;

public class MainLogicImpl implements MainLogic {
    private final InputStorageService inputStorageService = new InputStorageServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();

    @Override
    public void generateReport(String inputFilePath, String reportFilePath) {
        inputStorageService.saveInput(inputFilePath);
        List<String> inputData = inputStorageService.getStorageData().getInputData();

        new DataProcessorImpl().makeProcessedData(inputData);

        String report = new ReportServiceImpl().getReport();
        writerService.writeToFile(report, reportFilePath);
    }
}
