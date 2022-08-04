package core.basesyntax.reportserviceimpl;

import core.basesyntax.reportservice.ReportCreatorService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEADING = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> fruits) {
        return HEADING + System.lineSeparator() + getFruitsRemainder(fruits);
    }

    private String getFruitsRemainder(Map<String, Integer> fruitsRemainder) {
        return fruitsRemainder.entrySet().stream()
                .map(e -> {
                    return "" + e.getKey() + "," + e.getValue();
                })
                .collect(Collectors.joining("\n"));
    }
}
