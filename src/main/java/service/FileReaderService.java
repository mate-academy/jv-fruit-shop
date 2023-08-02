package service;

import java.awt.*;
import java.io.*;
import java.util.List;

public interface FileReaderService {
        /**
         * Read data from  CSV-file and return list of lines.
         * @return List of lines.
         * @throws IOException if there is an error with file reading.
         */
        List<String> readFromFile() throws IOException;
}
