package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.api.ResourceProvider;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.internal.database.base.BaseDatabaseType;
import org.flywaydb.core.internal.database.base.Database;
import org.flywaydb.core.internal.jdbc.JdbcConnectionFactory;
import org.flywaydb.core.internal.jdbc.StatementInterceptor;
import org.flywaydb.core.internal.parser.Parser;
import org.flywaydb.core.internal.parser.ParsingContext;

import java.sql.Connection;

public class IrisDatabaseType extends BaseDatabaseType {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getNullType() {
        return 0;
    }

    @Override
    public boolean handlesJDBCUrl(String url) {
        return false;
    }

    @Override
    public String getDriverClass(String url, ClassLoader classLoader) {
        return null;
    }

    @Override
    public boolean handlesDatabaseProductNameAndVersion(String databaseProductName, String databaseProductVersion, Connection connection) {
        return false;
    }

    @Override
    public Database createDatabase(Configuration configuration, JdbcConnectionFactory jdbcConnectionFactory, StatementInterceptor statementInterceptor) {
        return null;
    }

    @Override
    public Parser createParser(Configuration configuration, ResourceProvider resourceProvider, ParsingContext parsingContext) {
        return null;
    }
}
