package sa.gov.sfd.leave.domain.balance.exception;

public class NoApplicationForBalance extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "You can not change balance without confirmed or canceled leave application";
    }
}
