package com.Sudoki.Sudoparsia.config;

public class ConfigData implements IConfigData {

	private IColourSettings _colourSettings;
	private IPatternSettings _patternSettings;
	private IProseSettings _proseSettings;
    private IShapeDictionary _shapeDictionary;

	@Override
	public IColourSettings getColourSettings() {
		// TODO Auto-generated method stub
		return _colourSettings;
	}

	@Override
	public IPatternSettings getPatternSettings() {
		// TODO Auto-generated method stub
		return _patternSettings;
	}
	
	
	
	
	public void setPatternSettings(IPatternSettings patternSettings)
	{
		_patternSettings=patternSettings;
	}


	public void setColourSettings(IColourSettings colourSettings) {
		this._colourSettings = colourSettings;
	}

	@Override
	public IProseSettings getProseSettings() {
		// TODO Auto-generated method stub
		return _proseSettings;
	}
	
	public void setProseSettings(IProseSettings proseSettings) {
		this._proseSettings = proseSettings;
	}

    public IShapeDictionary getShapeDictionary() {
        return _shapeDictionary;
    }

    public void setShapeDictionary(IShapeDictionary _shapeDictionary) {
        this._shapeDictionary = _shapeDictionary;
    }
}
