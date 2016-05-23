/*
 * (#) net.brainage.example.mapper.DepartmentMapper.java
 * Created on 2016-05-23
 *
 * Copyright 2015 brainage.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package net.brainage.example.mapper;

import net.brainage.example.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author <a href="mailto:ms29.seo+ara@gmail.com">ms29.seo</a>
 */
public interface DepartmentMapper extends CrudMapper<Department, Integer> {

    @Select("SELECT DEPTNO, DNAME, LOC FROM DEPT WHERE DEPTNO = #{id}")
    @Results({
            @Result(property = "id", column = "DEPTNO"),
            @Result(property = "name", column = "DNAME"),
            @Result(property = "location", column = "LOC")
    })
    @Override
    Department findOne(Integer id);

    @Select("SELECT DEPTNO, DNAME, LOC FROM DEPT")
    @Results({
            @Result(property = "id", column = "DEPTNO"),
            @Result(property = "name", column = "DNAME"),
            @Result(property = "location", column = "LOC")
    })
    @Override
    List<Department> findAll();

    @Insert("INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (#{id}, #{name}, #{location})")
    @Override
    void insert(Department dept);

    @Update("UPDATE DEPT SET DNAME = #{name}, LOC = #{location} WHERE DEPTNO = #{id}")
    @Override
    void update(Department dept);

    @Delete("DELETE FROM DEPT WHERE DEPTNO = #{id}")
    @Override
    int delete(Integer id);

}
