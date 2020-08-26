package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class DataWriter {

    public String getReport(String filePath) {
        String content = "";
        DataExecutor executor = new DataExecutor();
        Map<String, Integer> report = executor.dataExecutor(filePath);

        if (!report.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("fruit").append(";").append("quantity").append("\n");
            for (Map.Entry<String, Integer> base : report.entrySet()) {
                builder.append(base.getKey());
                builder.append(";");
                builder.append(base.getValue());
                builder.append("\n");
            }
            content = builder.toString().trim();
        }
        try (PrintWriter writer = new PrintWriter(new File("src/test/out/test.csv"))) {
            writer.write(content);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return content;
    }
}

