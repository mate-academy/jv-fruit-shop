package reporter;

public interface AutoReporter<J> {
    String makeReportFrom(J something);

    void makeReportFromTo(J something1, J something2);
}
