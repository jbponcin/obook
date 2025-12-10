package com.example.calibreapi.config;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.community.dialect.SQLiteDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class CustomSQLiteDialect extends SQLiteDialect {

    @Override
    public void contributeFunctions(FunctionContributions functionContributions) {
        super.contributeFunctions(functionContributions);
        functionContributions.getFunctionRegistry().register(
                "sortconcat",
                new StandardSQLFunction("sortconcat", StandardBasicTypes.STRING)
        );
        functionContributions.getFunctionRegistry().register(
                "title_sort",
                new StandardSQLFunction("title_sort", StandardBasicTypes.STRING)
        );
    }
}
