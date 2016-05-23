/*
 * (#) net.brainage.example.model.Employee.java
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
package net.brainage.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:ms29.seo+ara@gmail.com">ms29.seo</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"department", "manager"})
@ToString(exclude = {"department", "manager"})
public class Employee implements Serializable {

    private static final long serialVersionUID = 5328317923631023582L;

    private int id;

    private String name;

    private String job;

    private int managerId;
    private Employee manager;

    private Date hireDate;

    private int salary;

    private int commissionPercent;

    private int departmentId;
    private Department department;

}
