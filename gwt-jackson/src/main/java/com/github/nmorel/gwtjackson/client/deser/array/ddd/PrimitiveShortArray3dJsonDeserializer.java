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

import java.util.List;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.ShortJsonDeserializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;

/**
 * Default {@link JsonDeserializer} implementation for 3D array of short.
 *
 * @author Nicolas Morel
 */
public class PrimitiveShortArray3dJsonDeserializer extends AbstractArray3dJsonDeserializer<short[][][]> {

    private static final PrimitiveShortArray3dJsonDeserializer INSTANCE = new PrimitiveShortArray3dJsonDeserializer();

    /**
     * @return an instance of {@link PrimitiveShortArray2dJsonDeserializer}
     */
    public static PrimitiveShortArray3dJsonDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveShortArray3dJsonDeserializer() { }

    @Override
    public short[][][] doDeserialize( JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params ) {
        List<List<List<Short>>> list3d = AbstractArray3dJsonDeserializer.deserializeInto3dList( reader, ctx, ShortJsonDeserializer.getInstance(), params );

        short[][][] array = new short[list3d.size()][][];
        for ( int i = 0; i < list3d.size(); i++ ) {
        	List<List<Short>> list2d = list3d.get(i);
        	array[i] = new short[list2d.size()][];
        	for ( int j = 0; j < list2d.size(); j++ ) {
        		List<Short> list1d = list2d.get(j);
        		array[i][j] = new short[list1d.size()];
        		for ( int k = 0; k < list1d.size(); k++ )
        		{
        			Short value = list1d.get(k);
        			if ( null != value ) {
        				array[i][j][k] = value;
        			}
        		}
        	}
        }

        return array;
    }
}
