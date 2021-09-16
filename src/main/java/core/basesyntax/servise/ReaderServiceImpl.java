package core.basesyntax.servise;

import core.basesyntax.files.Reader;
import core.basesyntax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private final Reader readerFile;
    private final Validator titleValidator;
    private final Validator lineValidator;

    public ReaderServiceImpl(Reader readerFile, Validator titleValidator, Validator lineValidator) {
        this.readerFile = readerFile;
        this.titleValidator = titleValidator;
        this.lineValidator = lineValidator;
    }

    @Override
    public List<List<String>> readData() {
        List<List<String>> resultList = new ArrayList<>();
        List<String> lines = readerFile.read();
        for (int i = 0; i < lines.size(); i++) {
            List<String> parsedLine = Arrays.asList(lines.get(i).strip().split(","));
            if (i == 0) {
                titleValidator.validate(parsedLine);
                continue;
            }
            lineValidator.validate(parsedLine);
            resultList.add(parsedLine);
        }
        return resultList;
    }
}
