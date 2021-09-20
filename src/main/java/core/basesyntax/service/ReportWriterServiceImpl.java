package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportWriterServiceImpl implements ReportWriterService {
    private static final String TABLE_HEADING = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";
    private final FruitDao fruitDao;

    public ReportWriterServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    public void createReport(String toFileName) {
        String heading = TABLE_HEADING + System.lineSeparator();
        List<String> reportRecords = getReportRecords();
        try {
            Files.write(Path.of(toFileName), heading.getBytes());
            for (String string : reportRecords) {
                Files.write(Path.of(toFileName), string.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }

    private List<String> getReportRecords() {
        Map<Fruit, Integer> fruitsMap = fruitDao.getBalance();
        return fruitsMap.entrySet().stream()
                .map(e -> new StringBuilder().append(e.getKey().getName()).append(CSV_SEPARATOR)
                        .append(e.getValue()).append(System.lineSeparator()))
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }
}
