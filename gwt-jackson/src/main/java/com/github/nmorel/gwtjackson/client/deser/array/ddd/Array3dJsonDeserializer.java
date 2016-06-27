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

import java.util.AbstractCollection;
import java.util.List;

import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonDeserializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;

/**
 * Default {@link JsonDeserializer} implementation for 3D array.
 *
 * @author Nicolas Morel
 */
public class Array3dJsonDeserializer<T> extends AbstractArray3dJsonDeserializer<T[][][]> {

    public interface Array3dCreator<T> {

        T[][][] create( int first, int second, int third );
    }

    /**
     * @param deserializer {@link JsonDeserializer} used to deserialize the objects inside the array.
     * @param arrayCreator {@link Array3dCreator} used to create a new array
     * @param <T> Type of the elements inside the {@link AbstractCollection}
     *
     * @return a new instance of {@link Array3dJsonDeserializer}
     */
    public static <T> Array3dJsonDeserializer<T> newInstance( JsonDeserializer<T> deserializer, Array3dCreator<T> arrayCreator ) {
        return new Array3dJsonDeserializer<T>( deserializer, arrayCreator );
    }

    private final JsonDeserializer<T> deserializer;

    private final Array3dCreator<T> array3dCreator;

    /**
     * @param deserializer {@link JsonDeserializer} used to deserialize the objects inside the array.
     * @param array3dCreator {@link Array3dCreator} used to create a new array
     */
    protected Array3dJsonDeserializer( JsonDeserializer<T> deserializer, Array3dCreator<T> array3dCreator ) {
        if ( null == deserializer ) {
            throw new IllegalArgumentException( "deserializer cannot be null" );
        }
        if ( null == array3dCreator ) {
            throw new IllegalArgumentException( "Cannot deserialize an array without an array3dCreator" );
        }
        this.deserializer = deserializer;
        this.array3dCreator = array3dCreator;
    }

    @Override
    protected T[][][] doDeserialize( JsonReader reader, JsonDeserializationContext ctx, JsonDeserializerParameters params ) {
        List<List<List<T>>> list3d = AbstractArray3dJsonDeserializer.deserializeInto3dList( reader, ctx, deserializer, params );

        if ( list3d.isEmpty() ) {
            return array3dCreator.create( 0, 0, 0 );
        }

        List<List<T>> firstList2d = list3d.get( 0 );
        if ( firstList2d.isEmpty() ) {
            return array3dCreator.create( list3d.size(), 0, 0 );
        }

        List<T> firstList1d = firstList2d.get( 0 );
        if ( firstList1d.isEmpty() ) {
            return array3dCreator.create( list3d.size(), firstList2d.size(), 0 );
        }

        T[][][] array = array3dCreator.create( list3d.size(), firstList2d.size(), firstList1d.size() );

        int i = 0;
        for ( List<List<T>> list2d : list3d ) {
	int j = 0;
	    for ( List<T> list1d : list2d ) {
              array[i][j] = list1d.toArray( array[i][j] );
	      j++;
	    }
            i++;
        }
        return array;
    }

    @Override
    public void setBackReference( String referenceName, Object reference, T[][][] value, JsonDeserializationContext ctx ) {
        if ( null != value && value.length > 0 ) {
            for ( T[][] array2d : value ) {
                for ( T[] array : array2d ) {
                    for ( T val : array ) {
                        deserializer.setBackReference( referenceName, reference, val, ctx );
                    }
                }
	    }
        }
    }
}
