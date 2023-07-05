package core.shop.service.impl;

import core.shop.model.FruitRecord;
import core.shop.service.CalculateQuantityService;
import core.shop.service.FileService;
import core.shop.service.ParseListService;
import core.shop.service.ReportService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_FILE = "src/report.csv";
    private static final String REPORT_TITLE = "fruit,quantity";
    private static final String COMA_SEPARATOR = ",";
    private final CalculateQuantityService calculateQuantity = new CalculateQuantityServiceImpl();
    private final ParseListService parseList = new ParseListServiceImpl();
    private final FileService fileService = new FileServiceImpl();

    @Override
    public void generateReport(List<String> fruitsList) {
        StringBuilder reportBuilder = new StringBuilder(REPORT_TITLE)
                .append(System.lineSeparator());
        List<FruitRecord> fruitRecordList = parseList.getFruitRecords(fruitsList);
        Set<String> fruitsSet = getFruits(fruitRecordList);

        for (String fruit : fruitsSet) {
            int totalQuantity = calculateQuantity.calculateQuantity(fruitRecordList, fruit);
            reportBuilder.append(fruit)
                    .append(COMA_SEPARATOR)
                    .append(totalQuantity)
                    .append(System.lineSeparator());
        }
        fileService.write(REPORT_FILE, reportBuilder.toString());
    }

    private Set<String> getFruits(List<FruitRecord> fruitRecords) {
        return fruitRecords.stream()
                .map(FruitRecord::getFruitName)
                .collect(Collectors.toSet());
    }
}
