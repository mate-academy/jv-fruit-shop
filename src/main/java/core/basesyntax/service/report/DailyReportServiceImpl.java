package core.basesyntax.service.report;

import core.basesyntax.model.FruitType;
import core.basesyntax.service.writer.ReportWriter;
import core.basesyntax.service.writer.ReportWriterImpl;
import java.util.Map;

public class DailyReportServiceImpl implements DailyReportService {
    private static final String OUTPUT_FILE_HEADER = "fruit,quantity";
    private final FruitAmountCounter fruitAmountCounter;
    private final ReportWriter reportWriter;

    public DailyReportServiceImpl(FruitAmountCounter fruitAmountCounter) {
        this.fruitAmountCounter = fruitAmountCounter;
        this.reportWriter = new ReportWriterImpl();
    }

    @Override
    public void createReport(String filePathTo) {
        StringBuilder builderReport = new StringBuilder();
        builderReport.append(OUTPUT_FILE_HEADER);
        for (Map.Entry<FruitType, Integer> entry :
                fruitAmountCounter.countFruitByOperation().entrySet()) {
            builderReport.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        reportWriter.writeReport(filePathTo, builderReport.toString());
    }
}
