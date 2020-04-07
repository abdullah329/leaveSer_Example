package sa.gov.sfd.leave.controller;


import org.springframework.web.bind.annotation.*;
import sa.gov.sfd.leave.action.*;
import sa.gov.sfd.leave.infrastructure.util.ApplicationConverter;
import sa.gov.sfd.leave.model.Application;
import sa.gov.sfd.leave.view.ApplicationTransactionDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/leave/action")
public class ApprovalTransactionController {

    private final ApproveApplication approve;

    private final ConfirmApplication confirm;

    private final RejectApplication reject;

    private final CancelApplication cancel;

    private final GetApplicationsToMakeAction applicationList;

    private final GetOneApplicationToAction oneTransaction;

    private final ApplicationConverter applicationConverter;

    private final GetPermissionsByID getPermissionsByID;


    public ApprovalTransactionController(ApproveApplication approve, ConfirmApplication confirm, RejectApplication reject, CancelApplication cancel, GetApplicationsToMakeAction applicationList, ApplicationConverter applicationConverter, GetOneApplicationToAction oneTransaction
            , GetPermissionsByID getPermissionsByID) {
        this.approve = approve;
        this.confirm = confirm;
        this.reject = reject;
        this.cancel = cancel;
        this.applicationList = applicationList;
        this.applicationConverter = applicationConverter;
        this.oneTransaction = oneTransaction;
        this.getPermissionsByID = getPermissionsByID;
    }


    @GetMapping("/transaction")
    public List<ApplicationTransactionDTO> getAllTransaction() {
        Integer userNid = Integer.valueOf("1023122332");
        return applicationConverter.convertToTransactionDTO(applicationList.getApplicationByPermissionId(userNid));
    }

    @GetMapping("/transaction/{id}")
    public Application getOneTransaction(@PathVariable("id") long id, @RequestParam("priority") Integer priority) {
        return oneTransaction.getApplication(id, priority);
    }

    @PostMapping("/approve")
    public void approve(@RequestBody final ApplicationTransactionDTO resource) {
        Application application = oneTransaction.getApplication(resource.getId(), resource.getPriority());
        approve.approve(application);
    }

    @PostMapping("/confirm")
    public void confirm(@RequestBody final ApplicationTransactionDTO resource) {
        Application application = oneTransaction.getApplication(resource.getId(), resource.getPriority());
        confirm.confirm(application);
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody final ApplicationTransactionDTO resource) {
        Application application = oneTransaction.getApplication(resource.getId(), resource.getPriority());
        cancel.cancel(application);
    }

    @PostMapping("/reject")
    public void reject(@RequestBody final ApplicationTransactionDTO resource) {
        Application application = oneTransaction.getApplication(resource.getId(), resource.getPriority());
        reject.reject(application);
    }

}
