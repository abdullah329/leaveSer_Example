package sa.gov.sfd.leave.domain.path;


import sa.gov.sfd.leave.model.EmployeeApprovalPath;
import sa.gov.sfd.leave.model.Workflow;

import java.util.List;

/**
 * @version 1.0
 * @author malsharhan@sfd.gov.sa
 *
 */

public interface ApprovalPathService {

    /**
     * Retrieve all employees that have same workflow id
     * @param workflow workflow id
     * @return list of employee approval path object with same workflow id
     */
    List<EmployeeApprovalPath> findByWorkflowId(Workflow workflow);

    /**
     * Retrieve workflow id for employee by using employee national id
     * @param userNid employee national id
     * @return employee approval path object
     */
    EmployeeApprovalPath findByUserNid(Integer userNid);


}
