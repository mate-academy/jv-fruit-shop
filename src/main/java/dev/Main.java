package dev;

import dev.input.FileReaderImpl;
import dev.input.Reader;
import java.util.List;

public class Main {
    private static final String FILE_READ_SRC = "reportToRead.csv";

    public static void main(String[] args) {
        Reader reader = new FileReaderImpl();
        List<String> iputReport = reader.read(FILE_READ_SRC);
    }
}
