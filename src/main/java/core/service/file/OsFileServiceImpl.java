package core.service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.RemoteException;
import java.util.List;

public class OsFileServiceImpl implements FileService {

    public OsFileServiceImpl() {
    }

    @Override
    public List<String> readFile(String filePath) throws IOException {
        try {
            List<String> records = Files.readAllLines(new File(filePath).toPath());
            records.remove(0);
            return records;
        } catch (IOException e) {
            throw new RemoteException("Can't read file " + filePath, e);
        }
    }
}

