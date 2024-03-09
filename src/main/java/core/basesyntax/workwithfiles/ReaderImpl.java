package core.basesyntax.workwithfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderImpl implements Reader {
    public static final List<String> CORRECT_START_OF_LINE = Arrays.asList("b", "p", "r", "s");
    public static final String ELEMENT_SEPARATOR = ";";

    @Override
    public List<String[]> read(String inputFile) {
        List<String[]> list = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
            String line = fileReader.readLine();
            while (line != null) {
                if (!CORRECT_START_OF_LINE.contains(line.split(ELEMENT_SEPARATOR)[0])) {
                    line = fileReader.readLine();
                    continue;
                }
                list.add(line.split(ELEMENT_SEPARATOR));
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + inputFile, e);
        }
        return list;
    }
}
