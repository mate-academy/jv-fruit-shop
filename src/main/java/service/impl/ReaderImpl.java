package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.Reader;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String filepath) {
        if (filepath == null) {
            throw new RuntimeException("Filepath is null!");
        }
        List<String> readResult = new ArrayList<>();

        try {
            File file = new File(filepath);
            if (!file.exists()) {
                throw new RuntimeException("File does not exist!");
            }
            FileReader fr = new FileReader(file);

            try (BufferedReader br = new BufferedReader(fr)) {
                br.readLine();
                String line = "";
                while ((line = br.readLine()) != null) {
                    readResult.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (readResult.isEmpty()) {
            throw new RuntimeException("File is empty!");
        }

        return readResult;
    }
}
