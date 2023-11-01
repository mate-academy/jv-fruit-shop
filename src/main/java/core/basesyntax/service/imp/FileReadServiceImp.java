package core.basesyntax.service.imp;

import core.basesyntax.service.FileReadService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadServiceImp implements FileReadService {
    @Override
    public ArrayList<String> readFilesLines(String path) {
        File sourseFile = new File(path);
        ArrayList<String> filesLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourseFile))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                filesLines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + sourseFile, e);
        }
        return filesLines;
    }
}
