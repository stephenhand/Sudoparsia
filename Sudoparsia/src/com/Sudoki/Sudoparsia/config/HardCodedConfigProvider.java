package com.Sudoki.Sudoparsia.config;

import com.Sudoki.Sudoparsia.*;

import java.awt.Color;
import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class HardCodedConfigProvider implements IConfigProvider {

	@Override
	public IConfigData Load() throws ShapeException {
		ConfigData cd=new ConfigData();
		RegexPatternSettings re=new RegexPatternSettings();
		re.AddPatternForLoop(LoopType.AlternatingInferenceChain1, Pattern.compile("AIC1"));
		re.AddPatternForLoop(LoopType.AlternatingInferenceChain2, Pattern.compile("AIC2"));
		re.AddPatternForLoop(LoopType.DiscontinuousLoop, Pattern.compile("D\\([0-9]\\)"));
		re.AddPatternForLoop(LoopType.Nice1, Pattern.compile("N1CE"));
		re.AddPatternForLoop(LoopType.Nice2, Pattern.compile("N2CE"));

        re.AddPatternForConclusionType(ConclusionType.Elimination,Pattern.compile("(\\s*)=>!([0-9])\\[R([0-9])C([0-9])]"));
        re.AddPatternForConclusionType(ConclusionType.LoopedInference,Pattern.compile("\\s*\\+looped inference:\\s([0-9])\\[R([0-9])C([0-9])]( via (!?)([0-9])\\[R([0-9])C([0-9])\\])?"));
        re.AddPatternForConclusionType(ConclusionType.Strengthen,Pattern.compile("strengthened\\sR([0-9])C([0-9])!=\\{([0-9])} \\[((?:row)(?:col)(?:cell))\\s(?:R([0-9])C([0-9]))|([0-9])]"));

        re.setStatementPattern(Pattern.compile("(?<=((?:(?:\\=|\\-)\\>)?))(\\!?)([0-9])\\[R([0-9])C([0-9])\\](?=((?:(?:\\=|\\-)\\>)?))"));
		
		re.setLassooPattern(Pattern.compile("(([0-9])\\[R([0-9])C([0-9])\\])\\.\\.\\.(([0-9])\\[R([0-9])C([0-9])\\])"));
		
		cd.setPatternSettings(re);
		
		ColourSettings cs=new ColourSettings();
		cs.AddMapping(Color.GRAY, Color.BLACK, LogicColourState.Default);
		cs.AddMapping(Color.YELLOW, Color.BLACK, LogicColourState.Lassoo);
		cs.AddMapping(Color.RED, Color.BLACK, LogicColourState.Discontinuity);
		cs.AddMapping(Color.GREEN, Color.BLACK, LogicColourState.ContinuousLoop);
		cs.AddMapping(Color.RED, new Color(0x8B0000), LogicColourState.ExclusionNegative);
		cs.AddMapping(Color.WHITE, new Color(0x8B0000), LogicColourState.ExclusionPositive);
		cs.AddMapping(Color.RED, new Color(0x006400), LogicColourState.InferenceNegative);
		cs.AddMapping(Color.WHITE, new Color(0x006400), LogicColourState.InferencePositive);

        cs.AddSectionTypeMapping(LogicColourState.Default, LineSectionType.MultiPurpose);
        cs.AddSectionTypeMapping(LogicColourState.Lassoo, LineSectionType.Descriptive);
        cs.AddSectionTypeMapping(LogicColourState.Discontinuity, LineSectionType.Logical);
        cs.AddSectionTypeMapping(LogicColourState.ContinuousLoop, LineSectionType.Logical);
        cs.AddSectionTypeMapping(LogicColourState.ExclusionNegative, LineSectionType.Logical);
        cs.AddSectionTypeMapping(LogicColourState.ExclusionPositive, LineSectionType.Logical);
        cs.AddSectionTypeMapping(LogicColourState.InferenceNegative, LineSectionType.Logical);
        cs.AddSectionTypeMapping(LogicColourState.InferencePositive, LineSectionType.Logical);


        cd.setColourSettings(cs);

        IShapeDictionary shapeTree=new ShapeTree();
        AbstractSequentialList<MoveType> moves=new LinkedList<MoveType>();
        moves.add(MoveType.Line);
        moves.add(MoveType.Perpendicular);
        moves.add(MoveType.Line);
        shapeTree.AddShape("SKYSCRAPER",moves);

        moves.add(MoveType.Line);
        moves.add(MoveType.Box);
        moves.add(MoveType.Perpendicular);
        shapeTree.AddShape("TWOSTRINGKITE",moves);

		ProseSettings ps=new ProseSettings();
		
		ps.setLassooMask("Lassoo from %d to %d");
		ps.setExclusionMask("Therefore %d cannot be %d");
		ps.setInferenceMask("Therefore we can infer that %d is %d");
		ps.setGenericLoopShapeMask("This complex %d takes the shape illustrated above, starting at %d");
		ps.setLoopShapeMask("This %d is a '%d', starting at %d");
		
		ps.setShapeMask("SKYSCRAPER", "skyscraper");
        ps.setShapeMask("TWOSTRINGKITE", "two string kite");
		cd.setProseSettings(ps);
		
		return cd;
	}

}
