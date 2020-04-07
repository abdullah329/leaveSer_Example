package sa.gov.sfd.leave.domain.application.exception;

public class IntersectionException extends IllegalArgumentException {

    @Override
    public String getMessage() {
        return "The application is intersection with another application";
    }
}
