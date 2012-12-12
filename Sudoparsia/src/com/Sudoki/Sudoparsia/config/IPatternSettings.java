package com.Sudoki.Sudoparsia.config;

import java.util.LinkedList;

import com.Sudoki.Sudoparsia.Conclusion;
import com.Sudoki.Sudoparsia.ConclusionType;
import com.Sudoki.Sudoparsia.LoopType;
import com.Sudoki.Sudoparsia.Statement;

public interface IPatternSettings {
	LoopType getLoopTypeFromLine(String LoopText) throws PatternException;
    Conclusion getConclusionFromLine(String LoopText) throws PatternException;
	LinkedList<Statement> getStatementsFromSection(String colourSection) throws PatternException;
	Statement[] getLassooSection(String inputLine) throws PatternException;
}
