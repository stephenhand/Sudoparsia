package com.Sudoki.Sudoparsia.config;

import com.Sudoki.Sudoparsia.LoopType;

public class PatternType<T> {

	
	public PatternType(T loop, java.util.regex.Pattern pattern)
	{
		Type=loop;
		Pattern=pattern;
	}
	
	public T Type;
	public java.util.regex.Pattern Pattern;
}
