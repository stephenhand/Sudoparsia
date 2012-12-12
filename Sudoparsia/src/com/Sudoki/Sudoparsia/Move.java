package com.Sudoki.Sudoparsia;


import com.Sudoki.Sudoparsia.config.IShapeDictionary;
import com.Sudoki.Sudoparsia.config.ShapeException;
import com.Sudoki.Sudoparsia.util.PrimitiveBox;

import java.util.AbstractSequentialList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Move implements IMove {

	@Override
	public String getShapeFromSequence(AbstractSequentialList<Statement> sequence,IShapeDictionary dict) throws ShapeException {
        ListIterator<Statement> it=sequence.listIterator();
        if (!it.hasNext())
            return null;
        Statement origin=it.next(),st1=null,st2=origin;
        AbstractSequentialList<MoveType> moves=new LinkedList<MoveType>();
        PrimitiveBox<Boolean> lineMoveTypeIsVertical=new PrimitiveBox<Boolean>(null),thisLineIsVertical=new PrimitiveBox<Boolean>(null);
		while (it.hasNext())
        {
            st1=st2;
            st2=it.next();
            moves.add(getMoveType(st1,st2,origin,lineMoveTypeIsVertical,thisLineIsVertical));
        }
		return dict.LookupShape(moves);
	}

	private MoveType getMoveType(Statement statement1, Statement statement2, Statement originStatement,PrimitiveBox<Boolean> lineMoveTypeIsVertical, PrimitiveBox<Boolean> thisLineIsVertical) {

		MoveType mt=null;
        if (statement1.getBox()==statement2.getBox())
		{
            mt= MoveType.Box;
            thisLineIsVertical.value=null;
		}
		if (statement1.getColumn()==statement2.getColumn())
		{
            if (lineMoveTypeIsVertical.value==null)
            {
                lineMoveTypeIsVertical.value=true;
            }
            mt=  lineMoveTypeIsVertical.value?MoveType.Line:MoveType.Perpendicular;

            thisLineIsVertical.value=true;
		}
		if (statement1.getRow()==statement2.getRow())
		{
            if (lineMoveTypeIsVertical.value==null)
            {
                lineMoveTypeIsVertical.value=false;
            }
            mt= (! lineMoveTypeIsVertical.value)?MoveType.Line:MoveType.Perpendicular;
            thisLineIsVertical.value=false;
        }
        if (mt==MoveType.Perpendicular && statement2.getColumn()==originStatement.getColumn() && statement2.getRow()==statement2.getRow())
        {
            mt=MoveType.PerpendicularReturn;
        }
		return mt==null?MoveType.Irregular:mt;
	}

}
