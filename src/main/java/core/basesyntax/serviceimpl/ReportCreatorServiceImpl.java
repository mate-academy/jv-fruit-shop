package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportCreatorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final List<String> HEADING = List.of("fruit,quantity");

    @Override
    public String createReport(Map<String, Integer> fruits) {
        return Stream.concat(HEADING.stream(), getFruitsRemainder(fruits).stream())
                .collect(Collectors.joining("\n"));
    }

    private List<String> getFruitsRemainder(Map<String, Integer> fruitsRemainder) {
        return fruitsRemainder.entrySet().stream()
                .map(e -> {
                    return "" + e.getKey() + "," + e.getValue();
                })
                .collect(Collectors.toList());
    }
}
