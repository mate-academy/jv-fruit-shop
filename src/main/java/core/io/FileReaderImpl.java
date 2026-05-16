package core.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

public class FileReaderImpl {

    public List<String> read(String fileName) {
        try (InputStream is = getClass().getResourceAsStream(fileName);
                InputStreamReader reader = new InputStreamReader(is, Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines().skip(1).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

