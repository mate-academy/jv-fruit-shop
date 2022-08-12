package core.basesyntax.service;

public interface ReportCreator {
    String createHeader(String firstColumn, String secondColumn);

    String create(String header);

}
