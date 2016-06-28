package com.github.nmorel.gwtjackson.client.ser.array.ddd;

import java.util.Arrays;

import com.github.nmorel.gwtjackson.client.deser.array.ddd.PrimitiveDoubleArray3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.ser.AbstractJsonSerializerTest;

public class IntegerArray3dJsonSerializerTest extends AbstractJsonSerializerTest<double[][][]> {

    @Override
    protected PrimitiveDoubleArray3dJsonSerializer createSerializer() {
        return PrimitiveDoubleArray3dJsonSerializer.getInstance();
    }

    @Override
    protected PrimitiveDoubleArray3dJsonDeserializer createDeserializer() {
        return PrimitiveDoubleArray3dJsonDeserializer.getInstance();
    }

    @Override
    public void testSerializeValue() {
        double[][][] array = new double[][][]{
            {{0.2f, 0.3f, 0.4f, 0.5f}, {0, 0, 0}, {2, 1, -100}, {400.004f}},
            {{-0.0f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_NORMAL}},
            {{-0.0, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_NORMAL}},
            {{0}, {1}, {3f}, {-4f, -6f, -8f}},
            {{}, {}, {}},
            {}
        };
        String serializedString = serialize( array );
        double[][][] deserializedArray = deserialize( serializedString );

        assertEquals( serializedString, serialize( deserialize( serializedString ) ) );
        assertEquals( Arrays.deepToString( array ), Arrays.deepToString( deserializedArray ) );
    }

}
