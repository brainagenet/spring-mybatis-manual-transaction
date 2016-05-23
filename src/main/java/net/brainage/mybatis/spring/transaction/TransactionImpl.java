/*
 * (#) net.brainage.mybatis.spring.transaction.TransactionImpl.java
 * Created on 2016-05-16
 */
package net.brainage.mybatis.spring.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author <a href="mailto:ms29.seo@gmail.com">ms29.seo</a>
 */
@Slf4j
public class TransactionImpl implements Transaction {

    private static final AtomicLong TX_SEQ = new AtomicLong(System.currentTimeMillis());

    private final PlatformTransactionManager transactionManager;

    private DefaultTransactionDefinition transactionDefinition;

    private TransactionStatus status;

    public TransactionImpl(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.transactionDefinition = new DefaultTransactionDefinition();
        this.transactionDefinition.setName("ban-tx-" + TX_SEQ.incrementAndGet());
    }

    public void setPropagationBehavior(int propagationBehavior) {
        transactionDefinition.setPropagationBehavior(propagationBehavior);
    }

    public void setIsolationLevel(int isolationLevel) {
        transactionDefinition.setIsolationLevel(isolationLevel);
    }

    public void setReadOnly(boolean readOnly) {
        transactionDefinition.setReadOnly(readOnly);
    }

    @Override
    public void start() {
        log.info("start transaction for {}", this.transactionDefinition.getName());
        status = transactionManager.getTransaction(transactionDefinition);
        log.debug("  - " + status.toString());
    }

    @Override
    public void commit() {
        if (!status.isCompleted()) {
            log.info("commit transaction for {}", this.transactionDefinition.getName());
            transactionManager.commit(status);
        }
    }

    @Override
    public void rollback() {
        if (!status.isCompleted()) {
            log.info("rollback transaction for {}", this.transactionDefinition.getName());
            transactionManager.rollback(status);
        }
    }

    @Override
    public void end() {
        rollback();
        log.info("end transaction for {}", this.transactionDefinition.getName());
    }

}
