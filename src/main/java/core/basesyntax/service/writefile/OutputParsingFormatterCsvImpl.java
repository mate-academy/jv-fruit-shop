package core.basesyntax.service.writefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OutputParsingFormatterCsvImpl implements OutputParsingFormatterCsv {
    @Override
    public void writeFormatCsv(String string,String path) {
        String replace;
        if (string.matches("\\w*\\s\\d*")) {
            replace = string.trim().replace(" ", ",");
        } else {
            throw new RuntimeException("is not correct format string");
        }
        try {
            Files.write(Path.of(path),replace.concat("\n").getBytes(),
                    StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("is not correct url... " + e);
        }
    }
}
