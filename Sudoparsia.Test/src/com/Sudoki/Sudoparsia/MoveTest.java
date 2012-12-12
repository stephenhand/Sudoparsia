package com.Sudoki.Sudoparsia;

import com.Sudoki.Sudoparsia.config.IShapeDictionary;
import com.Sudoki.Sudoparsia.config.ShapeException;
import junit.framework.Assert;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 09/04/12
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public class MoveTest {

    private static IShapeDictionary _mockDict;
    private static AbstractSequentialList<Statement> _skyscraper,_xwing,_2stringKite,_unidentified,_unidentifiedIrregular;

    @BeforeClass
    public static void setup() throws ShapeException {
        _mockDict=Mockito.mock(IShapeDictionary.class);
        Mockito.when(_mockDict.LookupShape(Mockito.any(AbstractSequentialList.class))).thenReturn(null);
        


        Mockito.when(_mockDict.LookupShape(Mockito.argThat(new BaseMatcher<AbstractSequentialList<MoveType>>() {
            @Override
            public boolean matches(Object o) {
                if (o==null) return false;

                ListIterator<MoveType> it=((AbstractSequentialList<MoveType>)o).listIterator();
                try
                {
                     if (it.next()!=MoveType.Line) return false;
                    if (it.next()!=MoveType.Perpendicular) return false;
                    if (it.next()!=MoveType.Line) return false;
                }
                catch (NoSuchElementException nseex)
                {
                    return false;
                }
                return !it.hasNext();  //Must be at the end of the sequence to be correct
            }

            @Override
            public void describeTo(Description description) {
                description.appendDescriptionOf(this);
            }
        }))).thenReturn("SKYSCRAPER");

        Mockito.when(_mockDict.LookupShape(Mockito.argThat(new BaseMatcher<AbstractSequentialList<MoveType>>() {
            @Override
            public boolean matches(Object o) {
                if (o==null) return false;
                ListIterator<MoveType> it=((AbstractSequentialList<MoveType>)o).listIterator();
                try
                {
                    if (it.next()!=MoveType.Line) return false;
                    if (it.next()!=MoveType.Perpendicular) return false;
                    if (it.next()!=MoveType.Line) return false;
                    if (it.next()!=MoveType.PerpendicularReturn) return false;
                }
                catch (NoSuchElementException nsee)
                {
                    return false;
                }
                return !it.hasNext();  //Must be at the end of the sequence to be correct
            }

            @Override
            public void describeTo(Description description) {
                description.appendDescriptionOf(this);
            }
        }))).thenReturn("XWING");

        Mockito.when(_mockDict.LookupShape(Mockito.argThat(new BaseMatcher<AbstractSequentialList<MoveType>>() {
            @Override
            public boolean matches(Object o) {
                if (o==null) return false;

                ListIterator<MoveType> it=((AbstractSequentialList<MoveType>)o).listIterator();
                try
                {
                    if (it.next()!=MoveType.Line) return false;
                    if (it.next()!=MoveType.Box) return false;
                    if (it.next()!=MoveType.Perpendicular) return false;
                }
                catch (NoSuchElementException nsee)
                {
                    return false;
                }
                return !it.hasNext();  //Must be at the end of the sequence to be correct
            }

            @Override
            public void describeTo(Description description) {
                description.appendDescriptionOf(this);
            }
        }))).thenReturn("2STRINGKITE");
        Mockito.when(_mockDict.LookupShape(null)).thenThrow( new NullPointerException("Null move type list beep") );
        Statement st;
        _skyscraper=new LinkedList<Statement>();

        st=new Statement();
        st.setRow(8);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.None);
        st.setEndInference(Statement.Inference.Strong);
        _skyscraper.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.Weak);
        _skyscraper.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(9);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Weak);
        st.setEndInference(Statement.Inference.Strong);
        _skyscraper.add(st);

        st=new Statement();
        st.setRow(9);
        st.setColumn(9);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.None);
        _skyscraper.add(st);



        _xwing=new LinkedList<Statement>();
        st=new Statement();
        st.setRow(8);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.None);
        st.setEndInference(Statement.Inference.Strong);
        _xwing.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.Weak);
        _xwing.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(8);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Weak);
        st.setEndInference(Statement.Inference.Strong);
        _xwing.add(st);

        st=new Statement();
        st.setRow(8);
        st.setColumn(8);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.Weak);
        _xwing.add(st);

        st=new Statement();
        st.setRow(8);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Weak);
        st.setEndInference(Statement.Inference.Strong);
        _xwing.add(st);


        _2stringKite=new LinkedList<Statement>();

        st=new Statement();
        st.setRow(5);
        st.setColumn(8);
        st.setValue(7);
        st.setStartInference(Statement.Inference.None);
        st.setEndInference(Statement.Inference.Strong);
        _2stringKite.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.Weak);
        _2stringKite.add(st);

        st=new Statement();
        st.setRow(4);
        st.setColumn(4);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Weak);
        st.setEndInference(Statement.Inference.Strong);
        _2stringKite.add(st);

        st=new Statement();
        st.setRow(9);
        st.setColumn(4);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.None);
        _2stringKite.add(st);

        _unidentified=new LinkedList<Statement>();

        st=new Statement();
        st.setRow(5);
        st.setColumn(8);
        st.setValue(7);
        st.setStartInference(Statement.Inference.None);
        st.setEndInference(Statement.Inference.Strong);
        _unidentified.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.Weak);
        _unidentified.add(st);

        st=new Statement();
        st.setRow(4);
        st.setColumn(4);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Weak);
        st.setEndInference(Statement.Inference.Strong);
        _unidentified.add(st);

        st=new Statement();
        st.setRow(4);
        st.setColumn(1);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.None);
        _unidentified.add(st);


        _unidentifiedIrregular=new LinkedList<Statement>();

        st=new Statement();
        st.setRow(5);
        st.setColumn(8);
        st.setValue(7);
        st.setStartInference(Statement.Inference.None);
        st.setEndInference(Statement.Inference.Strong);
        _unidentifiedIrregular.add(st);

        st=new Statement();
        st.setRow(5);
        st.setColumn(5);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.Weak);
        _unidentifiedIrregular.add(st);

        st=new Statement();
        st.setRow(4);
        st.setColumn(4);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Weak);
        st.setEndInference(Statement.Inference.Strong);
        _unidentifiedIrregular.add(st);

        st=new Statement();
        st.setRow(9);
        st.setColumn(9);
        st.setValue(7);
        st.setStartInference(Statement.Inference.Strong);
        st.setEndInference(Statement.Inference.None);
        _unidentifiedIrregular.add(st);
    }

    @Test
    public void getShapeFromSequence_nullInput_throwsNullReference()
    {
        Move m=new Move();
        try
        {
            m.getShapeFromSequence(null,_mockDict);
        }
        catch (NullPointerException npe)
        {
            return;
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.fail("No Exception");
    }

    @Test
    public void getShapeFromSequence_nullDictionary_throwsNullReference()
    {
        Move m=new Move();
        try
        {
            m.getShapeFromSequence(_skyscraper,null);
        }
        catch (NullPointerException npe)
        {
            return;
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.fail("No Exception");
    }


    @Test
    public void getShapeFromSequence_SkyscraperIn_returnsSkyScraper()
    {
        Move m=new Move();
        String res=null;
        try
        {
            res=m.getShapeFromSequence(_skyscraper,_mockDict);
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.assertEquals("SKYSCRAPER",res);
    }

    @Test
    public void getShapeFromSequence_TwoStringKiteIn_returnsTwoStringKite()
    {
        Move m=new Move();
        String res=null;
        try
        {
            res=m.getShapeFromSequence(_2stringKite,_mockDict);
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.assertEquals("2STRINGKITE",res);
    }

    @Test
    public void getShapeFromSequence_XWingIn_returnsXWing()
    {
        Move m=new Move();
        String res=null;
        try
        {
            res=m.getShapeFromSequence(_xwing,_mockDict);
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.assertEquals("XWING",res);
    }

    @Test
    public void getShapeFromSequence_unidentifiedIn_returnsNull()
    {
        Move m=new Move();
        String res="CHEESE";
        try
        {
            res=m.getShapeFromSequence(_unidentified,_mockDict);
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.assertEquals(null,res);
    }

    @Test
    public void getShapeFromSequence_UnidentifiedIrregularIn_returnsNull()
    {
        Move m=new Move();
        String res="CHEESE";
        try
        {
            res=m.getShapeFromSequence(_unidentifiedIrregular,_mockDict);
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.assertEquals(null,res);
    }
}
