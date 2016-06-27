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
import com.github.nmorel.gwtjackson.client.deser.CharacterJsonDeserializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;
import com.github.nmorel.gwtjackson.client.stream.JsonToken;

/**
 * Default {@link JsonDeserializer} implementation for 3D array of char.
 *
 * @author Nicolas Morel
 */
public class PrimitiveCharacterArray3dJsonDeserializer extends AbstractArray3dJsonDeserializer<char[][][]> {

    private static final PrimitiveCharacterArray3dJsonDeserializer INSTANCE = new PrimitiveCharacterArray3dJsonDeserializer();

    /**
     * @return an instance of {@link PrimitiveCharacterArray2dJsonDeserializer}
     */
    public static PrimitiveCharacterArray3dJsonDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveCharacterArray3dJsonDeserializer() { }

    @Override
    public char[][][] doDeserialize( JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params ) {
        return new char[0][][];
    }
}
