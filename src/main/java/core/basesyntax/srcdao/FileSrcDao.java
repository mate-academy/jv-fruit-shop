package core.basesyntax.srcdao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSrcDao implements SrcDao {
    private Path path;
    private List<String> fileContents;

    @Override
    public boolean openSrc(String uri) {
        path = Paths.get(uri);
        return Files.exists(path);
    }

    @Override
    public boolean closeSrc(String uri) {
        return true;
    }

    @Override
    public boolean readSrc() {
        try {
            fileContents = Files.readAllLines(path);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getSrcContents() {
        return fileContents;
    }
}
