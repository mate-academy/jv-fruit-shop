package service;

import bd.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private OperationStrategy operationStrategy;

    public ReportServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void getReport(String pathFrom, String pathTo) {
        new FileReaderImpl().read(pathFrom);
        new FruitShopServiceImpl().transfer(operationStrategy);
        String dataForWrite = createReport();
        new FileWriterImpl().write(dataForWrite, pathTo);
    }

    private String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> tempEntry : Storage.mapReport.entrySet()) {
            stringBuilder.append(tempEntry.getKey())
                    .append(",").append(tempEntry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
