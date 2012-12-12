package com.Sudoki.Sudoparsia.util;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 09/04/12
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 * Generic class to act as a box for primitive reference type parameters
*/

public class PrimitiveBox<T> {
    public T value=null;

    public PrimitiveBox(T val)
    {value=val;}

}
