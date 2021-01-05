package core.basesyntax.report;

import core.basesyntax.dao.interfaces.MyFileReader;
import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.procedures.classes.Procedures;
import core.basesyntax.procedures.interfaces.ProcedureStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ReportCreatorImpl implements ReportCreator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";
    private static final int PROCEDURE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ProcedureStrategy procedureStrategy;

    public ReportCreatorImpl(ProcedureStrategy procedureStrategy) {
        this.procedureStrategy = procedureStrategy;
    }

    @Override
    public String createReport(MyFileReader data) {
        List<String> stringList = data.readData();
        for (String line : stringList) {
            String[] lineData = line.split(SPLITTER);
            if (Integer.parseInt(lineData[QUANTITY_INDEX]) < 0
                    || Arrays.stream(Procedures.values())
                    .anyMatch(t -> t.name().equals(lineData[PROCEDURE_INDEX]))) {
                throw new RuntimeException("Incorrect input data");
            }
            procedureStrategy.get(checkProcedures(lineData[PROCEDURE_INDEX]))
                    .doProcedure(new Fruit(lineData[FRUIT_INDEX]),
                            Integer.parseInt(lineData[QUANTITY_INDEX]));
        }
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruitData().entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey().getFruitName())
                    .append(SPLITTER).append(entry.getValue());
        }
        return report.toString();
    }

    private Procedures checkProcedures(String procedures) {
        for (Procedures proc : Procedures.values()) {
            if (Objects.equals(proc.getProcedure(), procedures.toLowerCase().trim())) {
                return proc;
            }
        }
        throw new NoSuchElementException("Procedure '" + procedures + "' not found");
    }
}
