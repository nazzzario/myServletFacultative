package com.krasn.facultative.dao.entity.impl;

import com.krasn.facultative.dao.Query;
import com.krasn.facultative.dao.entity.SubjectDao;
import com.krasn.facultative.domain.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl extends AbstractDao<Subject, Long>  implements SubjectDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectDaoImpl.class.getName());

    @Override
    protected String getInsertQuery() {
        return null;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Subject object) {
        try {
            stmt.setString(1, object.getSubjectName());
        } catch (SQLException e) {
            LOGGER.error("Exception while preparing statement for create.\n", e);
        }
    }

    @Override
    protected List<Subject> parseResultSet(ResultSet rs) {
        List<Subject> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getLong("subject_id"));
                subject.setSubjectName(rs.getString("subject_name"));
                list.add(subject);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while parsing result set.\n", e);
        }
        return list;
    }

    @Override
    protected String getSelectByIdQuery() {
        return null;
    }

    @Override
    protected String getSelectAllQuery() {
        return Query.SELECT_ALL_SUBJECTS;
    }

    @Override
    protected String getLastInsertId() {
        return Query.SELECT_LAST_INSERT_COURSE;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Subject object) {
        try {
            stmt.setString(1, object.getSubjectName());
            stmt.setLong(2, object.getId());
        } catch (SQLException e) {
            LOGGER.error("Exception while preparing statement for update.\n", e);
        }
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

    @Override
    public Subject create(Subject object) {
        return null;
    }

    @Override
    public Subject get(Long key) {
        return null;
    }


    @Override
    public void update(Subject object) {

    }

    @Override
    public void delete(Subject object) {

    }
}
