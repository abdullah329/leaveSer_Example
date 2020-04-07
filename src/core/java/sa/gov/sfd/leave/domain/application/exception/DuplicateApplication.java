package sa.gov.sfd.leave.domain.application.exception;

public class DuplicateApplication extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "There is another active application with same information";
    }
}
