package com.Sudoki.Sudoparsia.config;

import com.Sudoki.Sudoparsia.LineSectionType;
import com.Sudoki.Sudoparsia.LogicColourState;
import java.awt.Color;

public interface IColourSettings {
	public Color[] getColor(LogicColourState state);
	public LogicColourState getState(Color foreground, Color background);
    public LineSectionType getSectionType(LogicColourState state);
}
