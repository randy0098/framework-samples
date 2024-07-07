CREATE SCHEMA `FRAMEWORK-SAMPLES`;

CREATE TABLE `SECURITY_USER`
(
    `ID`          varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
    `ACCOUNT`     varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `REAL_NAME`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `SORT`        int                                                   DEFAULT NULL,
    `CREATE_USER` varchar(36) COLLATE utf8mb4_bin                       DEFAULT NULL,
    `CREATE_TIME` timestamp(6) NULL DEFAULT NULL,
    `UPDATE_USER` varchar(36) COLLATE utf8mb4_bin                       DEFAULT NULL,
    `UPDATE_TIME` timestamp(6) NULL DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin