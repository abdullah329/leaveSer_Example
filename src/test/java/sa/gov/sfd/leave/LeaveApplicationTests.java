package sa.gov.sfd.leave;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sa.gov.sfd.leave.action.*;
import sa.gov.sfd.leave.domain.application.exception.DuplicateApplication;
import sa.gov.sfd.leave.model.Application;
import sa.gov.sfd.leave.model.Balance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LeaveApplicationTests {


    @Autowired
    GetApplicationsToMakeAction service;

    @Autowired
    GetCurrentBalance balance;

    @Autowired
    GetOneApplicationToAction oneApplicationToAction;

    @Autowired
    AddNewApplication addNewApplication;

    @Autowired
    ApproveApplication approveApplication;

//
//    @Test
//    void getApplicationToMakeActionTest() {
//        List<Application> applications = service.getApplicationByPermissionId(1045111123);
//        Assertions.assertTrue(applications.size() > 0);
//    }


    @Test
    void getCurrentBalanceTest() {
        List<Balance> balanceList = balance.getBalance(1045167143, (short) 1);

        Assertions.assertEquals(3, balanceList.size());
    }

    @Test
    void getOneApplicationToAction() {
        Application application = oneApplicationToAction.getApplication((long) 10,  1);
        Assertions.assertNotNull(application);
    }

    @Test
    void addNewApplicationTestSuccess() {
        Application application = new Application();
        application.setId((long) 11);
        application.setUserNid(1045167143);
        application.setDuration((short) 10);
        application.setStartDateAg(LocalDate.now());
        application.setType((short) 1);

        Long returnValue = addNewApplication.addNewApplication(application);

        Assertions.assertNotNull(returnValue);
    }

    @Test
    void addNewApplicationTestDuplicate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Application application = new Application();
        application.setId((long) 11);
        application.setUserNid(1045167143);
        application.setDuration((short) 5);
        application.setStartDateAg(LocalDate.parse("22/03/2020", formatter));
        application.setType((short) 1);

//        Long returnValue = addNewApplication.addNewApplication(application);

        Assertions.assertThrows(DuplicateApplication.class, () -> addNewApplication.addNewApplication(application)
                ,"There are another application with same date and duration" );
    }


    @Test
    void approveApplication() {
        Application application = oneApplicationToAction.getApplication((long) 10,  1);

        approveApplication.approve(application);

    }


}
