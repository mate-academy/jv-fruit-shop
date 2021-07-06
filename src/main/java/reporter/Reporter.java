package reporter;

import exceptions.InvalidDataException;

public interface Reporter<J> {
    String makeReportFrom(J something) throws InvalidDataException;
}
