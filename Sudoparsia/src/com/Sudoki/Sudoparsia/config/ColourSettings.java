package com.Sudoki.Sudoparsia.config;

import com.Sudoki.Sudoparsia.LineSectionType;
import com.Sudoki.Sudoparsia.LogicColourState;

import java.awt.Color;
import java.util.HashMap;

public class ColourSettings implements IColourSettings {

	private HashMap<ColourPair,LogicColourState> _lcsmap=new HashMap<ColourPair,LogicColourState>();
	private HashMap<LogicColourState,LineSectionType> _lstmap=new HashMap<LogicColourState,LineSectionType>();

    @Override
	public Color[] getColor(LogicColourState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicColourState getState(Color foreground,Color background) {
		// TODO Auto-generated method stub
		ColourPair cp=new ColourPair(foreground,background);
		if (_lcsmap.containsKey(cp))
		{
			return _lcsmap.get(cp);
		}
		return LogicColourState.Unidentified;
	}

    @Override
    public LineSectionType getSectionType(LogicColourState state) {
        if (_lstmap.containsKey(state))
        {
            return _lstmap.get(state);
        }
        return LineSectionType.Unidentified;
    }

    public void AddMapping(Color foreground,Color background, LogicColourState state)
	{
		_lcsmap.put(new ColourPair(foreground,background), state);
	}

    public void AddSectionTypeMapping(LogicColourState state,LineSectionType sectionType)
    {
        _lstmap.put(state,sectionType);
    }
	
	private class ColourPair
	{
		private Color _foreground,_background;
		
		public ColourPair(Color fore, Color back)
		{
			_foreground=fore;
			_background=back;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((_background == null) ? 0 : _background.hashCode());
			result = prime * result
					+ ((_foreground == null) ? 0 : _foreground.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ColourPair other = (ColourPair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (_background == null) {
				if (other._background != null)
					return false;
			} else if (!_background.equals(other._background))
				return false;
			if (_foreground == null) {
				if (other._foreground != null)
					return false;
			} else if (!_foreground.equals(other._foreground))
				return false;
			return true;
		}

		private ColourSettings getOuterType() {
			return ColourSettings.this;
		}
	}
}
