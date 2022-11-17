package core.basesyntax.dao;

import core.basesyntax.dbreport.ReportStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class FruitReportDaoImpl implements FruitReportDao {

    @Override
    public void put(String fileName) {
        String eol = System.getProperty("line.separator");

        try (Writer writer = new FileWriter(fileName)) {
            writer.append("fruit")
                    .append(',')
                    .append("quantity")
                    .append(eol);
            for (Map.Entry<String, Integer> entry : ReportStorage.report.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue().toString())
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
