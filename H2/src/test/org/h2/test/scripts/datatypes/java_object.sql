-- Copyright 2004-2022 H2 Group. Multiple-Licensed under the MPL 2.0,
-- and the EPL 1.0 (https://h2database.com/html/license.html).
-- Initial Developer: H2 Group
--

EXPLAIN VALUES CAST(X'' AS JAVA_OBJECT);
>> VALUES (CAST(X'' AS JAVA_OBJECT))

VALUES CAST(CAST(X'00' AS JAVA_OBJECT) AS VARCHAR(2));
> exception DATA_CONVERSION_ERROR_1

VALUES CAST(CAST(X'00' AS JAVA_OBJECT) AS CHAR(2));
> exception DATA_CONVERSION_ERROR_1

VALUES CAST('00' AS JAVA_OBJECT);
> exception DATA_CONVERSION_ERROR_1

VALUES CAST(CAST('00' AS CHAR(2)) AS JAVA_OBJECT);
> exception DATA_CONVERSION_ERROR_1

VALUES CAST(X'0000' AS JAVA_OBJECT(1));
> exception VALUE_TOO_LONG_2

VALUES CAST(CAST (X'0000' AS JAVA_OBJECT) AS JAVA_OBJECT(1));
> exception VALUE_TOO_LONG_2

CREATE TABLE T(C JAVA_OBJECT(0));
> exception INVALID_VALUE_2

CREATE TABLE T1(A JAVA_OBJECT(1000000000));
> ok

CREATE TABLE T2(A JAVA_OBJECT(1000000001));
> exception INVALID_VALUE_PRECISION

SET TRUNCATE_LARGE_LENGTH TRUE;
> ok

CREATE TABLE T2(A JAVA_OBJECT(1000000000));
> ok

SELECT TABLE_NAME, CHARACTER_OCTET_LENGTH FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'PUBLIC';
> TABLE_NAME CHARACTER_OCTET_LENGTH
> ---------- ----------------------
> T1         1000000000
> T2         1000000000
> rows: 2

SET TRUNCATE_LARGE_LENGTH FALSE;
> ok

DROP TABLE T1, T2;
> ok
