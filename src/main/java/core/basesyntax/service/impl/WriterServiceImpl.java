package core.basesyntax.service.impl;

import core.basesyntax.repository.FruitDB;
import core.basesyntax.service.WriterService;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterServiceImpl implements WriterService {

    @Override
    public void write(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            writer.append(new ReportBuilderImpl().buildReport(FruitDB.fruitsOnStock));
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName);
        }
    }
}
