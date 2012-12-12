package com.Sudoki.Sudoparsia;


import com.Sudoki.Sudoparsia.config.IShapeDictionary;
import com.Sudoki.Sudoparsia.config.ShapeException;
import com.Sudoki.Sudoparsia.util.PrimitiveBox;

import java.util.AbstractSequentialList;

public interface IMove {
	public String getShapeFromSequence(AbstractSequentialList<Statement> sequence,IShapeDictionary dict) throws ShapeException;
	//public MoveType getMoveType(Statement statement1, Statement statement2, Statement originStatement,PrimitiveBox<Boolean> lineMoveTypeIsVertical, PrimitiveBox<Boolean> thisLineIsVertical);
}
