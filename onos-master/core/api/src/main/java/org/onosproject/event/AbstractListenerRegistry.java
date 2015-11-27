/*
 * Copyright 2014 Open Networking Laboratory
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
package org.onosproject.event;

import org.slf4j.Logger;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Base implementation of an event sink and a registry capable of tracking
 * listeners and dispatching events to them as part of event sink processing.
 */
public class AbstractListenerRegistry<E extends Event, L extends EventListener<E>>
        implements EventSink<E> {

    private final Logger log = getLogger(getClass());

    private final Set<L> listeners = new CopyOnWriteArraySet<>();
    private volatile boolean shutdown = false;

    /**
     * Adds the specified listener.
     *
     * @param listener listener to be added
     */
    public void addListener(L listener) {
        checkNotNull(listener, "Listener cannot be null");
        listeners.add(listener);
    }

    /**
     * Removes the specified listener.
     *
     * @param listener listener to be removed
     */
    public void removeListener(L listener) {
        checkNotNull(listener, "Listener cannot be null");
        checkArgument(listeners.remove(listener), "Listener not registered");
    }

    @Override
    public void process(E event) {
        for (L listener : listeners) {
            try {
                listener.event(event);
            } catch (Exception error) {
                reportProblem(event, error);
            }
        }
    }

    /**
     * Reports a problem encountered while processing an event.
     *
     * @param event event being processed
     * @param error error encountered while processing
     */
    protected void reportProblem(E event, Throwable error) {
        if (!shutdown) {
            log.warn("Exception encountered while processing event " + event, error);
        }
    }

    /**
     * Prepares the registry for normal operation.
     */
    public void activate() {
        shutdown = false;
    }

    /**
     * Prepares the registry for shutdown.
     */
    public void deactivate() {
        shutdown = true;
    }


}
