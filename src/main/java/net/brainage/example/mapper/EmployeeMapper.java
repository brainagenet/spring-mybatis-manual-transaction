/*
 * (#) net.brainage.example.mapper.EmployeeMapper.java
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
import net.brainage.example.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author <a href="mailto:ms29.seo+ara@gmail.com">ms29.seo</a>
 */
public interface EmployeeMapper extends CrudMapper<Employee, Integer> {

    @Select("SELECT EMPNO, DEPTNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM FROM EMP WHERE EMPNO = #{id}")
    @Results({
            @Result(property = "id", column = "EMPNO"),
            @Result(property = "departmentId", column = "DEPTNO"),
            @Result(property = "department", column = "DEPTNO", javaType = Department.class,
                    one = @One(select = "net.brainage.example.mapper.DepartmentMapper.findOne")),
            @Result(property = "name", column = "ENAME"),
            @Result(property = "job", column = "JOB"),
            @Result(property = "managerId", column = "MGR"),
            @Result(property = "manager", column = "MGR", javaType = Employee.class,
                    one = @One(select = "net.brainage.example.mapper.EmployeeMapper.findOne")),
            @Result(property = "hireDate", column = "HIREDATE"),
            @Result(property = "salary", column = "SAL"),
            @Result(property = "commissionPercent", column = "COMM")
    })
    @Override
    Employee findOne(Integer key);

    @Select("SELECT EMPNO, DEPTNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM FROM EMP")
    @Results({
            @Result(property = "id", column = "EMPNO"),
            @Result(property = "departmentId", column = "DEPTNO"),
            @Result(property = "name", column = "ENAME"),
            @Result(property = "job", column = "JOB"),
            @Result(property = "managerId", column = "MGR"),
            @Result(property = "hireDate", column = "HIREDATE"),
            @Result(property = "salary", column = "SAL"),
            @Result(property = "commissionPercent", column = "COMM")
    })
    @Override
    List<Employee> findAll();

    @Insert("INSERT INTO EMP (EMPNO, DEPTNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM) " +
            "VALUES (#{id}, #{departmentId}, #{name}, #{job}, #{managerId}, #{hireDate}, #{salary}, #{commissionPercent})")
    @Override
    void insert(Employee emp);

    @Update("UPDATE EMP " +
            "SET DEPTNO = #{departmentId}, " +
            "ENAME = #{name}, " +
            "JOB = #{job}, MGR = #{managerId}, " +
            "HIREDATE = #{hireDate}, SAL = #{salary}, " +
            "COMM = #{commissionPercent} " +
            "WHERE EMPNO = #{id}")
    @Override
    void update(Employee emp);

    @Delete("DELETE FROM EMP WHERE EMPNO = #{id}")
    @Override
    int delete(@Param("id") Integer id);

}
