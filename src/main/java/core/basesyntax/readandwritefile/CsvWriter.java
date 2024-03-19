package core.basesyntax.readandwritefile;

import java.util.List;

public interface CsvWriter {
    public void writeLinesToFile(List<String> lines, String filePath);
}
