package com.Sudoki.Sudoparsia.Config;

import com.Sudoki.Sudoparsia.MoveType;
import com.Sudoki.Sudoparsia.config.ShapeException;
import com.Sudoki.Sudoparsia.config.ShapeTree;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 04/04/12
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class ShapeTreeTest {
    private LinkedList<MoveType> _skyscraperMoves=new LinkedList<MoveType>(),_invalidShape=new LinkedList<MoveType>(), _otherShape=new LinkedList<MoveType>();

    @Before
    public void setUp()
    {
        _skyscraperMoves.add(MoveType.Line);
        _skyscraperMoves.add(MoveType.Perpendicular);
        _skyscraperMoves.add(MoveType.Line);
        _skyscraperMoves.add(MoveType.Box);

        _invalidShape.add(MoveType.Line);
        _invalidShape.add(null);
        _invalidShape.add(MoveType.Line);

        _otherShape.add(MoveType.Line);
        _otherShape.add(MoveType.Line);
        _otherShape.add(MoveType.Line);
        _otherShape.add(MoveType.Line);
    }

    @Test
    public void AddShape_ValidShape_DoesNotThrow()
    {
        try
        {
            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_skyscraperMoves);
        }
        catch (Exception e)
        {
            Assert.fail();
        }

    }

    @Test
    public void AddShape_InvalidShape_Throws()
    {
        try
        {
            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_invalidShape);
        }
        catch (ShapeException se)
        {
            return;
        }
        catch (Exception e)
        {
            Assert.fail("Exception thrown: "+e.getMessage());
        }
        Assert.fail("ShapeException Not thrown");
    }

    @Test
    public void LookShape_ValidShape_DoesNotThrow()
    {
        try
        {
            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_skyscraperMoves);
            String shape=tree.LookupShape(_skyscraperMoves);
        }
        catch (Exception e)
        {
            Assert.fail("Threw exception");
        }

    }

    @Test
    public void LookShape_EmptyTree_ReturnsNull()
    {
        try
        {
            ShapeTree tree=new ShapeTree();
            String shape=tree.LookupShape(_skyscraperMoves);
            Assert.assertNull(shape);
        }
        catch (Exception e)
        {
            Assert.fail("Threw exception");
        }

    }

    @Test
    public void LookShape_MissingShape_ReturnsNull()
    {
        try
        {
            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_skyscraperMoves);
            String shape=tree.LookupShape(_otherShape);
            Assert.assertNull(shape);
        }
        catch (Exception e)
        {
            Assert.fail("Threw exception");
        }

    }

    @Test
    public void LookShape_ValidShape_ReturnsShape()
    {
        try
        {
            LinkedList<MoveType> lookupShape=new LinkedList<MoveType>();

            lookupShape.add(MoveType.Line);
            lookupShape.add(MoveType.Perpendicular);
            lookupShape.add(MoveType.Line);
            lookupShape.add(MoveType.Box);

            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_skyscraperMoves);
            String shape=tree.LookupShape(lookupShape);
            Assert.assertEquals("TestShape", shape);
        }
        catch (Exception e)
        {
            Assert.fail("Threw exception");
        }

    }


    @Test
    public void LookShape_TwoValidShapes_ReturnsBoth()
    {
        try
        {
            LinkedList<MoveType> lookupShape=new LinkedList<MoveType>(),lookupShape2=new LinkedList<MoveType>();

            lookupShape.add(MoveType.Line);
            lookupShape.add(MoveType.Perpendicular);
            lookupShape.add(MoveType.Line);
            lookupShape.add(MoveType.Box);

            lookupShape2.add(MoveType.Line);
            lookupShape2.add(MoveType.Line);
            lookupShape2.add(MoveType.Line);
            lookupShape2.add(MoveType.Line);

            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_skyscraperMoves);
            tree.AddShape("TestShape2",_otherShape);
            String shape=tree.LookupShape(lookupShape),shape2=tree.LookupShape(lookupShape2);
            Assert.assertEquals("TestShape",shape);
            Assert.assertEquals("TestShape2",shape2);
        }
        catch (Exception e)
        {
            Assert.fail("Threw exception");
        }

    }

    @Test
    public void LookShape_InvalidShape_Throws()
    {
        try
        {
            ShapeTree tree=new ShapeTree();
            tree.AddShape("TestShape",_skyscraperMoves);
            String shape=tree.LookupShape(_otherShape);
            Assert.assertNull(shape);
        }
        catch (Exception e)
        {
            Assert.fail("Threw exception");
        }

    }
}
