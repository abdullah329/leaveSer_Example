CREATE TABLE GROUP_PERMISSIONS(
                                  ID NUMBER NOT NULL,
                                  GROUP_NAME VARCHAR(100),
                                  EMPLOYEES VARCHAR(500)
);

ALTER TABLE GROUP_PERMISSIONS ADD PRIMARY KEY (ID);


CREATE TABLE WORKFLOW(
                         ID NUMBER NOT NULL,
                         PRIORITY NUMBER NOT NULL,
                         GROUP_ID NUMBER,
                         ACTION varchar(2)
);

ALTER TABLE WORKFLOW
    ADD PRIMARY KEY (ID,PRIORITY);

ALTER TABLE WORKFLOW
    ADD FOREIGN KEY (GROUP_ID)
        REFERENCES GROUP_PERMISSIONS(ID);


CREATE TABLE APPLICATION_TRANSACTION(
                                        ID NUMBER NOT NULL,
                                        PRIORITY_ORDER NUMBER NOT NULL,
                                        USER_NID NUMBER NOT NULL,
                                        START_DATE_AG DATE NOT NULL,
                                        START_DATE_AH VARCHAR(20),
                                        DURATION NUMBER,
                                        REQUEST_DATE TIMESTAMP,
                                        WORKFLOW NUMBER,
                                        TYPE NUMBER,
                                        STATUS number
);

ALTER TABLE APPLICATION_TRANSACTION
    ADD PRIMARY KEY (ID, PRIORITY_ORDER);
ALTER TABLE APPLICATION_TRANSACTION
    ADD FOREIGN KEY (WORKFLOW,PRIORITY_ORDER)
        REFERENCES WORKFLOW(ID,PRIORITY);
-- ALTER TABLE APPLICATION_TRANSACTION
--     ADD FOREIGN KEY (PRIORITY_ORDER)
--         REFERENCES WORKFLOW(PRIORITY);


CREATE TABLE BALANCE_TRANSACTION(
                                    ID NUMBER NOT NULL,
                                    APPLICATION_ID NUMBER,
                                    USER_NID NUMBER,
                                    YEAR NUMBER,
                                    START_EFCT_DATE_AG DATE,
                                    END_EFCT_DATE_AG DATE ,
                                    START_EFCT_DATE_AH VARCHAR(20),
                                    END_EFCT_DATE_AH VARCHAR(20),
                                    TYPE NUMBER ,
                                    BALANCE NUMBER,
                                    CREDIT_OR_DEBIT NUMBER
);

ALTER TABLE BALANCE_TRANSACTION ADD PRIMARY KEY (ID);
-- ALTER TABLE BALANCE_TRANSACTION ADD FOREIGN KEY (APPLICATION_ID) REFERENCES APPLICATION_TRANSACTION(ID);





CREATE TABLE APPROVAL_PATH(
                              USER_NID NUMBER NOT NULL,
                              WORKFLOW NUMBER NOT NULL
);

ALTER TABLE APPROVAL_PATH
    ADD PRIMARY KEY(USER_NID,WORKFLOW);
-- ALTER TABLE APPROVAL_PATH
-- ADD FOREIGN KEY (WORKFLOW)
-- REFERENCES WORKFLOW(workflow_ID);
