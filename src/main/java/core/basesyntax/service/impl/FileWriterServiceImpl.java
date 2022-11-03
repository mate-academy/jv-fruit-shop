package core.basesyntax.service.impl;

import static core.basesyntax.service.impl.FileServiceImpl.getToFile;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements WriterService {
    private final BufferedWriter bufferedWriter;

    public FileWriterServiceImpl(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void write(String generatedData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getToFile()))) {
            writer.write(generatedData);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file. " + e);
        }
    }
}
