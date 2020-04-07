package sa.gov.sfd.leave.domain.application.exception;

public class ConfirmException extends IllegalArgumentException {

    @Override
    public String getMessage() {
        return "The application is not approved, you have to approve it first";
    }
}
