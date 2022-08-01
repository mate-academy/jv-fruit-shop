package core.basesyntax.serviceimpl;

import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportServiceImpl implements ReportService {
    private static final List<String> HEADING = List.of("fruit,quantity");

    @Override
    public List<String> createReport(Map<String, Integer> fruitsRemainder) {

        return Stream.concat(HEADING.stream(), getFruitsRemainder(fruitsRemainder).stream())
                .collect(Collectors.toList());
    }

    private List<String> getFruitsRemainder(Map<String, Integer> fruitsRemainder) {
        return fruitsRemainder.entrySet().stream()
                .map(e -> {
                    return "" + e.getKey() + "," + e.getValue();
                })
                .collect(Collectors.toList());
    }
}
