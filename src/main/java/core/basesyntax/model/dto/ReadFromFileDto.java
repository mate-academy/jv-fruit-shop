package core.basesyntax.model.dto;

import java.util.List;

public interface ReadFromFileDto {
    List<String> readFile(String fileName);
}
