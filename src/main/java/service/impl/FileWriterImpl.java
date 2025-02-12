package service.impl;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl extends FileWriter {
    public FileWriterImpl(String fileName) throws IOException {
        super(fileName);
    }
}
