CREATE SCHEMA `FRAMEWORK-SAMPLES`;

CREATE TABLE `SECURITY_USER`
(
    `ID`        varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
    `ACCOUNT`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `REAL_NAME` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `SORT`      int                                                   DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin


INSERT INTO `SECURITY_USER` (`ID`,`ACCOUNT`,`REAL_NAME`,`SORT`) VALUES ('1','randy','张三',2);
INSERT INTO `SECURITY_USER` (`ID`, `ACCOUNT`, `REAL_NAME`, `SORT`)
VALUES ('2', 'leon', '张四', 1);
INSERT INTO `SECURITY_USER` (`ID`, `ACCOUNT`, `REAL_NAME`, `SORT`)
VALUES ('3', 'kevin', '王五', 3);
INSERT INTO `SECURITY_USER` (`ID`, `ACCOUNT`, `REAL_NAME`, `SORT`)
VALUES ('4', 'smith', '赵六', 4);