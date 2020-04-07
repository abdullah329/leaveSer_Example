package sa.gov.sfd.leave.domain.application.exception;

public class RejectException extends IllegalArgumentException{
    @Override
    public String getMessage() {
        return "The application isn't initial or approved, you can reject only approved application";
    }
}
