package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    @Override
    public String createReport(List<String[]> convertedList) {
        return convertedList.stream()
                .map(this::convertToCsv)
                .collect(Collectors.joining());
    }

    private String convertToCsv(String[] data) {
        return String.join(",", data);
    }
}
