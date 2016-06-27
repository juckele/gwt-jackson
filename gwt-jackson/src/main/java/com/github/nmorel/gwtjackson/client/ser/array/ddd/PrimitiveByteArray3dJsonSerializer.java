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
import com.github.nmorel.gwtjackson.client.utils.Base64Utils;

/**
 * Default {@link JsonSerializer} implementation for 3D array of byte.
 *
 * @author Nicolas Morel
 */
public class PrimitiveByteArray3dJsonSerializer extends JsonSerializer<byte[][][]> {

    private static final PrimitiveByteArray3dJsonSerializer INSTANCE = new PrimitiveByteArray3dJsonSerializer();

    /**
     * @return an instance of {@link PrimitiveByteArray3dJsonSerializer}
     */
    public static PrimitiveByteArray3dJsonSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveByteArray3dJsonSerializer() { }

    @Override
    protected boolean isEmpty( @Nullable byte[][][] value ) {
        return null == value || value.length == 0;
    }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull byte[][][] values, JsonSerializationContext ctx, JsonSerializerParameters params ) {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        writer.beginArray();
        for ( byte[][] array2d : values ) {
            writer.beginArray();
            for ( byte[] array : array2d ) {
                writer.unescapeValue( Base64Utils.toBase64( array ) );
            }
            writer.endArray();
        }
        writer.endArray();
    }
}
