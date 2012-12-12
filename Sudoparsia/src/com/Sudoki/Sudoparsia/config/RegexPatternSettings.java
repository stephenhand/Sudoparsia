package com.Sudoki.Sudoparsia.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Sudoki.Sudoparsia.Conclusion;
import com.Sudoki.Sudoparsia.ConclusionType;
import com.Sudoki.Sudoparsia.LoopType;
import com.Sudoki.Sudoparsia.Statement;
import com.Sudoki.Sudoparsia.Statement.Inference;

//Naive
public class RegexPatternSettings implements IPatternSettings {

	
	private <T> T getTypeFromLine(String loopText, List<PatternType<T>> list) throws PatternException {
		T l=null;
		for(PatternType<T> p:list)
		{
			
			Matcher m=p.Pattern.matcher(loopText);
			if (m.find())
			{
				if (l==null)
				{
					l=p.Type;
				}
				else
				{
					throw new PatternException("Ambiguous loop match, text '"+loopText+"' could be either "+l.toString()+" or "+p.Type.toString()+". Fix pattern configuration to eliminate ambiguous matches");
				}
			}
		}
		return l;
	}

    public LoopType getLoopTypeFromLine(String loopText) throws PatternException {
        return getTypeFromLine(loopText,_patternLoops);
    }

    @Override
    public Conclusion getConclusionFromLine(String loopText) throws PatternException {
        Conclusion c=new Conclusion();

        c.setType(getTypeFromLine(loopText,_patternConclusions));  //To change body of implemented methods use File | Settings | File Templates.
        return c;
    }

    private List<PatternType<LoopType>> _patternLoops=new ArrayList<PatternType<LoopType>>();
    private List<PatternType<ConclusionType>> _patternConclusions=new ArrayList<PatternType<ConclusionType>>();
	
	private Pattern _statementPattern,_lassooPattern;
	
	public void AddPatternForLoop(LoopType loop, java.util.regex.Pattern pattern)
	{
		_patternLoops.add(new PatternType<LoopType>(loop,pattern));
	}

    public void AddPatternForConclusionType(ConclusionType conc, java.util.regex.Pattern pattern)
    {
        _patternConclusions.add(new PatternType<ConclusionType>(conc,pattern));
    }

	@Override
	public LinkedList<Statement> getStatementsFromSection(String colourSection)
			throws PatternException {
		Matcher m=_statementPattern.matcher(colourSection);
		Statement newStatement;
		LinkedList<Statement> list=new LinkedList<Statement>();
		while(m.find())
		{
			newStatement=new Statement();

			newStatement.setEndInference(infFromStr(m.group(1)));
			String temp=m.group(2);
			if (temp.equals("!"))
			{
				newStatement.setPositive(false);
				
			}
			else if (temp.equals(""))
			{
				newStatement.setPositive(true);				
			}
			newStatement.setValue(Integer.valueOf(m.group(3)));
			newStatement.setRow(Integer.valueOf(m.group(4)));
			newStatement.setColumn(Integer.valueOf(m.group(5)));
			newStatement.setEndInference(infFromStr(m.group(6)));
			list.add(newStatement);
		}
		return list;
	}
	
	private Inference infFromStr(String in)
	{
		if (in.equals("=>"))
		{
			return Inference.Strong;
			
		}
		else if (in.equals("->"))
		{
			return Inference.Weak;				
		}
		else
		{
			return Inference.None;				
		}		
	}

	public Pattern getStatementPattern() {
		return _statementPattern;
	}

	public void setStatementPattern(Pattern _statementPattern) {
		this._statementPattern = _statementPattern;
	}

	@Override
	public Statement[] getLassooSection(String inputLine)
			throws PatternException {
		
		return null;
	}

	public Pattern getLassooPattern() {
		return _lassooPattern;
	}

	public void setLassooPattern(Pattern _lassooPattern) {
		this._lassooPattern = _lassooPattern;
	}
}
