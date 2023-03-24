package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.internal.parser.Parser;
import org.flywaydb.core.internal.parser.ParsingContext;

public class IrisParser extends Parser {
    public IrisParser(Configuration configuration, ParsingContext parsingContext) {
        super(configuration, parsingContext, 3);
    }
}
