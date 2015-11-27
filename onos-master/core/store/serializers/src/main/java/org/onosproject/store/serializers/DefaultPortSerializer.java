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
package org.onosproject.store.serializers;

import org.onosproject.net.DefaultPort;
import org.onosproject.net.Element;
import org.onosproject.net.PortNumber;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * Kryo Serializer for {@link DefaultPort}.
 */
public final class DefaultPortSerializer extends
        Serializer<DefaultPort> {

    /**
     * Creates {@link DefaultPort} serializer instance.
     */
    public DefaultPortSerializer() {
        // non-null, immutable
        super(false, true);
    }

    @Override
    public void write(Kryo kryo, Output output, DefaultPort object) {
        kryo.writeClassAndObject(output, object.element());
        kryo.writeObject(output, object.number());
        output.writeBoolean(object.isEnabled());
    }

    @Override
    public DefaultPort read(Kryo kryo, Input input,
            Class<DefaultPort> type) {
        Element element = (Element) kryo.readClassAndObject(input);
        PortNumber number = kryo.readObject(input, PortNumber.class);
        boolean isEnabled = input.readBoolean();

        return new DefaultPort(element, number, isEnabled);
    }
}
