/*
 * Copyright 2023 Ververica Inc.
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

package com.ververica.cdc.connectors.mysql.source.listener;

import org.apache.flink.annotation.Experimental;

import com.ververica.cdc.connectors.mysql.source.assigners.AssignerStatus;

import java.io.Serializable;
import java.util.Properties;

/** The listener interface for receiving external system events. */
@Experimental
public interface ExternalSystemListener extends Serializable {

    /** The identified name of the listener. */
    String name();

    /** Initialize the listener with the given properties. */
    void init(Properties properties);

    /** Send the given event to the external system. */
    void send(AssignerStatus assignerStatus, ListenerMessageInformation listenerMessageInformation);

    /** Close the listener. */
    void close();
}
