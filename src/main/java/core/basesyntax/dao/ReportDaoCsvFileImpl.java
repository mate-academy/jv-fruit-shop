package core.basesyntax.dao;

import core.basesyntax.model.Report;
import core.basesyntax.util.Util;
import java.util.stream.Collectors;

public class ReportDaoCsvFileImpl implements ReportDao {
    private final String outputFile;

    public ReportDaoCsvFileImpl(String outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public Report save(Report report) {
        String stringReport = report.getTitle() + report.getFruits().stream()
                .map(fruit -> fruit.getName() + "," + fruit.getBalance())
                .collect(Collectors.joining(System.lineSeparator()));
        Util.writeFile(outputFile, stringReport);
        return report;
    }
}
