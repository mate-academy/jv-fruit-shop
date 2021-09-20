package core.basesyntax.reportgeneratorservice;

import core.basesyntax.filevalidatorservice.LineSpliterator;
import core.basesyntax.filevalidatorservice.Validator;
import core.basesyntax.storeactivities.ActionFunction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class RecordResult implements Validator, ReportGenerator {
    private LineSpliterator lineSpliterator = new LineSpliterator();
    private ActionFunction actionFunction = new ActionFunction();

    public void recordResultInFile(String sourceFile, String reportFile) {
        HashMap<String, Integer> balance = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.equals(FIRST_LINE)) {
                    line = bufferedReader.readLine();
                }
                String[] temporary = lineSpliterator.splitLineToArray(line);
                actionFunction.executeAction(balance, temporary);
                line = bufferedReader.readLine();
            }
            bufferedWriter.write(mapToStringConverter(balance));
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file."
                    + " Unable to adjust records in Record Result");
        }
    }
}
