package sa.gov.sfd.leave.domain.application;

import sa.gov.sfd.leave.model.Application;

import java.util.List;


public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationDao dao;
    private final ApplicationValidation validation;

    public ApplicationServiceImpl(ApplicationDao dao, ApplicationValidation validation) {
        this.dao = dao;
        this.validation = validation;
    }

    @Override
    public List<Application> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Application> findByUserNid(Integer userNid) {
        return dao.findByUserNid(userNid);
    }

    @Override
    public Application findById(Long id, Integer priority) {
        return dao.findById(id, priority).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Long addNewApplication(Application application) {
        validation.validate(application);
        return dao.insertNewApplication(application);
    }

    @Override
    public void addActionOnApplication(Application application) {
//        validation.validateAction(application);
        dao.insertNewAction(application);
    }

    @Override
    public void confirm(Application application) {
        validation.validateConfirm(application);
        dao.insertNewAction(application);
    }

    @Override
    public void approve(Application application) {
        validation.validateApprove(application);
        dao.insertNewAction(application);
    }

    @Override
    public void cancel(Application application) {
        validation.validateCancel(application);
        dao.insertNewAction(application);
    }

    @Override
    public void reject(Application application){
        validation.validateReject(application);
        dao.insertNewAction(application);
    }

    @Override
    public List<Application> findByWorkflowId(List<Long> permissionsId) {
        return dao.findByWorkflowId(permissionsId);
    }
}
