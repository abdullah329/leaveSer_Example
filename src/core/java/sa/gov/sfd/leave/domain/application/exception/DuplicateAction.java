package sa.gov.sfd.leave.domain.application.exception;

public class DuplicateAction extends IllegalArgumentException {

    @Override
    public String getMessage() {
        return "You can not duplicate an action on the same application";
    }
}
