/*
 * Copyright 2014 Nicolas Morel
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

package com.github.nmorel.gwtjackson.client.deser.array.ddd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;
import com.github.nmorel.gwtjackson.client.stream.JsonToken;

/**
 * Base implementation of {@link JsonDeserializer} for 3D array.
 *
 * @author Nicolas Morel
 */
public abstract class AbstractArray3dJsonDeserializer<T> extends JsonDeserializer<T> {

    /**
     * Deserializes the array into a {@link List}. We need the length of the array before creating it.
     *
     * @param reader reader
     * @param ctx context of the deserialization process
     * @param deserializer deserializer for element inside the array
     * @param params Parameters for the deserializer
     * @param <C> type of the element inside the array
     *
     * @return a list containing all the elements of the array
     */
    public static <C> List<List<List<C>>> deserializeInto3dList( JsonReader reader, JsonDeserializationContext ctx, JsonDeserializer<C> deserializer,
                                                     JsonDeserializerParameters params ) {

    	List<List<List<C>>> list3d = new ArrayList<List<List<C>>>();
        reader.beginArray();
        JsonToken token = reader.peek();
        while ( JsonToken.END_ARRAY != token ) {

            List<List<C>> list2d = new ArrayList<List<C>>();
            reader.beginArray();
            JsonToken innerToken = reader.peek();
            while ( JsonToken.END_ARRAY != innerToken ) {

            	List<C> list1d = new ArrayList<C>();
                reader.beginArray();
                JsonToken token1d = reader.peek();

                while ( JsonToken.END_ARRAY != token1d ) {
                    list1d.add( deserializer.deserialize( reader, ctx, params ) );
                    token1d = reader.peek();
                }
                reader.endArray();
                list2d.add(list1d);

                innerToken = reader.peek();
            }
            reader.endArray();
            list3d.add( list2d );

            token = reader.peek();
        }
        return list3d;
    }
}
