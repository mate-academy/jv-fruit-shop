package core.basesyntax;

import core.basesyntax.service.WriteReportToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteReportInFile implements WriteReportToFile {

    @Override
    public int writeReportIntoFile(String fileTo, Map<String,Integer> map) {
        CreateReportImpl createReport = new CreateReportImpl();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTo, true))) {
            bufferedWriter.write(map.entrySet().toString());
            bufferedWriter.write("\n");
        } catch (IOException e) {
            throw new RuntimeException("File can not be written");
        }
        return 0;
    }
}
