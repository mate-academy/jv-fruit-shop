package service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import model.FruitTransaction;
import service.ReportService;
import strategy.impl.ResidueImpl;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String SPLIT_COMMA = ",";

    @Override
    public String getReport(List<FruitTransaction> fruitsTransactionData) {
        Map<String, Integer> residue = new ResidueImpl().getResidue(fruitsTransactionData);
        StringBuilder report = new StringBuilder(TITLE_REPORT).append(System.lineSeparator());
        Stream.of(residue)
                .flatMap(c -> c.entrySet().stream())
                .forEach(r -> report.append(r.getKey())
                        .append(SPLIT_COMMA)
                        .append(r.getValue())
                        .append(System.lineSeparator()));
        return report.toString();
    }
}
