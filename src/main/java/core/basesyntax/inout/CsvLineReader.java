package core.basesyntax.inout;

import core.basesyntax.exception.DataProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvLineReader implements LineReader {

    @Override
    public Stream<String> readLines(String path) {
        try (CSVParser parser = CSVFormat.DEFAULT.parse(Files.newBufferedReader(Path.of(path)))) {
            List<String> lines = new ArrayList<>();
            for (CSVRecord record : parser) {
                lines.add(String.join(",", record));
            }
            return lines.stream();
        } catch (IOException e) {
            throw new DataProcessingException("Can't read from file: " + path, e);
        }
    }
}
