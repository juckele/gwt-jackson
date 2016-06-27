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
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.FloatJsonDeserializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;

/**
 * Default {@link JsonDeserializer} implementation for 3D array of float.
 *
 * @author Nicolas Morel
 */
public class PrimitiveFloatArray3dJsonDeserializer extends AbstractArray3dJsonDeserializer<float[][][]> {

    private static final PrimitiveFloatArray3dJsonDeserializer INSTANCE = new PrimitiveFloatArray3dJsonDeserializer();

    /**
     * @return an instance of {@link PrimitiveFloatArray2dJsonDeserializer}
     */
    public static PrimitiveFloatArray3dJsonDeserializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveFloatArray3dJsonDeserializer() { }

    @Override
    public float[][][] doDeserialize( JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params ) {
        List<List<List<Float>>> list3d = AbstractArray3dJsonDeserializer.deserializeInto3dList( reader, ctx, FloatJsonDeserializer.getInstance(), params );

        float[][][] array = new float[list3d.size()][][];
        for ( int i = 0; i < list3d.size(); i++ ) {
        	List<List<Float>> list2d = list3d.get(i);
        	array[i] = new float[list2d.size()][];
        	for ( int j = 0; j < list2d.size(); j++ ) {
        		List<Float> list1d = list2d.get(j);
        		array[i][j] = new float[list1d.size()];
        		for ( int k = 0; k < list1d.size(); k++ )
        		{
        			Float value = list1d.get(k);
        			if ( null != value ) {
        				array[i][j][k] = value;
        			}
        		}
        	}
        }

        return array;

    }
}
