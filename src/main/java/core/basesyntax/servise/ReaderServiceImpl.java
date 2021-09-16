package core.basesyntax.servise;

import core.basesyntax.files.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private Reader readerFile;

    public ReaderServiceImpl(Reader readerFile) {
        this.readerFile = readerFile;
    }

    @Override
    public List<List<String>> readData() {
        List<List<String>> resultList = new ArrayList<>();
        List<String> lines = readerFile.read();
        for (int i = 0; i < lines.size(); i++) {
            if (i == 0) {
                continue;
            }
            List<String> parsedLine = Arrays.asList(lines.get(i).strip().split(","));
            resultList.add(parsedLine);
        }
        return resultList;
    }
}
