/*
 * (#) net.brainage.mybatis.spring.transaction.TransactionFactory.java
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
package net.brainage.mybatis.spring.transaction;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.util.Assert;

/**
 * @author <a href="mailto:ms29.seo+ara@gmail.com">ms29.seo</a>
 */
@Component
public class TransactionFactory implements InitializingBean {

    @Autowired
    PlatformTransactionManager transactionManager;

    public Transaction create() {
        TransactionImpl tx = new TransactionImpl(transactionManager);
        tx.setIsolationLevel(Isolation.READ_COMMITTED.value());
        tx.setPropagationBehavior(Propagation.REQUIRED.value());
        return tx;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(transactionManager);
    }

}
