package core.basesyntax.report;

import core.basesyntax.csv.writer.WriterService;
import core.basesyntax.csv.writer.WriterServiceImpl;
import core.basesyntax.model.Fruit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    WriterService writerService;

    public ReportMakerImpl() {
        writerService = new WriterServiceImpl();
    }

    @Override
    public void reportMaker(String path, List<Fruit> storage) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write("fruit,quantity");
        writerService.writeToFile(fileWriter, storage);
        fileWriter.close();
    }
}
