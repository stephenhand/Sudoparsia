package com.Sudoki.Sudoparsia;

import java.util.AbstractSequentialList;
import java.util.EnumSet;
import java.util.LinkedList;

import com.Sudoki.Sudoparsia.config.IColourSettings;
import com.Sudoki.Sudoparsia.config.PatternException;
import com.Sudoki.Sudoparsia.util.LinkedListExpansion;

public class DecodedLine
{
	private LoopType _loop;
	private AbstractSequentialList<ColourSection> _colorSections=new LinkedList<ColourSection>();
	public AbstractSequentialList<ColourSection> getColorSections() {
		return _colorSections;
	}
	public void setColorSections(AbstractSequentialList<ColourSection> _colorSections) {
		this._colorSections = _colorSections;
	}
	public LoopType getLoop() {
		return _loop;
	}
	public void setLoop(LoopType loop) {
		this._loop = loop;
	}

    public AbstractSequentialList<Statement> getAllStatements(IColourSettings cset) throws PatternException {
         return getStatmentsSubset(cset, EnumSet.of(LineSectionType.MultiPurpose, LineSectionType.Logical), EnumSet.of(LineSectionType.Logical));
    }

    public AbstractSequentialList<Statement> getLoopStatements(IColourSettings cset) throws PatternException
    {
        return getStatmentsSubset(cset,EnumSet.of(LineSectionType.Logical),EnumSet.of(LineSectionType.Logical));
    }


    private AbstractSequentialList<Statement> getStatmentsSubset(IColourSettings cset,EnumSet<LineSectionType> validTypes, EnumSet<LineSectionType> requiredTypes) throws PatternException
    {
        AbstractSequentialList<AbstractSequentialList<Statement>> allStatements=new LinkedList<AbstractSequentialList<Statement>>();
        for (ColourSection cs:_colorSections)
        {
            if (validTypes.contains(cset.getSectionType(cs.getState())))
            {
                if (cs.getStatements().size()==0)
                {
                    if (requiredTypes.contains(cset.getSectionType(cs.getState())))
                    {
                        throw new IllegalStateException("Colour Sections must be decoded before allStatements can be accessed");
                    }
                }
                else
                {
                    allStatements.add(cs.getStatements());
                }
            }
        }

        return new LinkedListExpansion<Statement>(allStatements);
    }


}