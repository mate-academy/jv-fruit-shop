package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerationService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    private static final String LINE_SEPARATOR = ",";
    private static final String REPORT_HEAD = "fruit,quantity\n";

    @Override
    public List<String> createReport(List<Fruit> fruitInShopList) {
        List<String> reportList = new ArrayList<>();
        reportList.add(REPORT_HEAD);
        for (Fruit fruit : fruitInShopList) {
            StringBuilder stringBuilder = new StringBuilder();
            reportList.add(stringBuilder.append(fruit.getName())
                    .append(LINE_SEPARATOR)
                    .append(fruit.getAmountInShop())
                    .append(System.lineSeparator())
                    .toString());
        }
        return reportList;
    }

    @Override
    public void saveReport(List<String> reportList, String toFilePath) {
        File report = new File(toFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report, true))) {
            for (String line : reportList) {
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file", e);
        }
    }
}
