package fruitshop.dataservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeDataToFile(String reportToFile, List<String> convertReport) {
        try {
            Files.write(Path.of(reportToFile), convertReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + reportToFile, e);
        }
    }
}
