package com.Sudoki.Sudoparsia;

public class Statement {

	private int _value,_column=-1,_row=-1;
	private Inference _startInference,_endInference;
	private boolean _positive;
	 
	public boolean isPositive() {
		return _positive;
	}

	public void setPositive(boolean _isPositive) {
		this._positive = _isPositive;
	}

	public Inference getStartInference() {
		return _startInference;
	}

	public void setStartInference(Inference _inference) {
		this._startInference = _inference;
	}
	
	public Inference getEndInference() {
		return _endInference;
	}

	public void setEndInference(Inference _inference) {
		this._endInference = _inference;
	}
	
	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		this._value = value;
	}

	public int getColumn() {
		return _column;
	}

	public void setColumn(int column) {
		this._column = column;
	}

	public int getRow() {
		return _row;
	}

	public void setRow(int row) {
		this._row = row;
	}
	
	public int getBox()
	{
		if (_column==-1 || _row==-1)
		{
			return -1;
		}
		return (int)(Math.floor(_column/3)*3+Math.floor(_row/3)+1);
	}
	

	public enum Inference
	{
		Strong,
		Weak,
		Conclusion,
		None
	}
}
