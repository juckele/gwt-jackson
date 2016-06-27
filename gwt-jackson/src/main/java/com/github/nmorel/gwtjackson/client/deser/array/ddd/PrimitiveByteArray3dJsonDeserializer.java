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
import java.util.List;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.ByteJsonDeserializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;
import com.github.nmorel.gwtjackson.client.stream.JsonToken;
import com.github.nmorel.gwtjackson.client.utils.Base64Utils;

/**
 * Default {@link JsonDeserializer} implementation for 3D array of byte.
 *
 * @author Nicolas Morel
 */
public class PrimitiveByteArray3dJsonDeserializer extends AbstractArray3dJsonDeserializer<byte[][][]> {

    private static final PrimitiveByteArray3dJsonDeserializer INSTANCE = new PrimitiveByteArray3dJsonDeserializer();

    /**
     * @return an instance of {@link PrimitiveByteArray2dJsonDeserializer}
     */
    public static PrimitiveByteArray3dJsonDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveByteArray3dJsonDeserializer() { }

    @Override
    public byte[][][] doDeserialize( JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params ) {
    	return new byte[0][][];
    }
}
