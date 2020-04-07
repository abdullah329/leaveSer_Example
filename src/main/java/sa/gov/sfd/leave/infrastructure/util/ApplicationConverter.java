package sa.gov.sfd.leave.infrastructure.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sa.gov.sfd.leave.infrastructure.constant.LeaveType;
import sa.gov.sfd.leave.model.Application;
import sa.gov.sfd.leave.model.ApplicationWithPermissionDTO;
import sa.gov.sfd.leave.view.ApplicationDTO;
import sa.gov.sfd.leave.view.ApplicationTransactionDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ApplicationConverter {

    @Autowired
    private LeaveType leaveType;

    public Application convertToModel(ApplicationDTO dto) {
        Application model = new Application();
        model.setType((short) dto.getType());
        model.setDuration((short) dto.getDuration());
        model.setStartDateAg(dto.getStartDateAg());
        return model;
    }

    public List<ApplicationTransactionDTO> convertToTransactionDTO(List<ApplicationWithPermissionDTO> model) {

        return model.stream().map(x ->
                new ApplicationTransactionDTO(x.getId(),x.getWorkflowPriority(),
                        x.getUserNid()
                        , x.getStartDateAg()
                        , x.getDuration()
                        , leaveType.getType(x.getType())
                        , x.getAction())).collect(Collectors.toList());
    }


    public List<ApplicationDTO> convertoapplicationdto(List<Application> model){

        return model.stream()
                .map(x ->
                        new ApplicationDTO(x.getId(),x.getStartDateAg(), x.getDuration(),x.getType(),leaveType.getType(x.getType()),x.getStatus()))
                .collect(Collectors.toList());
    }

//    public Application convertFromTransactionToModel(ApplicationTransactionDTO dto){
//
//    }

}
