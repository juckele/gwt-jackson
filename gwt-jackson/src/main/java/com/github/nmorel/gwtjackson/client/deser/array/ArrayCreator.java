package com.github.nmorel.gwtjackson.client.deser.array;

import static com.github.nmorel.gwtjackson.rebind.writer.JTypeName.parameterizedName;
import static com.github.nmorel.gwtjackson.rebind.writer.JTypeName.rawName;
import static com.github.nmorel.gwtjackson.rebind.writer.JTypeName.typeName;

import javax.lang.model.element.Modifier;

import com.github.nmorel.gwtjackson.client.deser.array.ddd.Array3dJsonDeserializer.Array3dCreator;
import com.google.gwt.core.ext.typeinfo.JArrayType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

public abstract class ArrayCreator<T> {

    public T[] create1d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][] create2d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][] create3d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][][] create4d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][][][] create5d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][][][][] create6d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][][][][][] create7d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][][][][][][] create8d( int length ) {
        throw new UnsupportedOperationException();
    }

    public T[][][][][][][][][] create9d( int length ) {
        throw new UnsupportedOperationException();
    }

    
    public static TypeSpec build(JArrayType arrayType, int maxRank, JType leafType)
    {
    	Builder classBuilder = TypeSpec.anonymousClassBuilder( "" )
                .addSuperinterface( parameterizedName( Array3dCreator.class, leafType ) );
    	for(int rank = 1; rank <= maxRank; rank++) {
    		StringBuilder returnStatement = new StringBuilder("return new $T[$N]");
    		int empyRanks = rank-1;
    		for(int i = 0; i < empyRanks; i++) {
    			returnStatement.append("[]");
    		}
    		classBuilder.addMethod( MethodSpec.methodBuilder( "create"+rank+"d" )
    			    .addAnnotation( Override.class )
    			    .addModifiers( Modifier.PUBLIC )
                    .addParameter( int.class, "length" )
                    .addStatement( returnStatement.toString(), rawName( leafType ), "length" )
                    .returns( typeName( arrayType ) )
                    .build() );
    	}
    	return classBuilder.build();
    }
}
