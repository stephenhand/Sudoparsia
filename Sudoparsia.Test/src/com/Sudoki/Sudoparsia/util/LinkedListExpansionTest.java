package com.Sudoki.Sudoparsia.util;

import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 06/04/12
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListExpansionTest {

    private static AbstractSequentialList<AbstractSequentialList<String>> _testSource=new LinkedList<AbstractSequentialList<String>>();

    @BeforeClass
    public static void setUp()
    {
        LinkedList<String> _sublist=new LinkedList<String>();
        _sublist.add("EDAM");
        _sublist.add("GRUYERE");
        _sublist.add("EMMENTHAL");
        _sublist.add("CHEDDAR");
        _testSource.add(_sublist);
        _sublist=new LinkedList<String>();
        _sublist.add("BROWN");
        _sublist.add("WHITE");
        _testSource.add(_sublist);
        _sublist=new LinkedList<String>();
        _sublist.add("MAISY");
        _sublist.add("DAISY");
        _sublist.add("DUFFY");
        _testSource.add(_sublist);
    }

    @Test
    public void listIterator_EmptyData_ThrowsNoSuchElement()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(new LinkedList<AbstractSequentialList<String>>());
        try
        {
            testList.listIterator();
        }
        catch (NoSuchElementException ex)
        {
            return;
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }
        Assert.fail("No Exception");
    }


    @Test
    public void listIterator_ValidData_DoesNotThrow()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        try
        {
            testList.listIterator();
        }

        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }
    }

    @Test
    public void get_ValidDataFirstList_ReturnsCorrect()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        String val=null;
        try
        {
            val=testList.get(1);
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }
        Assert.assertEquals("GRUYERE", val);
    }

    @Test
    public void get_ValidDataSubsequentList_ReturnsCorrect()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        String val=null;
        try
        {
            val=testList.get(6);
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }
        Assert.assertEquals("MAISY",val);
    }

    @Test
    public void size_EmptyData_returns0()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(new LinkedList<AbstractSequentialList<String>>());
        int val=0;
        try
        {
            val=testList.size();
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }
        Assert.assertEquals(0,val);
    }

    @Test
    public void size_ValidData_returnsCorrect()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        int val=0;
        try
        {
            val=testList.size();
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }
        Assert.assertEquals(9,val);
    }
    //for now at least the aggregate representation is read only
    @Test
    public void add_Any_ThrowsUnsupportedOperation()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        try
        {
            testList.add(4,"LANCASHIRE");
        }
        catch (UnsupportedOperationException ex)
        {
            return;
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }

        Assert.fail("No Exception");
    }

    @Test
    public void iteratorHasNext_ValidDataWithin1List_ReturnsCorrect()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        String val=null;
        try
        {
            Iterator it=testList.listIterator(3) ;
            val=(String)it.next();
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }

        Assert.assertEquals("CHEDDAR", val);
    }

    @Test
    public void listIteratorHasNext_ValidDataOverSubLists_ReturnsCorrect()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        String val=null,val2=null;
        try
        {
            Iterator it=testList.listIterator(5) ;
            val=(String)it.next();
            val2=(String)it.next();
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }

        Assert.assertEquals("WHITE",val);
        Assert.assertEquals("MAISY",val2);
    }

    @Test
    public void iteratorParameterlessConst_ValidData_isAtStart()
    {
        LinkedListExpansion<String> testList=new LinkedListExpansion<String>(_testSource);
        String val=null;
        try
        {
            Iterator it=testList.iterator() ;
            val=(String)it.next();
        }
        catch (Exception ex)
        {
            Assert.fail("Exception: "+ex.getMessage());
        }

        Assert.assertEquals("EDAM",val);
    }
}
