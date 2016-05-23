package net.brainage.mybatis.spring.transaction;

import net.brainage.SpringMybatisManualTransactionApplication;
import net.brainage.example.mapper.DepartmentMapper;
import net.brainage.example.mapper.EmployeeMapper;
import net.brainage.example.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ms29.seo on 2016-05-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringMybatisManualTransactionApplication.class)
public class TransactionTest {

    @Autowired
    TransactionFactory transactionFactory;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void testTransaction() throws DataAccessException {
        Transaction tx = transactionFactory.create();
        tx.start();
        try {
            Department department = new Department(90, "SM운영그룹", "서울");
            departmentMapper.insert(department);
            tx.commit();
        } finally {
            tx.end();
        }
    }

}
