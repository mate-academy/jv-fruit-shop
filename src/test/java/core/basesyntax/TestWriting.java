package core.basesyntax;

import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.WriteToCsvFileImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class TestWriting extends TestCase {

    @Test
    public void testWritingToFile_Ok() {
        FileWriter writer = new WriteToCsvFileImpl();
        writer.writeToFile("Expected report", "ExpectedReport");
    }
}
