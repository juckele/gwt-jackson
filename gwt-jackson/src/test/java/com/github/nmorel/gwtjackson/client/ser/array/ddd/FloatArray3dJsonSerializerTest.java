package com.github.nmorel.gwtjackson.client.ser.array.ddd;

import java.util.Arrays;

import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveFloatArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.ser.AbstractJsonSerializerTest;

public class FloatArray3dJsonSerializerTest extends AbstractJsonSerializerTest<float[][][]> {

    @Override
    protected PrimitiveFloatArray3dJsonSerializer createSerializer() {
        return PrimitiveFloatArray3dJsonSerializer.getInstance();
    }

    @Override
    protected PrimitiveFloatArray3dJsonDeserializer createDeserializer() {
        return PrimitiveFloatArray3dJsonDeserializer.getInstance();
    }

    @Override
    public void testSerializeValue() {
        float[][][] array = new float[][][]{
            {{0.2f, 0.3f, 0.4f, 0.5f}, {0, 0, 0}, {2, 1, -100}, {400.004f}},
            {{-0f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL}},
            {{0}, {1}, {3f}, {-4f, -6f, -8f}}
        };
        String serializedString = serialize( array );
        float[][][] deserializedArray = deserialize( serializedString );

        assertEquals( serializedString, serialize( deserialize( serializedString ) ) );
        assertEquals( Arrays.deepToString( array ), Arrays.deepToString( deserializedArray ) );
    }

}
