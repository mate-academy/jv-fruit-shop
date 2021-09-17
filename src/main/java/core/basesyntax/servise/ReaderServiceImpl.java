package core.basesyntax.servise;

import core.basesyntax.files.Reader;
import core.basesyntax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String SEPARATOR = ",";
    private final Reader reader;
    private final Validator titleValidator;
    private final Validator lineValidator;

    public ReaderServiceImpl(Reader reader, Validator titleValidator, Validator lineValidator) {
        this.reader = reader;
        this.titleValidator = titleValidator;
        this.lineValidator = lineValidator;
    }

    @Override
    public List<List<String>> readData() {
        List<List<String>> resultList = new ArrayList<>();
        List<String> lines = reader.read();
        for (int i = 0; i < lines.size(); i++) {
            List<String> parsedLine = Arrays.asList(lines.get(i).strip().split(SEPARATOR));
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
