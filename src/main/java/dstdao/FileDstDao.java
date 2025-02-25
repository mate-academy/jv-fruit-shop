package dstdao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDstDao implements DstDao {
    private Path fileDao;

    @Override
    public boolean openDst(String uri) {
        fileDao = Paths.get(uri);
        if (Files.exists(fileDao)) {
            return true;
        } else {
            try {
                Files.createFile(fileDao);
                return true;
            } catch (IOException e) {
                throw new RuntimeException("Can't create file to wright report!!!", e);
            }
        }
    }

    @Override
    public boolean closeDst(String uri) {
        return true;
    }

    @Override
    public boolean writeDst(List<String> report) {
        try {
            Files.write(fileDao, report, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Something is wrong with writing data to file!!!!", e);
        }
    }
}
