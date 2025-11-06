package core.basesyntax.service.impl;

import core.basesyntax.FileDataReader;
import core.basesyntax.FileDataWriter;
import core.basesyntax.service.FileService;
import java.util.List;

public class FileServiceImpl implements FileService {
    private final FileDataReader fileDataReader;
    private final FileDataWriter fileDataWriter;

    public FileServiceImpl(
            FileDataReader fileDataReader,
            FileDataWriter fileDataWriter
    ) {
        this.fileDataReader = fileDataReader;
        this.fileDataWriter = fileDataWriter;
    }

    @Override
    public List<String> read(String filePath) {
        return this.fileDataReader.read(filePath);
    }

    @Override
    public void write(String filePath, String data) {
        this.fileDataWriter.write(filePath, data);
    }
}
