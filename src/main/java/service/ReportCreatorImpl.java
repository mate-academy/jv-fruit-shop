package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import java.util.List;
import java.util.stream.Collectors;
import model.Record;
import operation.OperationHandler;
import operation.OperationStrategy;
import report.Report;

public class ReportCreatorImpl implements ReportCreator {
    private final OperationStrategy operationStrategy;

    public ReportCreatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<String> createNewReport() {
        RecordDao recordDao = new RecordDaoImpl();
        List<Record> records = recordDao.getRecords();
        for (Record record: records) {
            OperationHandler operationHandler = operationStrategy
                    .operate(record.getOperationType());
            operationHandler.operate(record);
        }
        return Report.FRUIT_REPORT.entrySet().stream()
                .map(string -> string.getKey() + "," + string.getValue())
                .collect(Collectors.toList());
    }
}
