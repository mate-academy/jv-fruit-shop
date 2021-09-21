package core.basesyntax.service.implementation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.ReportWriterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReportWriterServiceImpl implements ReportWriterService {
    private static final String TABLE_HEADING = "fruit,quantity";
    private final FruitDao fruitDao;
    private final ReportMakerService reportMakerService;

    public ReportWriterServiceImpl(FruitDao fruitDao, ReportMakerService reportMakerService) {
        this.fruitDao = fruitDao;
        this.reportMakerService = reportMakerService;
    }

    public void createReport(String toFileName) {
        String heading = TABLE_HEADING + System.lineSeparator();
        List<String> reportRecords = reportMakerService.makeReport(fruitDao);
        try {
            Files.write(Path.of(toFileName), heading.getBytes());
            for (String string : reportRecords) {
                Files.write(Path.of(toFileName), string.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }
}
