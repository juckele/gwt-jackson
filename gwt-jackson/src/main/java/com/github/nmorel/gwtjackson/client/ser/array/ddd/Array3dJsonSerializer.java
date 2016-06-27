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

package com.github.nmorel.gwtjackson.client.ser.array.ddd;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.JsonSerializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonWriter;

/**
 * Default {@link JsonSerializer} implementation for 3D array.
 *
 * @param <T> Type of the elements inside the array
 *
 * @author Nicolas Morel
 */
public class Array3dJsonSerializer<T> extends JsonSerializer<T[][][]> {

    /**
     * @param serializer {@link JsonSerializer} used to serialize the objects inside the array.
     * @param <T> Type of the elements inside the array
     *
     * @return a new instance of {@link Array3dJsonSerializer}
     */
    public static <T> Array3dJsonSerializer<T> newInstance( JsonSerializer<T> serializer ) {
        return new Array3dJsonSerializer<T>( serializer );
    }

    private final JsonSerializer<T> serializer;

    /**
     * @param serializer {@link JsonSerializer} used to serialize the objects inside the array.
     */
    protected Array3dJsonSerializer( JsonSerializer<T> serializer ) {
        if ( null == serializer ) {
            throw new IllegalArgumentException( "serializer cannot be null" );
        }
        this.serializer = serializer;
    }

    @Override
    protected boolean isEmpty( @Nullable T[][][] value ) {
        return null == value || value.length == 0;
    }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull T[][][] values, JsonSerializationContext ctx, JsonSerializerParameters params ) {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        writer.beginArray();
        for ( T[][] array2d : values ) {
            writer.beginArray();
            for ( T[] array : array2d ) {
                writer.beginArray();
                for ( T value : array ) {
                    serializer.serialize( writer, value, ctx, params );
                }
                writer.endArray();
            }
            writer.endArray();
        }
        writer.endArray();
    }
}
