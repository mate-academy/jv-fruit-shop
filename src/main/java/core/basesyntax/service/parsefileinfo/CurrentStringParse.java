package core.basesyntax.service.parsefileinfo;

public class CurrentStringParse {
    public String[] parse(String fileInfo) {
        return fileInfo.split("[\\r\\n\\s]+");
    }
}
