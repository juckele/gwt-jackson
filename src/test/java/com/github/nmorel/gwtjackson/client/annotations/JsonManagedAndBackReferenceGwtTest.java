package com.github.nmorel.gwtjackson.client.annotations;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.github.nmorel.gwtjackson.shared.JsonMapperTester;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.AbstractNode;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.Advertisement708;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.FullTreeNode;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.NodeArray;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.NodeList;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.NodeMap;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.Parent;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.SimpleTreeNode;
import com.github.nmorel.gwtjackson.shared.annotations.JsonManagedAndBackReferenceTester.SimpleTreeNode2;
import com.google.gwt.core.client.GWT;

/**
 * @author Nicolas Morel
 */
public class JsonManagedAndBackReferenceGwtTest extends GwtJacksonTestCase {

    public interface SimpleTreeNodeMapper extends ObjectMapper<SimpleTreeNode>, JsonMapperTester<SimpleTreeNode> {

        static SimpleTreeNodeMapper INSTANCE = GWT.create( SimpleTreeNodeMapper.class );
    }

    public interface SimpleTreeNode2Mapper extends ObjectMapper<SimpleTreeNode2>, JsonMapperTester<SimpleTreeNode2> {

        static SimpleTreeNode2Mapper INSTANCE = GWT.create( SimpleTreeNode2Mapper.class );
    }

    public interface FullTreeNodeMapper extends ObjectMapper<FullTreeNode>, JsonMapperTester<FullTreeNode> {

        static FullTreeNodeMapper INSTANCE = GWT.create( FullTreeNodeMapper.class );
    }

    public interface NodeArrayMapper extends ObjectMapper<NodeArray>, JsonMapperTester<NodeArray> {

        static NodeArrayMapper INSTANCE = GWT.create( NodeArrayMapper.class );
    }

    public interface NodeListMapper extends ObjectMapper<NodeList>, JsonMapperTester<NodeList> {

        static NodeListMapper INSTANCE = GWT.create( NodeListMapper.class );
    }

    public interface NodeMapMapper extends ObjectMapper<NodeMap>, JsonMapperTester<NodeMap> {

        static NodeMapMapper INSTANCE = GWT.create( NodeMapMapper.class );
    }

    public interface AbstractNodeMapper extends ObjectMapper<AbstractNode>, JsonMapperTester<AbstractNode> {

        static AbstractNodeMapper INSTANCE = GWT.create( AbstractNodeMapper.class );
    }

    public interface ParentMapper extends ObjectMapper<Parent>, JsonMapperTester<Parent> {

        static ParentMapper INSTANCE = GWT.create( ParentMapper.class );
    }

    public interface Advertisement708Mapper extends ObjectMapper<Advertisement708>, JsonMapperTester<Advertisement708> {

        static Advertisement708Mapper INSTANCE = GWT.create( Advertisement708Mapper.class );
    }

    private final JsonManagedAndBackReferenceTester tester = JsonManagedAndBackReferenceTester.INSTANCE;

    public void testBackReferenceWithoutManaged() {
        tester.testBackReferenceWithoutManaged( SimpleTreeNodeMapper.INSTANCE );
    }

    public void testSimpleRefs() {
        tester.testSimpleRefs( SimpleTreeNodeMapper.INSTANCE );
    }

    public void testSimpleRefsWithGetter() {
        tester.testSimpleRefsWithGetter( SimpleTreeNode2Mapper.INSTANCE );
    }

    public void testFullRefs() {
        tester.testFullRefs( FullTreeNodeMapper.INSTANCE );
    }

    public void testArrayOfRefs() {
        tester.testArrayOfRefs( NodeArrayMapper.INSTANCE );
    }

    public void testListOfRefs() {
        tester.testListOfRefs( NodeListMapper.INSTANCE );
    }

    public void testMapOfRefs() {
        tester.testMapOfRefs( NodeMapMapper.INSTANCE );
    }

    public void testAbstract368() {
        tester.testAbstract368( AbstractNodeMapper.INSTANCE );
    }

    public void testIssue693() {
        tester.testIssue693( ParentMapper.INSTANCE );
    }

    public void testIssue708() {
        tester.testIssue708( Advertisement708Mapper.INSTANCE );
    }
}
