package com.Sudoki.Sudoparsia;

import java.util.AbstractSequentialList;
import java.util.LinkedList;

import com.Sudoki.Sudoparsia.config.IPatternSettings;
import com.Sudoki.Sudoparsia.config.PatternException;

public class ColourSection
{
	private LogicColourState _state;
	private String _text;
	private AbstractSequentialList<Statement> _statements;

    public ColourSection() {
        _statements = new LinkedList<Statement>();
    }

    public void Decode(IPatternSettings patternSettings) throws PatternException{
		setStatements(patternSettings.getStatementsFromSection(_text));
	}
	
	public LogicColourState getState() {
		return _state;
	}
	public void setState(LogicColourState _state) {
		this._state = _state;
	}
	public String getText() {
		return _text;
	}
	public void setText(String _text) {
		this._text = _text;
	}
	public AbstractSequentialList<Statement> getStatements() {
		return _statements;
	}
	public void setStatements(AbstractSequentialList<Statement> _statements) {
		this._statements = _statements;
	}
	
}
