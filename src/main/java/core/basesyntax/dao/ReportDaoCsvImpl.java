package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportDaoCsvImpl implements ReportDao {
    private static final String FIRST_LINE_REPORT_TEXT = "fruit,quantity";

    @Override
    public void writeReport(Map<String, Integer> endOfDayFruitQuantities, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(FIRST_LINE_REPORT_TEXT);
            for (String fruitName : endOfDayFruitQuantities.keySet()) {
                writer.write(System.lineSeparator() + fruitName
                        + "," + endOfDayFruitQuantities.get(fruitName));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file "
                    + filePath + ", " + e);
        }
    }
}
