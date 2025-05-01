package service;

import java.io.IOException;

public interface FileWriter {
    void write(String path, String content) throws IOException;
}
