package sa.gov.sfd.leave.domain.balance.exception;

public class DuplicateOpenBalance extends IllegalArgumentException {

    @Override
    public String getMessage() {
        return "The employee is already has balance for this year";
    }
}
