package sa.gov.sfd.leave.domain.application.exception;

public class CancelException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "The application isn't confirmed, you can not cancel non-confirmed application";
    }
}
