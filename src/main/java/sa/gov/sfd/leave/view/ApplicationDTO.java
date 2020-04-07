package sa.gov.sfd.leave.view;

import java.time.LocalDate;

public class ApplicationDTO {

    private long id;
    private LocalDate startDateAg;
    private int duration;
    private String typeName;
    private int type;
    private int status;

    public ApplicationDTO() {
    }

    public ApplicationDTO(LocalDate startDateAg, int duration, int type) {
        this.startDateAg = startDateAg;
        this.duration = duration;
        this.type = type;
    }

    public ApplicationDTO(long id, LocalDate startDateAg, int duration, int type,String typeName, int status) {
        this.id = id;
        this.startDateAg = startDateAg;
        this.duration = duration;
        this.type = type;
        this.typeName = typeName;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDateAg() {
        return startDateAg;
    }

    public void setStartDateAg(LocalDate startDateAg) {
        this.startDateAg = startDateAg;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
