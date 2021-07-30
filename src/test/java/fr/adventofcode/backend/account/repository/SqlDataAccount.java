package fr.adventofcode.backend.account.repository;

import org.springframework.test.context.jdbc.Sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Sql(
        statements = {
                "insert into Account (id, birthdate, email, password, role, username) values (1, '1999-01-01','abc@gmail.com','heyhey','ADMIN','abc-123')",
                "insert into Account (id, birthdate, email, password, role, username) values (2, '1999-01-01','abcc@gmail.com','heyhey','ADMIN','abc-1234')",
                "insert into Account (id, birthdate, email, password, role, username) values (3, '1999-01-01','abcd@gmail.com','heyhey','ADMIN','abc-1235')",

        },
        executionPhase = BEFORE_TEST_METHOD
)
@Sql(
        statements = {
                "delete from Account"
        },
        executionPhase = AFTER_TEST_METHOD
)
public @interface SqlDataAccount {
}
