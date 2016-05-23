/*
 * (#) net.brainage.example.mapper.EmployeeMapperTest.java
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

import net.brainage.SpringMybatisManualTransactionApplication;
import net.brainage.example.model.Department;
import net.brainage.example.model.Employee;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author <a href="mailto:ms29.seo+ara@gmail.com">ms29.seo</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringMybatisManualTransactionApplication.class)
@Transactional
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void findAllEmployees() {
        List<Employee> emps = employeeMapper.findAll();
        assertThat(emps.size(), is(12));
        emps.stream().forEach(System.out::println);
    }

    @Test
    public void testFindOne() {
        int id = 7566;
        Employee employee = employeeMapper.findOne(id);
        Department department = employee.getDepartment();
        int deptId = department.getId();
        assertThat(deptId, is(20));
        System.out.println("employee: " + employee + " => " + department);
        System.out.println("manager: " + employee.getManager() + " => " + employee.getManager().getDepartment());
    }

}
