/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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

package org.wildfly.security.auth.jaspi.impl;

import static java.lang.System.getSecurityManager;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;

/**
 * Wrapper around {@link AccessController#doPrivileged(PrivilegedAction)} for the 'org.wildfly.extension.elytron' package.
 *
 * @author <a href="mailto:darran.lofthouse@jboss.com">Darran Lofthouse</a>
 */
final class SecurityActions {

    static <T> T doPrivileged(final PrivilegedAction<T> action) {
        return getSecurityManager() != null ? AccessController.doPrivileged(action) : action.run();
    }

    static <T> T doPrivileged(final PrivilegedExceptionAction<T> action) throws Exception {
        return getSecurityManager() != null ? AccessController.doPrivileged(action) : action.run();
    }

}
