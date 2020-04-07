package sa.gov.sfd.leave.domain.application;


import sa.gov.sfd.leave.model.Application;

import java.util.List;

/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public interface ApplicationService {

    /**
     * Retrieve all application
     * @return list of Application Transaction
     */
    List<Application> findAll();

    /**
     * Retrieve all employee application
     * @param userNid employee national id
     * @return list of application treansaction
     */
    List<Application> findByUserNid(Integer userNid);

    /**
     * Find specific application by Id
     * @param id application id
     * @return application transaction object
     */
    Application findById(Long id, Integer priority);


    /**
     * Create a new leaving application by employee
      * @param application application object without id
     * @return application id
     */

    Long addNewApplication(Application application);

    /**
     * Create approval, confirmation, cancellation or reject application transaction by permit user, it use a same
     * application id with different priority id
     * @param application application object with id
     */
    void addActionOnApplication(Application application);


    void reject(Application application);

    /**
     * Retrieve all application for permit user to make  an action (approve, confirm, reject, cancel)
     * @param permissionsId permissions group id
     * @return list of application objects
     */

    List<Application> findByWorkflowId(List<Long> permissionsId);

    /**
     * Confirm and validate application
     * @param application application object
     */
    void confirm(Application application);

    void approve(Application application);

    void cancel(Application application);
}
