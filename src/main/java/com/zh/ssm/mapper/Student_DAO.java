package com.zh.ssm.mapper;

import com.zh.ssm.entity.StudentEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_DAO {
    public StudentEntity selectAll();
}
