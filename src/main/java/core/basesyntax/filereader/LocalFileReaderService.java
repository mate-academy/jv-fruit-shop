package core.basesyntax.filereader;

import core.basesyntax.exception.FileReadingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocalFileReaderService implements FileReaderService {
    @Override
    public List<List<String>> readFile(String filePath) {
        List<String> actionList;
        try {
            actionList = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new FileReadingException("Can't read the file",e);
        }
        List<List<String>> todoList = new ArrayList<>();
        for (String str : actionList) {
            todoList.add(List.of(str.split(",")));
        }
        todoList.remove(0);
        return todoList;
    }
}
