package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.internal.database.base.Connection;
import org.flywaydb.core.internal.database.base.Database;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcConnectionFactory;
import org.flywaydb.core.internal.jdbc.StatementInterceptor;

public class IrisDatabase extends Database {
    public IrisDatabase(Configuration configuration, JdbcConnectionFactory jdbcConnectionFactory, StatementInterceptor statementInterceptor) {
        super(configuration, jdbcConnectionFactory, statementInterceptor);
    }

    @Override
    protected Connection doGetConnection(java.sql.Connection connection) {
        return new IrisConnection(this, connection);
    }

    @Override
    public void ensureSupported() {

    }

    @Override
    public boolean supportsDdlTransactions() {
        return false;
    }

    @Override
    public String getBooleanTrue() {
        return null;
    }

    @Override
    public String getBooleanFalse() {
        return null;
    }

    @Override
    public boolean catalogIsSchema() {
        return false;
    }

    @Override
    public String getRawCreateScript(Table table, boolean baseline) {
        return null;
    }
}
