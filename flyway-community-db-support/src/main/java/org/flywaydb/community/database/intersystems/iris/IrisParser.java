package org.flywaydb.community.database.intersystems.iris;

import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.internal.parser.Parser;
import org.flywaydb.core.internal.parser.ParsingContext;

public class IrisParser extends Parser {
    protected IrisParser(Configuration configuration, ParsingContext parsingContext, int peekDepth) {
        super(configuration, parsingContext, peekDepth);
    }
}
