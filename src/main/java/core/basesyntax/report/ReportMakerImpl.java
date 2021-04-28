package core.basesyntax.report;

import core.basesyntax.csv.writer.WriterService;
import core.basesyntax.csv.writer.WriterServiceImpl;
import core.basesyntax.model.Fruit;

import java.io.*;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    WriterService writerService;

    public ReportMakerImpl() {
        writerService = new WriterServiceImpl();
    }

    @Override
    public void reportMaker(String path, List<Fruit> storage) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write("fruit,quantity");
            writerService.writeToFile(bufferedWriter, storage);
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + path, e);
        }
    }
}
