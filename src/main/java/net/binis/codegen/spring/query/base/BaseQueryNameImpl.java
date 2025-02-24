package net.binis.codegen.spring.query.base;

/*-
 * #%L
 * code-generator-spring
 * %%
 * Copyright (C) 2021 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import net.binis.codegen.spring.query.QueryBracket;
import net.binis.codegen.spring.query.QueryScript;
import net.binis.codegen.spring.query.executor.QueryExecutor;

public class BaseQueryNameImpl<T> implements QueryScript<T>, QueryBracket<T> {

    protected QueryExecutor executor;

    protected String name;

    public void setParent(String name, Object executor) {
        this.name = name;
        this.executor = (QueryExecutor) executor;
        this.executor.embedded(name);
    }

    @Override
    public T script(String script) {
        return (T) executor.script(script);
    }

    @Override
    public T _open() {
        return (T) executor._open();
    }


}
