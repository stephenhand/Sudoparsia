package com.Sudoki.Sudoparsia.config;

import java.util.HashMap;

public class ProseSettings implements IProseSettings {

	private String _lassooMask,_statementMask, _exclusionMask, _inferenceMask, _loopShapeMask, _genericLoopShapeMask;
	private HashMap<String,String> _shapeMask=new HashMap<String,String>();
	@Override
	public String getLassooMask() {
		// TODO Auto-generated method stub
		return _lassooMask;
	}
	public void setLassooMask(String lassooMask) {
		// TODO Auto-generated method stub
		_lassooMask=lassooMask;
	}
	
	@Override
	public String getStatementMask() {
		// TODO Auto-generated method stub
		return _statementMask;
	}
	
	public void setStatementMask(String statementMask) {
		// TODO Auto-generated method stub
		_statementMask=statementMask;
	}
	@Override
	public String getShapeMask(String shape) {
		if (_shapeMask.containsKey(shape))
		{
			_shapeMask.get(shape);
		}
		return null;
	}
	
	public void setShapeMask(String shape,String mask) {
		_shapeMask.put(shape, mask);
	}
	public String getExclusionMask() {
		return _exclusionMask;
	}
	public void setExclusionMask(String _exclusionMask) {
		this._exclusionMask = _exclusionMask;
	}
	public String getInferenceMask() {
		return _inferenceMask;
	}
	public void setInferenceMask(String _inferenceMask) {
		this._inferenceMask = _inferenceMask;
	}
	public String getGenericLoopShapeMask() {
		return _genericLoopShapeMask;
	}
	public void setGenericLoopShapeMask(String _genericLoopShapeMask) {
		this._genericLoopShapeMask = _genericLoopShapeMask;
	}
	public String getLoopShapeMask() {
		return _loopShapeMask;
	}
	public void setLoopShapeMask(String _loopShapeMask) {
		this._loopShapeMask = _loopShapeMask;
	}	

}
