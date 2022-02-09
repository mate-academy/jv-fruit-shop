package core.basesyntax.createreport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateReport {
    public String createReport(Map<String,Integer> storage) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(System.lineSeparator());
        List<String> listOfFruitCount = storage.entrySet().stream()
                .map(i -> i.getKey() + "," + i.getValue())
                .collect(Collectors.toList());
        for (String lines : listOfFruitCount) {
            builder.append(lines).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
