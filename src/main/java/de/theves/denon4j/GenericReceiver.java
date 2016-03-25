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

package de.theves.denon4j;

/**
 * Class description.
 *
 * @author Sascha Theves
 */
public class GenericReceiver extends AbstractAvReceiver {
    public GenericReceiver(String hostname, int port, int readTimeout) {
        super(hostname, port, readTimeout);
    }

    /**
     * Sends the <code>command</code> with <code>parameter</code> and <code>value</code> to the receiver.
     * Waits <code>readTimeout</code> ms for receiving the response.
     *
     * @param command   the command (not <code>null</code>).
     * @param parameter the parameter (may be <code>null</code>).
     * @param value     the value to send (may be <code>null</code>).
     * @return the plain response bytes received within <code>readTimeout</code>.
     */
    public Response send(Commands command, Parameters parameter, String value) {
        return super.send(command, parameter, value);
    }
}