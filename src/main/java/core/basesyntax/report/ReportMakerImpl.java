package core.basesyntax.report;

import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.model.Fruit;
import java.io.*;
import java.util.List;

public class ReportMakerImpl implements ReportMaker {
    private final FileWriter writerService;

    public ReportMakerImpl(FileWriter writerService) {
        this.writerService = writerService;
    }

    @Override
    public void reportMaker(String path, List<Fruit> storage) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write("fruit,quantity");
            writerService.write(bufferedWriter, storage);
        } catch (IOException e) {
            throw new RuntimeException("Cant find file by path: " + path, e);
        }
    }
}
