package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements WriterService {
    private final BufferedWriter bufferedWriter;

    public FileWriterServiceImpl(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void write(String generatedData) {
        try (bufferedWriter) {
            bufferedWriter.write(generatedData);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file. " + e);
        }
    }
}
