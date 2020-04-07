package sa.gov.sfd.leave.view;

import java.time.LocalDate;

public class ApplicationTransactionDTO {

    private long id;
    private int priority;
    private int userNid;
    private LocalDate startDateAg;
    private short duration;
    private String type;
    private String action;


    public ApplicationTransactionDTO(long id, int priority, int userNid, LocalDate startDateAg, short duration, String type, String action) {
        this.id = id;
        this.priority = priority;
        this.userNid = userNid;
        this.startDateAg = startDateAg;
        this.duration = duration;
        this.type = type;
        this.action = action;
    }

    public int getUserNid() {
        return userNid;
    }

    public void setUserNid(int userNid) {
        this.userNid = userNid;
    }

    public LocalDate getStartDateAg() {
        return startDateAg;
    }

    public void setStartDateAg(LocalDate startDateAg) {
        this.startDateAg = startDateAg;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
