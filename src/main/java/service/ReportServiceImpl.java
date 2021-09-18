package service;

import dao.FileAccessDaoCsv;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String REPORT_DATA_DELIMITER = ",";

    private final FileAccessDaoCsv readerDao;
    private final InputValidator inputValidator;
    private final ActivityStrategy strategy;

    public ReportServiceImpl(FileAccessDaoCsv readerDao, InputValidator inputValidator,
                             ActivityStrategy strategy) {
        this.readerDao = readerDao;
        this.inputValidator = inputValidator;
        this.strategy = strategy;
    }

    @Override
    public void generateReport(String inputFilePath, String outputFilePath) {
        Map<String, Integer> reportMap = new HashMap<>();

        List<String> inputList = readerDao.readFromFile(inputFilePath);
        fillReportMap(inputList, reportMap);

        readerDao.writeToFile(getReadyForReportString(reportMap), outputFilePath);
    }

    private void fillReportMap(List<String> inputList, Map<String, Integer> reportMap) {
        inputValidator.validateInput(inputList);
        for (int i = 1; i < inputList.size(); i++) {
            String[] reportColumn = inputList.get(i).split(REPORT_DATA_DELIMITER);

            String operationType = reportColumn[0];
            String fruitType = reportColumn[1];
            int fruitAmount = Integer.parseInt(reportColumn[2]);

            int fruitsToAdd = strategy.get(operationType).get(fruitAmount);
            getFruitAvailability(reportMap, fruitType, fruitsToAdd, i);

            reportMap.merge(fruitType, fruitsToAdd, Integer::sum);
        }
    }

    private String getReadyForReportString(Map<String, Integer> reportMap) {
        StringBuilder stringForReport = new StringBuilder()
                                        .append(REPORT_HEADER)
                                        .append(System.lineSeparator());

        for (Map.Entry<String, Integer> fruitsMap : reportMap.entrySet()) {
            stringForReport.append(fruitsMap.getKey())
                            .append(REPORT_DATA_DELIMITER)
                            .append(fruitsMap.getValue())
                            .append(System.lineSeparator());
        }
        return stringForReport.toString();
    }

    private void getFruitAvailability(Map<String, Integer> reportMap,
                                      String fruitType, int fruitsToAdd, int row) {
        if (reportMap.get(fruitType) != null && reportMap.get(fruitType) + fruitsToAdd < 0) {
            throw new RuntimeException("Total fruit amount can not be negative. Row # "
                    + (row + 1) + ". Amount of " + fruitType + " to process: " + fruitsToAdd
                    + ", but before was : " + reportMap.get(fruitType));
        }
    }
}
