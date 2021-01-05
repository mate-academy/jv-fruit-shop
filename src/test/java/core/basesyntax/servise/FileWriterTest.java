package core.basesyntax.servise;

import core.basesyntax.servise.impl.FileWriterImpl;
import java.util.HashMap;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileWriterTest {
    private static FileWriter writer;

    @BeforeClass
    public static void beforeClass() throws Exception {
        writer = new FileWriterImpl();
    }

    @Test(expected = RuntimeException.class)
    public void csvFileWriterException_Ok() {
        writer.createReport(new HashMap<>(), "");
    }
}

