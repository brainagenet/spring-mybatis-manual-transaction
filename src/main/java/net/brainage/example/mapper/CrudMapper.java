/*
 * (#) net.brainage.example.mapper.CrudMapper.java
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

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author <a href="mailto:ms29.seo+ara@gmail.com">ms29.seo</a>
 */
@Mapper
public interface CrudMapper<T, K> {

    T findOne(K key);

    List<T> findAll();

    void insert(T obj);

    void update(T obj);

    int delete(K key);

}
