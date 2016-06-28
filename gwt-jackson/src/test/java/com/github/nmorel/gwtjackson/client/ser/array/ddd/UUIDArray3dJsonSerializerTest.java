package com.github.nmorel.gwtjackson.client.ser.array.ddd;

import java.util.Arrays;
import java.util.UUID;

import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.deser.UUIDJsonDeserializer;
import com.github.nmorel.gwtjackson.client.deser.array.ddd.Array3dJsonDeserializer;
import com.github.nmorel.gwtjackson.client.ser.AbstractJsonSerializerTest;
import com.github.nmorel.gwtjackson.client.ser.UUIDJsonSerializer;

public class UUIDArray3dJsonSerializerTest extends AbstractJsonSerializerTest<UUID[][][]> {

    @Override
    protected JsonSerializer<UUID[][][]> createSerializer() {
		return Array3dJsonSerializer.newInstance(UUIDJsonSerializer.getInstance());
    }

    @Override
    protected JsonDeserializer<UUID[][][]> createDeserializer() {
		return Array3dJsonDeserializer.newInstance(UUIDJsonDeserializer.getInstance(), null);
    }

    @Override
    public void testSerializeValue() {
        UUID[][][] array = new UUID[][][]{
            {{UUID.randomUUID(), UUID.randomUUID()}, {UUID.randomUUID()}, {UUID.randomUUID()}},
            {{UUID.fromString("00000000-0000-0000-0000-000000000000")}},
            {{UUID.fromString("ffffffff-ffff-ffff-ffff-ffffffffffff")}},
            {{}, {}, {}},
            {}
        };
        String serializedString = serialize( array );
        UUID[][][] deserializedArray = deserialize( serializedString );

        assertEquals( serializedString, serialize( deserialize( serializedString ) ) );
        assertEquals( Arrays.deepToString( array ), Arrays.deepToString( deserializedArray ) );
    }

}
