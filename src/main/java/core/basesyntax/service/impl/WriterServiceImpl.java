package core.basesyntax.service.impl;

import core.basesyntax.repository.FruitDB;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterServiceImpl implements WriterService {
    private final ReportBuilder reportBuilder = new ReportBuilderImpl();

    @Override
    public void write(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            writer.append(reportBuilder.buildReport(FruitDB.fruitsOnStock));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
