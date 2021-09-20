package core.basesyntax.service;

import core.basesyntax.dataservice.FruitAmountCounter;
import core.basesyntax.model.FruitType;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DailyReportServiceImpl implements DailyReportService {
    private static final String OUTPUT_FILE_HEADER = "fruit,quantity";
    private final FruitAmountCounter fruitAmountCounter;

    public DailyReportServiceImpl(FruitAmountCounter fruitAmountCounter) {
        this.fruitAmountCounter = fruitAmountCounter;
    }

    @Override
    public void createReport(String filePathFrom, String filePathTo) {
        StringBuilder builderReport = new StringBuilder();
        builderReport.append(OUTPUT_FILE_HEADER);
        for (Map.Entry<FruitType, Integer> entry :
                fruitAmountCounter.countFruitByOperation(filePathFrom).entrySet()) {
            builderReport.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }
        File file = new File(filePathTo);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(builderReport.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write in file" + filePathTo);
        }
    }
}
