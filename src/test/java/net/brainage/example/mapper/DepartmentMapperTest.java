package net.brainage.example.mapper;

import net.brainage.SpringMybatisManualTransactionApplication;
import net.brainage.example.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringMybatisManualTransactionApplication.class)
public class DepartmentMapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void testFindOne() {
        int id = 20;
        Department dept = departmentMapper.findOne(id);
        System.out.println(dept);
    }

}
