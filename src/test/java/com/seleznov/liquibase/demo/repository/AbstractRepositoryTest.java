package com.seleznov.liquibase.demo.repository;

import com.seleznov.liquibase.demo.Application;
import com.seleznov.liquibase.demo.config.RepositoryTestConfig;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Illia Seleznov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest
@SpringApplicationConfiguration(classes = {RepositoryTestConfig.class, Application.class})
@TestPropertySource(locations="classpath:test.properties")
public abstract class AbstractRepositoryTest {

    @Autowired
    private DataSource dataSource;

    private Liquibase liquibase;

    @Before
    public void init() throws LiquibaseException, SQLException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(dataSource.getConnection()));
        liquibase = new Liquibase(getTestChangelog(), new FileSystemResourceAccessor("src/test/resources"), database);
        liquibase.update("test");

    }

    @After
    public void after() throws LiquibaseException {
        liquibase.rollback(1, "test");
    }

    protected abstract String getTestChangelog();
}
