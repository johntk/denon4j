/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.theves.denon4j;

import io.theves.denon4j.controls.Control;

import java.util.Collection;

/**
 * Represents an audio/video receiver.
 *
 * @author stheves
 */
public interface Receiver extends AutoCloseable {
    /**
     * Sends the command to the receiver.
     *
     * @param command the command to send.
     * @return the response or <code>null</code> for request commands ending with '?' e.g. 'PW?'.
     */
    String send(String command);

    /**
     * Returns a collection of all available controls.
     *
     * @return a collection of all controls.
     */
    Collection<Control> getControls();

    @Override
    void close();
}