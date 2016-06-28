/*
 * Copyright 2013 Nicolas Morel
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

package com.github.nmorel.gwtjackson.client.ser;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;
import com.github.nmorel.gwtjackson.client.stream.JsonWriter;

/**
 * @author Nicolas Morel
 */
public abstract class AbstractJsonSerializerTest<T> extends GwtJacksonTestCase {

    protected abstract JsonSerializer<T> createSerializer();
    protected JsonDeserializer<T> createDeserializer() {
    	throw new UnsupportedOperationException("Required for deserialization tests.");
    }

    public void testSerializeNullValue() {
        assertSerialization( "null", null );
    }

    protected String serialize( T value ) {
        JsonSerializationContext ctx = JsonSerializationContext.builder().build();
        JsonWriter writer = ctx.newJsonWriter();
        createSerializer().serialize( writer, value, ctx );
        return writer.getOutput();
    }

    protected T deserialize( String value ) {
    	JsonDeserializationContext ctx = JsonDeserializationContext.builder().build();
        JsonReader reader = ctx.newJsonReader(value);
    	T result = createDeserializer().deserialize(reader, ctx);
        return result;
    }

    protected void assertSerialization( String expected, T value ) {
        assertEquals( expected, serialize( value ) );
    }

    public abstract void testSerializeValue();
}
