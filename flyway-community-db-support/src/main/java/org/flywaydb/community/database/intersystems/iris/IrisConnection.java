package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.internal.database.base.Connection;
import org.flywaydb.core.internal.database.base.Schema;

public class IrisConnection extends Connection<IrisDatabase> {
    protected IrisConnection(IrisDatabase database, java.sql.Connection connection) {
        super(database, connection);
    }

    @Override
    protected String getCurrentSchemaNameOrSearchPath() {
        return "SQLUser";
    }

    @Override
    public Schema getSchema(String name) {
        return new IrisSchema(jdbcTemplate, database, name);
    }
}
