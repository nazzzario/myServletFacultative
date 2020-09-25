package com.krasn.facultative.models.dao;

import java.sql.ResultSet;

public interface EntityMapper<T> {
    T mapRow(ResultSet rs);
}
