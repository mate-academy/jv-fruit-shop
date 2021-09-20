package report.service;

import dao.service.FruitStorageDaoService;
import dao.service.FruitStorageDaoServiceImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private FruitStorageDaoService fruitStorageService = new FruitStorageDaoServiceImpl();

    @Override
    public void createReport(String toPath, LocalDate date) {
        Map<String, Integer> fruitMap = fruitStorageService.get(date);
        StringBuilder builder = new StringBuilder();
        builder.append("fruit")
                .append(",")
                .append("quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(toPath)))) {
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file " + toPath);
        }
    }
}
