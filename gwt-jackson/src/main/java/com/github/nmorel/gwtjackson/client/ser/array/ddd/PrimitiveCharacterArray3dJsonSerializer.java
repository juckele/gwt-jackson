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
 * Default {@link JsonSerializer} implementation for 3D array of char.
 *
 * @author Nicolas Morel
 */
public class PrimitiveCharacterArray3dJsonSerializer extends JsonSerializer<char[][][]> {

    private static final PrimitiveCharacterArray3dJsonSerializer INSTANCE = new PrimitiveCharacterArray3dJsonSerializer();

    /**
     * @return an instance of {@link PrimitiveCharacterArray3dJsonSerializer}
     */
    public static PrimitiveCharacterArray3dJsonSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveCharacterArray3dJsonSerializer() { }

    @Override
    protected boolean isEmpty( @Nullable char[][][] value ) {
        return null == value || value.length == 0;
    }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull char[][][] values, JsonSerializationContext ctx, JsonSerializerParameters params ) {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        writer.beginArray();
        for ( char[][] array2d : values ) {
            writer.beginArray();
            for ( char[] array : array2d ) {
                if ( ctx.isWriteCharArraysAsJsonArrays() ) {
                    writer.beginArray();
                    for ( char value : array ) {
                        writer.value( Character.toString( value ) );
                    }
                    writer.endArray();
                } else {
                    writer.value( new String( array ) );
                }
            }
            writer.endArray();
        }
        writer.endArray();

    }
}
