package sa.gov.sfd.leave.view;

import java.time.LocalDate;

public class BalanceDTO {

    private short year;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private int balance;

    public BalanceDTO(short year, LocalDate startDate, LocalDate endDate, String type, int balance) {
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.balance = balance;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
