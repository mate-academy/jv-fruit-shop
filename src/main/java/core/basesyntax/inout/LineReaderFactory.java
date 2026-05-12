package core.basesyntax.inout;

public class LineReaderFactory {

    public static LineReader create(ReaderType type) {

        return switch (type) {
            case READ_ALL -> new ReadAllLinesReader();
            case STREAM -> new StreamLinesReader();
            case CSV -> new CsvLineReader();
        };
    }
}
