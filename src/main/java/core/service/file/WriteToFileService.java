package core.service.file;

import java.util.List;

public interface WriteToFileService {
    void writeReport(List<String> report, String pathTo);
}
