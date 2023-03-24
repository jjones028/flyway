package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.internal.database.base.Database;
import org.flywaydb.core.internal.database.base.Schema;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;

import java.sql.SQLException;

public class IrisSchema extends Schema {
    /**
     * @param jdbcTemplate The Jdbc Template for communicating with the DB.
     * @param database     The database-specific support.
     * @param name         The name of the schema.
     */
    public IrisSchema(JdbcTemplate jdbcTemplate, Database database, String name) {
        super(jdbcTemplate, database, name);
    }

    @Override
    protected boolean doExists() throws SQLException {
        return false;
    }

    @Override
    protected boolean doEmpty() throws SQLException {
        return false;
    }

    @Override
    protected void doCreate() throws SQLException {

    }

    @Override
    protected void doDrop() throws SQLException {

    }

    @Override
    protected void doClean() throws SQLException {

    }

    @Override
    protected Table[] doAllTables() throws SQLException {
        return new Table[0];
    }

    @Override
    public Table getTable(String tableName) {
        return null;
    }
}
