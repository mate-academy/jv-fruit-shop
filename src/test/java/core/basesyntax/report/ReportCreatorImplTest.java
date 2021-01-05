package core.basesyntax.report;

import static org.junit.Assert.assertEquals;

import core.basesyntax.dao.classes.MyFileReaderImpl;
import core.basesyntax.dao.classes.MyFileWriterImpl;
import core.basesyntax.dao.interfaces.MyFileWriter;
import core.basesyntax.database.Storage;
import core.basesyntax.procedures.classes.BalanceProcedure;
import core.basesyntax.procedures.classes.ProcedureStrategyImpl;
import core.basesyntax.procedures.classes.Procedures;
import core.basesyntax.procedures.classes.PurchaseProcedure;
import core.basesyntax.procedures.classes.ReturnProcedure;
import core.basesyntax.procedures.classes.SupplyProcedure;
import core.basesyntax.procedures.interfaces.Procedure;
import core.basesyntax.procedures.interfaces.ProcedureStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportCreatorImplTest {
    private static ReportCreator reportCreator;

    @BeforeClass
    public static void beforeClass() {
        Map<Procedures, Procedure> procedureMap = new HashMap<>();
        procedureMap.put(Procedures.BALANCE, new BalanceProcedure());
        procedureMap.put(Procedures.PURCHASE, new PurchaseProcedure());
        procedureMap.put(Procedures.SUPPLY, new SupplyProcedure());
        procedureMap.put(Procedures.RETURN, new ReturnProcedure());
        ProcedureStrategy procedureStrategy = new ProcedureStrategyImpl(procedureMap);
        reportCreator = new ReportCreatorImpl(procedureStrategy);
    }

    @Before
    public void setUp() {
        Storage.setFruitData(new TreeMap<>());
    }

    @Test
    public void test1_ReportCreatorOk() {
        String actual = reportCreator.createReport(
                new MyFileReaderImpl("src/main/resources/test1.cvs"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,20" + System.lineSeparator() + "banana,95";
        assertEquals(expected, actual);
    }

    @Test
    public void test2_ReportCreatorToFileOk() {
        MyFileWriter myFileWriter = new MyFileWriterImpl();
        myFileWriter.writeData(reportCreator.createReport(
                new MyFileReaderImpl("src/main/resources/test2.csv")),
                "src/main/resources/test2_output.csv");
        String actual;
        try {
            actual = Files.readString(Path.of("src/main/resources/test2_output.csv"));
        } catch (IOException e) {
            throw new RuntimeException("Can't read test2_output.csv", e);
        }
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,82" + System.lineSeparator() + "banana,43";
        assertEquals(expected, actual);
    }

    @Test
    public void test3_ReportCreator_emptyProcedures() {
        try {
            reportCreator.createReport(new MyFileReaderImpl("src/main/resources/test3.csv"));
        } catch (RuntimeException e) {
            assertEquals("Procedure '' not found", e.getMessage());
        }
    }

    @Test
    public void test4_ReportCreator_notEnoughSupply() {
        try {
            reportCreator.createReport(new MyFileReaderImpl("src/main/resources/test4.csv"));
        } catch (RuntimeException e) {
            assertEquals("There are not enough banana in the storage", e.getMessage());
        }
    }

    @Test
    public void test5_ReportCreator_wrongProcedure() {
        try {
            reportCreator.createReport(new MyFileReaderImpl("src/main/resources/test5.csv"));
        } catch (RuntimeException e) {
            assertEquals("Procedure 'k' not found", e.getMessage());
        }
    }
}
