package sa.gov.sfd.leave.infrastructure.constant;

import org.springframework.stereotype.Component;

@Component
public class LeaveType {

    public String getType(short type){
        if (type == 1) {
            return "اعتيادية";
        }
        return "";
    }
}
