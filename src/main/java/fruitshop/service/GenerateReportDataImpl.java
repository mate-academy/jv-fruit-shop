package fruitshop.service;

import java.util.List;

public class GenerateReportDataImpl implements GenerateReportDataService {

    @Override
    public String report(List<String> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : data) {
            stringBuilder.append(line)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
