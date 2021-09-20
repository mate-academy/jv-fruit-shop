package core.basesyntax.service;

import core.basesyntax.repository.FruitStorageRepository;
import core.basesyntax.repository.FruitStorageRepositoryImpl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private final FruitStorageRepository fruitStorageService;

    public ReportCreatorImpl() {
        this.fruitStorageService = new FruitStorageRepositoryImpl();
    }

    @Override
    public void createReport(String toPath, LocalDate date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toPath))) {
            writer.write(formReport(date));
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file " + toPath);
        }
    }

    private String formReport(LocalDate date) {
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
        return builder.toString();
    }
}
