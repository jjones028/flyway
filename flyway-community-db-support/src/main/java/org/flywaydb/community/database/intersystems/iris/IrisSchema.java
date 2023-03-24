package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.internal.database.base.Database;
import org.flywaydb.core.internal.database.base.Schema;
import org.flywaydb.core.internal.database.base.Table;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        return jdbcTemplate.queryForInt("SELECT %ROWLIMIT 1 COUNT(1) FROM information_schema.schemata WHERE schema_name=?", name) > 0;
    }

    @Override
    protected boolean doEmpty() throws SQLException {
        List<String> params = new ArrayList<>(Arrays.asList(name, name, name, name, name));
        return jdbcTemplate.queryForInt("SELECT SUM(found) FROM ("
                        + "(SELECT 1 as found FROM information_schema.tables WHERE table_schema=?) UNION ALL "
                        + "(SELECT 1 as found FROM information_schema.views WHERE table_schema=? LIMIT 1) UNION ALL "
                        + "(SELECT 1 as found FROM information_schema.table_constraints WHERE table_schema=? LIMIT 1) UNION ALL "
                        + "(SELECT 1 as found FROM information_schema.triggers WHERE event_object_schema=?  LIMIT 1) UNION ALL "
                        + "(SELECT 1 as found FROM information_schema.routines WHERE routine_schema=? LIMIT 1)"
                        + ") as all_found",
                params.toArray(new String[0])
        ) == 0;
    }

    @Override
    protected void doCreate() throws SQLException {
        jdbcTemplate.execute("CREATE SCHEMA " + database.quote(name));
    }

    @Override
    protected void doDrop() throws SQLException {
        jdbcTemplate.execute("DROP SCHEMA " + database.quote(name));
    }

    @Override
    protected void doClean() throws SQLException {

    }

    @Override
    protected Table[] doAllTables() throws SQLException {
        List<String> tableNames = jdbcTemplate.queryForStringList(
                "SELECT table_name FROM information_schema.tables WHERE table_schema=?" +
                        " AND table_type IN ('BASE TABLE', 'SYSTEM VERSIONED')", name);

        IrisTable[] tables = new IrisTable[tableNames.size()];
        for (int i = 0; i < tableNames.size(); i++) {
            tables[i] = new IrisTable(jdbcTemplate, database, this, tableNames.get(i));
        }
        return tables;
    }

    @Override
    public Table getTable(String tableName) {
        return new IrisTable(jdbcTemplate, database, this, tableName);
    }
}
