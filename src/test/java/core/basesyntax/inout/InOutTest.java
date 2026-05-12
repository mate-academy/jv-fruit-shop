package core.basesyntax.inout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.exception.DataProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class InOutTest {

    @TempDir
    private Path tempDir;

    @Test
    void csvLineReader_ShouldReadLines() throws IOException {
        Path file = tempDir.resolve("test.csv");
        Files.writeString(file, "b,apple,10\ns,banana,5");

        LineReader reader = new CsvLineReader();
        try (Stream<String> lines = reader.readLines(file.toString())) {
            List<String> result = lines.toList();
            assertEquals(2, result.size());
            assertTrue(result.contains("b,apple,10"));
        }
    }

    @Test
    void csvLineReader_ShouldThrowException_WhenFileNotFound() {
        LineReader reader = new CsvLineReader();
        assertThrows(DataProcessingException.class, () -> reader.readLines("non_existent.csv"));
    }

    @Test
    void csvWriter_ShouldWriteContent() throws IOException {
        Path file = tempDir.resolve("output.csv");
        ReportWriter writer = new CsvWriter();
        String content = "fruit,quantity\napple,10";
        writer.write(file.toString(), content);

        assertEquals(content, Files.readString(file));
    }

    @Test
    void streamLinesReader_ShouldReadLines() throws IOException {
        Path file = tempDir.resolve("stream.txt");
        Files.writeString(file, "line1\nline2");

        LineReader reader = new StreamLinesReader();
        try (Stream<String> lines = reader.readLines(file.toString())) {
            assertEquals(2, lines.count());
        }
    }

    @Test
    void readAllLinesReader_ShouldReadLines() throws IOException {
        Path file = tempDir.resolve("all.txt");
        Files.writeString(file, "line1\nline2");

        LineReader reader = new ReadAllLinesReader();
        try (Stream<String> lines = reader.readLines(file.toString())) {
            assertEquals(2, lines.count());
        }
    }

    @Test
    void lineReaderFactory_ShouldCreateReaders() {
        assertNotNull(LineReaderFactory.create(ReaderType.CSV));
        assertNotNull(LineReaderFactory.create(ReaderType.STREAM));
        assertNotNull(LineReaderFactory.create(ReaderType.READ_ALL));
    }

    @Test
    void dataProcessingException_ShouldHoldMessageAndCause() {
        Exception cause = new RuntimeException("cause");
        DataProcessingException exception = new DataProcessingException("message", cause);
        assertEquals("message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
