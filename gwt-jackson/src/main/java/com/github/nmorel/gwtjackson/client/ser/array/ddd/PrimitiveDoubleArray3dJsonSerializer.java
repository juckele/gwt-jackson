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
 * Default {@link JsonSerializer} implementation for 3D array of double.
 *
 * @author Nicolas Morel
 */
public class PrimitiveDoubleArray3dJsonSerializer extends JsonSerializer<double[][][]> {

    private static final PrimitiveDoubleArray3dJsonSerializer INSTANCE = new PrimitiveDoubleArray3dJsonSerializer();

    /**
     * @return an instance of {@link PrimitiveDoubleArray3dJsonSerializer}
     */
    public static PrimitiveDoubleArray3dJsonSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveDoubleArray3dJsonSerializer() { }

    @Override
    protected boolean isEmpty( @Nullable double[][][] value ) {
        return null == value || value.length == 0;
    }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull double[][][] values, JsonSerializationContext ctx,
                             JsonSerializerParameters params ) {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        writer.beginArray();
        for ( double[][] array2d : values ) {
            writer.beginArray();
            for ( double[] array : array2d ) {
                writer.beginArray();
                for ( double value : array ) {
                    writer.value( value );
                }
                writer.endArray();
            }
            writer.endArray();
        }
        writer.endArray();
    }
}
