package core.basesyntax.service;

import core.basesyntax.dao.RemnantsDao;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {

    private final RemnantsDao remnantsDao;
    private final InputOutputService inputOutputService;
    private final FileService fileService;
    private final OperationStrategy operationStrategy;

    public StoreServiceImpl(RemnantsDao remnantsDao,
                            InputOutputService inputOutputService,
                            FileService fileService,
                            OperationStrategy operationStrategy) {
        this.remnantsDao = remnantsDao;
        this.inputOutputService = inputOutputService;
        this.fileService = fileService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processInputFile(String dateOfInpFile) {
        File inputFile = inputOutputService.getInputFile(dateOfInpFile);
        List<String> recordsList = fileService.readDataFromFile(inputFile);
        if (recordsList.get(0).equals("type,fruit,quantity")) {
            recordsList.remove(0);
        }
        List<String[]> recordsSplittedList = recordsList.stream()
                .map(s -> s.split(","))
                .collect(Collectors.toList());
        for (String[] record: recordsSplittedList) { //внести изменения в Storage
            OperationTypes operationType = convertToOperationType(record[0]);
            operationStrategy.getOperationHandler(operationType).apply(record);
        }
    }

    @Override
    public void generateReport(String date) {
        String reportFullPath = inputOutputService.getReportFullPath(date);
        List<String> reportList = remnantsDao.getRemnantsReportList();
        reportList.add(0, "fruit,quantity");
        fileService.writeDataToFile(reportList, reportFullPath);
    }

    private OperationTypes convertToOperationType(String operation) {
        OperationTypes operationType;
        switch (operation) {
            case "b": //the remnants of fruits at the beginning of the working day
                operationType = OperationTypes.BALANCE;
                break;
            case "s": //means you are receiving new fruits from suppliers
                operationType = OperationTypes.SUPPLY;
                break;
            case "p": //means someone has bought some fruit
                operationType = OperationTypes.PURCHASE;
                break;
            case "r": //means someone who have bought the fruits now returns them back
                operationType = OperationTypes.RETURN;
                break;
            default:
                operationType = OperationTypes.UNKNOWN;
                break;
        }
        return operationType;
    }

}
