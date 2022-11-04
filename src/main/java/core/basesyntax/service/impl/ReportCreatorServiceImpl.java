package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreatorService;
import java.util.ArrayList;
import java.util.List;

public class ReportCreatorServiceImpl implements ReportCreatorService {
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
}
