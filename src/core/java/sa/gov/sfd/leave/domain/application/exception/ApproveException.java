package sa.gov.sfd.leave.domain.application.exception;

public class ApproveException extends IllegalArgumentException {

    @Override
    public String getMessage() {
        return "The application isn't initial, you can not approved non-initial application";
    }

}
