package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.internal.database.base.Connection;
import org.flywaydb.core.internal.database.base.Schema;

import java.sql.SQLException;

public class IrisConnection extends Connection<IrisDatabase> {
    protected IrisConnection(IrisDatabase database, java.sql.Connection connection) {
        super(database, connection);
    }

    @Override
    protected String getCurrentSchemaNameOrSearchPath() throws SQLException {
        return null;
    }

    @Override
    public Schema getSchema(String name) {
        return null;
    }
}
