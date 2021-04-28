package core.basesyntax.report;

import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.file.writer.FileWriterImpl;
import core.basesyntax.model.Fruit;

import java.io.*;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    FileWriter writerService;

    public ReportMakerImpl() {
        writerService = new FileWriterImpl();
    }

    @Override
    public void reportMaker(String path, List<Fruit> storage) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write("fruit,quantity");
            writerService.write(bufferedWriter, storage);
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + path, e);
        }
    }
}
