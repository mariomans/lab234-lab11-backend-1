package camt.se234.lab11.graphql;

import camt.se234.lab11.entity.Grade;
import camt.se234.lab11.service.GradeService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryGrade implements GraphQLQueryResolver {
    @Autowired
    GradeService gradeService;
}
