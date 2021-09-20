package service;

import bd.Storage;
import dao.OperationDaoUseFileImpl;
import model.FruitRecordDto;

public class ReportServiceImpl implements ReportService {
    private OperationStrategy operationStrategy;

    public ReportServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void createReport(String pathFrom, String pathTo) {
        SourceHandler sourceHandler = new SourceHandlerFileCsv();
        sourceHandler.readInputData(pathFrom);
        String dataForWrite = makerReport();
        sourceHandler.writOutputData(dataForWrite, pathTo);
    }

    private String makerReport() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String tempFotName : Storage.setOfName) {
            int result = 0;
            stringBuilder.append(tempFotName).append(",");
            for (FruitRecordDto tempForType :
                    new OperationDaoUseFileImpl().getByNameGoods(tempFotName)) {
                result += operationStrategy.get(tempForType.getType())
                        .getType(tempForType.getAmount());
            }
            stringBuilder.append(result).append(System.lineSeparator());
        }
        return new String(stringBuilder);
    }
}
