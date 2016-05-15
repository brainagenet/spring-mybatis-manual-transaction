package net.brainage.mybatis.spring.transaction;

/**
 * Created by ms29.seo on 2016-05-16.
 */
public interface Transaction {

    void start();

    void commit();

    void rollback();

    void end();

}
