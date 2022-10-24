package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE_LINE = "fruit,quantity" + System.lineSeparator();
    private final FruitStorageServiceImpl fruitStorageService;

    public ReportCreatorImpl() {
        this.fruitStorageService = new FruitStorageServiceImpl();
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
        Map<Fruit, Integer> fruitMap = fruitStorageService.getFromStorage(date);
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE_LINE);
        for (Map.Entry<Fruit, Integer> entry : fruitMap.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
