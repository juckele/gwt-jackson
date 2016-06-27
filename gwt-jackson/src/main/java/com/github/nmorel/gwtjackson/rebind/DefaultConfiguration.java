/*
 * Copyright 2013 Nicolas Morel
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

package com.github.nmorel.gwtjackson.rebind;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;

import com.github.nmorel.gwtjackson.client.AbstractConfiguration;
import com.github.nmorel.gwtjackson.client.deser.BaseDateJsonDeserializer.DateJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseDateJsonDeserializer.SqlDateJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseDateJsonDeserializer.SqlTimeJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseDateJsonDeserializer.SqlTimestampJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.BigDecimalJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.BigIntegerJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.ByteJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.DoubleJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.FloatJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.IntegerJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.LongJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.NumberJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BaseNumberJsonDeserializer.ShortJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.BooleanJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.CharacterJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.EnumJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.JavaScriptObjectJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.StringJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.UUIDJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.VoidJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveBooleanArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveByteArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveCharacterArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveDoubleArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveFloatArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveIntegerArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveLongArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.PrimitiveShortArrayJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveBooleanArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveByteArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveCharacterArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveDoubleArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveFloatArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveIntegerArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveLongArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.dd.PrimitiveShortArray2dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveBooleanArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveByteArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveCharacterArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveDoubleArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveFloatArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveIntegerArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveLongArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveShortArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.AbstractCollectionJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.AbstractListJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.AbstractQueueJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.AbstractSequentialListJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.AbstractSetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.ArrayListJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.CollectionJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.EnumSetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.HashSetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.IterableJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.LinkedHashSetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.LinkedListJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.ListJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.PriorityQueueJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.QueueJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.SetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.SortedSetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.StackJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.TreeSetJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.collection.VectorJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.AbstractMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.EnumMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.HashMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.IdentityHashMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.LinkedHashMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.MapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.SortedMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.TreeMapJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseDateKeyDeserializer.DateKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseDateKeyDeserializer.SqlDateKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseDateKeyDeserializer.SqlTimeKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseDateKeyDeserializer.SqlTimestampKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.BigDecimalKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.BigIntegerKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.ByteKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.DoubleKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.FloatKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.IntegerKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.LongKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BaseNumberKeyDeserializer.ShortKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.BooleanKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.CharacterKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.EnumKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.StringKeyDeserializer;
import com.github.nmorel.gwtjackson.client.deser.map.key.UUIDKeyDeserializer;
import com.github.nmorel.gwtjackson.client.ser.BaseDateJsonSerializer.DateJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseDateJsonSerializer.SqlDateJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseDateJsonSerializer.SqlTimeJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseDateJsonSerializer.SqlTimestampJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.BigDecimalJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.BigIntegerJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.ByteJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.DoubleJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.FloatJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.IntegerJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.LongJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.NumberJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BaseNumberJsonSerializer.ShortJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.BooleanJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.CharacterJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.CollectionJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.EnumJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.IterableJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.JavaScriptObjectJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.StringJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.UUIDJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.VoidJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveBooleanArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveByteArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveCharacterArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveDoubleArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveFloatArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveIntegerArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveLongArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.PrimitiveShortArrayJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveBooleanArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveByteArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveCharacterArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveDoubleArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveFloatArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveIntegerArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveLongArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.dd.PrimitiveShortArray2dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveBooleanArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveByteArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveCharacterArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveDoubleArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveFloatArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveIntegerArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveLongArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.array.ddd.PrimitiveShortArray3dJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.map.MapJsonSerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.BooleanKeySerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.DateKeySerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.EnumKeySerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.NumberKeySerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.ObjectKeySerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.ToStringKeySerializer;
import com.github.nmorel.gwtjackson.client.ser.map.key.UUIDKeySerializer;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * {@link AbstractConfiguration} implementation containing all the default serializers and deserializers.
 *
 * @author Nicolas Morel
 */
public final class DefaultConfiguration extends AbstractConfiguration {

    @Override
    protected void configure() {
        // Primitive mappers
        primitiveType( boolean.class ).serializer( BooleanJsonSerializer.class ).deserializer( BooleanJsonDeserializer.class );
        primitiveType( char.class ).serializer( CharacterJsonSerializer.class ).deserializer( CharacterJsonDeserializer.class );
        primitiveType( byte.class ).serializer( ByteJsonSerializer.class ).deserializer( ByteJsonDeserializer.class );
        primitiveType( double.class ).serializer( DoubleJsonSerializer.class ).deserializer( DoubleJsonDeserializer.class );
        primitiveType( float.class ).serializer( FloatJsonSerializer.class ).deserializer( FloatJsonDeserializer.class );
        primitiveType( int.class ).serializer( IntegerJsonSerializer.class ).deserializer( IntegerJsonDeserializer.class );
        primitiveType( long.class ).serializer( LongJsonSerializer.class ).deserializer( LongJsonDeserializer.class );
        primitiveType( short.class ).serializer( ShortJsonSerializer.class ).deserializer( ShortJsonDeserializer.class );

        // Common mappers
        type( String.class ).serializer( StringJsonSerializer.class ).deserializer( StringJsonDeserializer.class );
        type( Boolean.class ).serializer( BooleanJsonSerializer.class ).deserializer( BooleanJsonDeserializer.class );
        type( Character.class ).serializer( CharacterJsonSerializer.class ).deserializer( CharacterJsonDeserializer.class );
        type( UUID.class ).serializer( UUIDJsonSerializer.class ).deserializer( UUIDJsonDeserializer.class );
        type( Void.class ).serializer( VoidJsonSerializer.class ).deserializer( VoidJsonDeserializer.class );
        type( JavaScriptObject.class ).serializer( JavaScriptObjectJsonSerializer.class )
                .deserializer( JavaScriptObjectJsonDeserializer.class );
        type( Enum.class ).serializer( EnumJsonSerializer.class ).deserializer( EnumJsonDeserializer.class );

        // Number mappers
        type( BigDecimal.class ).serializer( BigDecimalJsonSerializer.class ).deserializer( BigDecimalJsonDeserializer.class );
        type( BigInteger.class ).serializer( BigIntegerJsonSerializer.class ).deserializer( BigIntegerJsonDeserializer.class );
        type( Byte.class ).serializer( ByteJsonSerializer.class ).deserializer( ByteJsonDeserializer.class );
        type( Double.class ).serializer( DoubleJsonSerializer.class ).deserializer( DoubleJsonDeserializer.class );
        type( Float.class ).serializer( FloatJsonSerializer.class ).deserializer( FloatJsonDeserializer.class );
        type( Integer.class ).serializer( IntegerJsonSerializer.class ).deserializer( IntegerJsonDeserializer.class );
        type( Long.class ).serializer( LongJsonSerializer.class ).deserializer( LongJsonDeserializer.class );
        type( Short.class ).serializer( ShortJsonSerializer.class ).deserializer( ShortJsonDeserializer.class );
        type( Number.class ).serializer( NumberJsonSerializer.class ).deserializer( NumberJsonDeserializer.class );

        // Date mappers
        type( Date.class ).serializer( DateJsonSerializer.class ).deserializer( DateJsonDeserializer.class );
        type( java.sql.Date.class ).serializer( SqlDateJsonSerializer.class ).deserializer( SqlDateJsonDeserializer.class );
        type( Time.class ).serializer( SqlTimeJsonSerializer.class ).deserializer( SqlTimeJsonDeserializer.class );
        type( Timestamp.class ).serializer( SqlTimestampJsonSerializer.class ).deserializer( SqlTimestampJsonDeserializer.class );

        // Iterable mappers
        type( Iterable.class ).serializer( IterableJsonSerializer.class ).deserializer( IterableJsonDeserializer.class );
        type( Collection.class ).serializer( CollectionJsonSerializer.class ).deserializer( CollectionJsonDeserializer.class );
        type( AbstractCollection.class ).serializer( CollectionJsonSerializer.class )
                .deserializer( AbstractCollectionJsonDeserializer.class );
        type( AbstractList.class ).serializer( CollectionJsonSerializer.class ).deserializer( AbstractListJsonDeserializer.class );
        type( AbstractQueue.class ).serializer( CollectionJsonSerializer.class ).deserializer( AbstractQueueJsonDeserializer.class );
        type( AbstractSequentialList.class ).serializer( CollectionJsonSerializer.class )
                .deserializer( AbstractSequentialListJsonDeserializer.class );
        type( AbstractSet.class ).serializer( CollectionJsonSerializer.class ).deserializer( AbstractSetJsonDeserializer.class );
        type( ArrayList.class ).serializer( CollectionJsonSerializer.class ).deserializer( ArrayListJsonDeserializer.class );
        type( EnumSet.class ).serializer( CollectionJsonSerializer.class ).deserializer( EnumSetJsonDeserializer.class );
        type( HashSet.class ).serializer( CollectionJsonSerializer.class ).deserializer( HashSetJsonDeserializer.class );
        type( LinkedHashSet.class ).serializer( CollectionJsonSerializer.class ).deserializer( LinkedHashSetJsonDeserializer.class );
        type( LinkedList.class ).serializer( CollectionJsonSerializer.class ).deserializer( LinkedListJsonDeserializer.class );
        type( List.class ).serializer( CollectionJsonSerializer.class ).deserializer( ListJsonDeserializer.class );
        type( PriorityQueue.class ).serializer( CollectionJsonSerializer.class ).deserializer( PriorityQueueJsonDeserializer.class );
        type( Queue.class ).serializer( CollectionJsonSerializer.class ).deserializer( QueueJsonDeserializer.class );
        type( Set.class ).serializer( CollectionJsonSerializer.class ).deserializer( SetJsonDeserializer.class );
        type( SortedSet.class ).serializer( CollectionJsonSerializer.class ).deserializer( SortedSetJsonDeserializer.class );
        type( Stack.class ).serializer( CollectionJsonSerializer.class ).deserializer( StackJsonDeserializer.class );
        type( TreeSet.class ).serializer( CollectionJsonSerializer.class ).deserializer( TreeSetJsonDeserializer.class );
        type( Vector.class ).serializer( CollectionJsonSerializer.class ).deserializer( VectorJsonDeserializer.class );

        // Map mappers
        type( Map.class ).serializer( MapJsonSerializer.class ).deserializer( MapJsonDeserializer.class );
        type( AbstractMap.class ).serializer( MapJsonSerializer.class ).deserializer( AbstractMapJsonDeserializer.class );
        type( EnumMap.class ).serializer( MapJsonSerializer.class ).deserializer( EnumMapJsonDeserializer.class );
        type( HashMap.class ).serializer( MapJsonSerializer.class ).deserializer( HashMapJsonDeserializer.class );
        type( IdentityHashMap.class ).serializer( MapJsonSerializer.class ).deserializer( IdentityHashMapJsonDeserializer.class );
        type( LinkedHashMap.class ).serializer( MapJsonSerializer.class ).deserializer( LinkedHashMapJsonDeserializer.class );
        type( SortedMap.class ).serializer( MapJsonSerializer.class ).deserializer( SortedMapJsonDeserializer.class );
        type( TreeMap.class ).serializer( MapJsonSerializer.class ).deserializer( TreeMapJsonDeserializer.class );

        // Primitive array mappers
        type( boolean[].class ).serializer( PrimitiveBooleanArrayJsonSerializer.class )
                .deserializer( PrimitiveBooleanArrayJsonDeserializer.class );
        type( byte[].class ).serializer( PrimitiveByteArrayJsonSerializer.class ).deserializer( PrimitiveByteArrayJsonDeserializer.class );
        type( char[].class ).serializer( PrimitiveCharacterArrayJsonSerializer.class )
                .deserializer( PrimitiveCharacterArrayJsonDeserializer.class );
        type( double[].class ).serializer( PrimitiveDoubleArrayJsonSerializer.class )
                .deserializer( PrimitiveDoubleArrayJsonDeserializer.class );
        type( float[].class ).serializer( PrimitiveFloatArrayJsonSerializer.class )
                .deserializer( PrimitiveFloatArrayJsonDeserializer.class );
        type( int[].class ).serializer( PrimitiveIntegerArrayJsonSerializer.class )
                .deserializer( PrimitiveIntegerArrayJsonDeserializer.class );
        type( long[].class ).serializer( PrimitiveLongArrayJsonSerializer.class ).deserializer( PrimitiveLongArrayJsonDeserializer.class );
        type( short[].class ).serializer( PrimitiveShortArrayJsonSerializer.class )
                .deserializer( PrimitiveShortArrayJsonDeserializer.class );

        // Primitive 2D Array mappers
        type( boolean[][].class ).serializer( PrimitiveBooleanArray2dJsonSerializer.class )
                .deserializer( PrimitiveBooleanArray2dJsonDeserializer.class );
        type( byte[][].class ).serializer( PrimitiveByteArray2dJsonSerializer.class )
                .deserializer( PrimitiveByteArray2dJsonDeserializer.class );
        type( char[][].class ).serializer( PrimitiveCharacterArray2dJsonSerializer.class )
                .deserializer( PrimitiveCharacterArray2dJsonDeserializer.class );
        type( double[][].class ).serializer( PrimitiveDoubleArray2dJsonSerializer.class )
                .deserializer( PrimitiveDoubleArray2dJsonDeserializer.class );
        type( float[][].class ).serializer( PrimitiveFloatArray2dJsonSerializer.class )
                .deserializer( PrimitiveFloatArray2dJsonDeserializer.class );
        type( int[][].class ).serializer( PrimitiveIntegerArray2dJsonSerializer.class )
                .deserializer( PrimitiveIntegerArray2dJsonDeserializer.class );
        type( long[][].class ).serializer( PrimitiveLongArray2dJsonSerializer.class )
                .deserializer( PrimitiveLongArray2dJsonDeserializer.class );
        type( short[][].class ).serializer( PrimitiveShortArray2dJsonSerializer.class )
                .deserializer( PrimitiveShortArray2dJsonDeserializer.class );

        // Primitive 3D Array mappers
        type( boolean[][][].class ).serializer( PrimitiveBooleanArray3dJsonSerializer.class )
                .deserializer( PrimitiveBooleanArray3dJsonDeserializer.class );
        type( byte[][][].class ).serializer( PrimitiveByteArray3dJsonSerializer.class )
                .deserializer( PrimitiveByteArray3dJsonDeserializer.class );
        type( char[][][].class ).serializer( PrimitiveCharacterArray3dJsonSerializer.class )
                .deserializer( PrimitiveCharacterArray3dJsonDeserializer.class );
        type( double[][][].class ).serializer( PrimitiveDoubleArray3dJsonSerializer.class )
                .deserializer( PrimitiveDoubleArray3dJsonDeserializer.class );
        type( float[][][].class ).serializer( PrimitiveFloatArray3dJsonSerializer.class )
                .deserializer( PrimitiveFloatArray3dJsonDeserializer.class );
        type( int[][][].class ).serializer( PrimitiveIntegerArray3dJsonSerializer.class )
                .deserializer( PrimitiveIntegerArray3dJsonDeserializer.class );
        type( long[][][].class ).serializer( PrimitiveLongArray3dJsonSerializer.class )
                .deserializer( PrimitiveLongArray3dJsonDeserializer.class );
        type( short[][][].class ).serializer( PrimitiveShortArray3dJsonSerializer.class )
                .deserializer( PrimitiveShortArray3dJsonDeserializer.class );

        // Map's key mappers
        key( Object.class ).serializer( ObjectKeySerializer.class ).deserializer( StringKeyDeserializer.class );
        key( Serializable.class ).serializer( ObjectKeySerializer.class ).deserializer( StringKeyDeserializer.class );
        key( BigDecimal.class ).serializer( NumberKeySerializer.class ).deserializer( BigDecimalKeyDeserializer.class );
        key( BigInteger.class ).serializer( NumberKeySerializer.class ).deserializer( BigIntegerKeyDeserializer.class );
        key( Boolean.class ).serializer( BooleanKeySerializer.class ).deserializer( BooleanKeyDeserializer.class );
        key( Byte.class ).serializer( NumberKeySerializer.class ).deserializer( ByteKeyDeserializer.class );
        key( Character.class ).serializer( ToStringKeySerializer.class ).deserializer( CharacterKeyDeserializer.class );
        key( Date.class ).serializer( DateKeySerializer.class ).deserializer( DateKeyDeserializer.class );
        key( Double.class ).serializer( NumberKeySerializer.class ).deserializer( DoubleKeyDeserializer.class );
        key( Enum.class ).serializer( EnumKeySerializer.class ).deserializer( EnumKeyDeserializer.class );
        key( Float.class ).serializer( NumberKeySerializer.class ).deserializer( FloatKeyDeserializer.class );
        key( Integer.class ).serializer( NumberKeySerializer.class ).deserializer( IntegerKeyDeserializer.class );
        key( Long.class ).serializer( NumberKeySerializer.class ).deserializer( LongKeyDeserializer.class );
        key( Short.class ).serializer( NumberKeySerializer.class ).deserializer( ShortKeyDeserializer.class );
        key( java.sql.Date.class ).serializer( DateKeySerializer.class ).deserializer( SqlDateKeyDeserializer.class );
        key( Time.class ).serializer( DateKeySerializer.class ).deserializer( SqlTimeKeyDeserializer.class );
        key( Timestamp.class ).serializer( DateKeySerializer.class ).deserializer( SqlTimestampKeyDeserializer.class );
        key( String.class ).serializer( ToStringKeySerializer.class ).deserializer( StringKeyDeserializer.class );
        key( UUID.class ).serializer( UUIDKeySerializer.class ).deserializer( UUIDKeyDeserializer.class );
    }
}
