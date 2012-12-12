package com.Sudoki.Sudoparsia;

import com.Sudoki.Sudoparsia.config.IColourSettings;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;


import java.util.AbstractSequentialList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 06/04/12
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
public class DecodedLineTest {

    private static AbstractSequentialList<ColourSection> _testSections=new LinkedList<ColourSection>(),_undecodedSections=new LinkedList<ColourSection>();
    private static IColourSettings _mockCs;

    @BeforeClass
    public static void SetUp()
    {
        _mockCs= Mockito.mock(IColourSettings.class);
        Mockito.when(_mockCs.getSectionType(AdditionalMatchers.and(AdditionalMatchers.not(Mockito.eq(LogicColourState.Lassoo)),AdditionalMatchers.not(Mockito.eq(LogicColourState.Default))))).thenReturn(LineSectionType.Logical);
        Mockito.when(_mockCs.getSectionType(LogicColourState.Lassoo)).thenReturn(LineSectionType.Descriptive);
        Mockito.when(_mockCs.getSectionType(LogicColourState.Default)).thenReturn(LineSectionType.MultiPurpose);

        Statement newStatement;
        AbstractSequentialList<Statement> newStatements;

        ColourSection newSection=new ColourSection();
        newSection.setState(LogicColourState.Default);
        newSection.setText("D(3)");
        _testSections.add(newSection);

        newSection=new ColourSection();
        newSection.setState(LogicColourState.Lassoo);
        newSection.setText("8[R1C4]...5[R1C4]");
        _testSections.add(newSection);


        newSection=new ColourSection();
        newSection.setState(LogicColourState.Default);
        newSection.setText("!8[R1C4]=>5[R1C4]->!5[R1C2]=>5[R6C2]->");
        newStatements=new LinkedList<Statement>();

        newStatement=new Statement();
        newStatement.setRow(1);
        newStatement.setColumn(4);
        newStatement.setValue(8);
        newStatement.setStartInference(Statement.Inference.None);
        newStatement.setEndInference(Statement.Inference.Strong);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(1);
        newStatement.setColumn(4);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.Weak);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(1);
        newStatement.setColumn(2);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Weak);
        newStatement.setEndInference(Statement.Inference.Strong);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(6);
        newStatement.setColumn(2);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.Weak);
        newStatements.add(newStatement);

        newSection.setStatements(newStatements);

        _testSections.add(newSection);


        newSection=new ColourSection();
        newSection.setState(LogicColourState.Discontinuity);
        newSection.setText("!9[R6C2]=>9[R6C6]->!6[R6C6]=>6[R9C6]->!6[R9C5]=>5[R9C5]->!5[R5C5]=>5[R5C3]");
        newStatements=new LinkedList<Statement>();

        newStatement=new Statement();
        newStatement.setRow(6);
        newStatement.setColumn(2);
        newStatement.setValue(9);
        newStatement.setStartInference(Statement.Inference.None);
        newStatement.setEndInference(Statement.Inference.Strong);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(6);
        newStatement.setColumn(6);
        newStatement.setValue(9);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.Weak);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(6);
        newStatement.setColumn(6);
        newStatement.setValue(6);
        newStatement.setStartInference(Statement.Inference.Weak);
        newStatement.setEndInference(Statement.Inference.Strong);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(9);
        newStatement.setColumn(6);
        newStatement.setValue(6);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.Weak);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(9);
        newStatement.setColumn(5);
        newStatement.setValue(6);
        newStatement.setStartInference(Statement.Inference.Weak);
        newStatement.setEndInference(Statement.Inference.Strong);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(9);
        newStatement.setColumn(5);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.Weak);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(5);
        newStatement.setColumn(5);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Weak);
        newStatement.setEndInference(Statement.Inference.Strong);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(5);
        newStatement.setColumn(3);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.None);
        newStatements.add(newStatement);

        newSection.setStatements(newStatements);

        _testSections.add(newSection);


        newSection=new ColourSection();
        newSection.setState(LogicColourState.ExclusionNegative);
        newSection.setText("->!5[R6C2]");
        newStatements=new LinkedList<Statement>();

        newStatement=new Statement();
        newStatement.setRow(6);
        newStatement.setColumn(2);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Weak);
        newStatement.setEndInference(Statement.Inference.None);
        newStatements.add(newStatement);

        newSection.setStatements(newStatements);

        _testSections.add(newSection);


        newSection=new ColourSection();
        newSection.setState(LogicColourState.Default);
        newSection.setText("=>5[R1C2]->!5[R1C4]");
        newStatements=new LinkedList<Statement>();

        newStatement=new Statement();
        newStatement.setRow(1);
        newStatement.setColumn(2);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Strong);
        newStatement.setEndInference(Statement.Inference.Weak);
        newStatements.add(newStatement);

        newStatement=new Statement();
        newStatement.setRow(1);
        newStatement.setColumn(4);
        newStatement.setValue(5);
        newStatement.setStartInference(Statement.Inference.Weak);
        newStatement.setEndInference(Statement.Inference.None);
        newStatements.add(newStatement);

        newSection.setStatements(newStatements);

        _testSections.add(newSection);



        newSection=new ColourSection();
        newSection.setState(LogicColourState.Default);
        newSection.setText("AIC1 !7[R8C5]=>7[R5C5]->!7[R5C9]=>7[R9C9]");
        _undecodedSections.add(newSection);


    }

    @Before
    public void setupTest()
    {
        //Reset undecoded section type to default state to ensure tinkering in prior tests is reversed
        _undecodedSections.get(0).setState(LogicColourState.Default);
    }


    @Test
    public void getAllStatements_EmptyLine_ReturnsEmptyList()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(new LinkedList<ColourSection>());
        empty.setLoop(LoopType.Unidentified);
        AbstractSequentialList<Statement> res;

        try
        {
            res=empty.getAllStatements(_mockCs);
            Assert.assertEquals(0,res.size());
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void getAllStatements_ValidLine_ReturnsCorrectList()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(_testSections);
        empty.setLoop(LoopType.DiscontinuousLoop);
        AbstractSequentialList<Statement> res;

        try
        {
            res=empty.getAllStatements(_mockCs);
            Assert.assertEquals(15,res.size());
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void getAllStatements_DefaultUnDecodedLine_ReturnsEmptyList()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(_undecodedSections);
        empty.setLoop(LoopType.AlternatingInferenceChain1);
        AbstractSequentialList<Statement> res;

        try
        {
            res=empty.getAllStatements(_mockCs);
            Assert.assertEquals(0,res.size());
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
    }


    @Test
    public void getAllStatements_LogicUndecodedLine_ThrowsInvalidState()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(_undecodedSections);
        empty.setLoop(LoopType.AlternatingInferenceChain1);
        empty.getColorSections().get(0).setState(LogicColourState.InferencePositive);
        AbstractSequentialList<Statement> res;

        try
        {
            empty.getAllStatements(_mockCs);
        }
        catch (IllegalStateException e)
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
    public void getLoopStatements_EmptyLine_ReturnsEmptyList()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(new LinkedList<ColourSection>());
        empty.setLoop(LoopType.Unidentified);
        AbstractSequentialList<Statement> res;

        try
        {
            res=empty.getLoopStatements(_mockCs);
            Assert.assertEquals(0,res.size());
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void getLoopStatements_ValidLine_ReturnsCorrectList()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(_testSections);
        empty.setLoop(LoopType.DiscontinuousLoop);
        AbstractSequentialList<Statement> res;

        try
        {
            res=empty.getLoopStatements(_mockCs);
            Assert.assertEquals(9,res.size());
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
    }

    @Test
    public void getLoopStatements_DefaultUnDecodedLine_ReturnsEmptyList()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(_undecodedSections);
        empty.setLoop(LoopType.AlternatingInferenceChain1);
        AbstractSequentialList<Statement> res;

        try
        {
            res=empty.getLoopStatements(_mockCs);
            Assert.assertEquals(0,res.size());
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
    }


    @Test
    public void getLoopStatements_LogicUndecodedLine_ThrowsInvalidState()
    {
        DecodedLine empty=new DecodedLine();
        empty.setColorSections(_undecodedSections);
        empty.setLoop(LoopType.AlternatingInferenceChain1);
        empty.getColorSections().get(0).setState(LogicColourState.InferencePositive);
        AbstractSequentialList<Statement> res;

        try
        {
            empty.getLoopStatements(_mockCs);
        }
        catch (IllegalStateException e)
        {
            return;
        }
        catch (Exception e)
        {
            Assert.fail("Exception: "+e.getMessage());
        }
        Assert.fail("No Exception");
    }}
