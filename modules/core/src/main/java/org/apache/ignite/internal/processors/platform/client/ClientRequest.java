/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.platform.client;

import org.apache.ignite.binary.BinaryRawReader;
import org.apache.ignite.internal.GridKernalContext;
import org.apache.ignite.internal.processors.odbc.SqlListenerRequest;

/**
 * Thin client request.
 */
public class ClientRequest extends SqlListenerRequest {
    /** Request id. */
    private final int requestId;

    /**
     * Ctor.
     *
     * @param reader Reader.
     */
    public ClientRequest(BinaryRawReader reader) {
        requestId = reader.readInt();
    }

    /**
     * Gets the request id.
     *
     * @return Data.
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Processes the request.
     *
     * @return Response.
     */
    public ClientResponse process(GridKernalContext ctx) {
        return new ClientResponse(requestId);
    }
}