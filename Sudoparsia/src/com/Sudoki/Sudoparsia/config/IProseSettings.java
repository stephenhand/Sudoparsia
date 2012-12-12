package com.Sudoki.Sudoparsia.config;

public interface IProseSettings {
	public String getLassooMask();
	public String getStatementMask();
	public String getExclusionMask();
	public String getInferenceMask();
	public String getLoopShapeMask();
	public String getGenericLoopShapeMask();
	
	public String getShapeMask(String shape);

	
}
