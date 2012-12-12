package com.Sudoki.Sudoparsia.config;

import com.Sudoki.Sudoparsia.MoveType;

import java.util.AbstractSequentialList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 03/04/12
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public interface IShapeDictionary {
    public String LookupShape(AbstractSequentialList<MoveType> moves) throws ShapeException;
    public void AddShape(String shape, AbstractSequentialList<MoveType> moves) throws ShapeException;
}
