DROP DATABASE IF EXISTS db_excel;
CREATE DATABASE db_excel;

DROP TABLE IF EXISTS db_excel.student;
CREATE TABLE db_excel.student (
  id        INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  name      VARCHAR(255) NOT NULL
  COMMENT '姓名',
  gender    VARCHAR(255) NOT NULL
  COMMENT '性别',
  age       INT          NOT NULL
  COMMENT '年龄',
  education VARCHAR(255) NOT NULL
  COMMENT '学历'
)COMMENT '学生信息表';

SELECT *
FROM db_excel.student;