package com.Sudoki.Sudoparsia.config;

import com.Sudoki.Sudoparsia.MoveType;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 03/04/12
 * Time: 21:45
 * To change this template use File | Settings | File Templates.
 */
public class ShapeTree implements IShapeDictionary {

    private MoveNode _root=new MoveNode();

    @Override
    public String LookupShape(AbstractSequentialList<MoveType> moves) throws ShapeException {
        Iterator it=moves.iterator();
        MoveNode currentNode=_root;
        while (it.hasNext())
        {
            MoveType mt=(MoveType)it.next();
            if (mt==null)
            {
                throw new ShapeException("Null MoveTypes are not permitted");
            }
            if (currentNode._children.containsKey(mt))
            {
                currentNode=currentNode._children.get(mt);
            }
            else
            {
                return null;
            }
        }
        return currentNode.getShape();
    }

    @Override
    public void AddShape(String shape, AbstractSequentialList<MoveType> moves) throws ShapeException
    {
        Iterator it=moves.iterator();
        MoveNode currentNode=_root;
        while (it.hasNext())
        {
              currentNode=currentNode.AddChildIfNew((MoveType)it.next());
        }
        currentNode.setShape(shape);
    }



    public class MoveNode
    {
        public MoveNode AddChildIfNew(MoveType mt) throws ShapeException {
            if (mt==null)
            {
                throw new ShapeException("Null MoveTypes are not permitted");
            }
            if (!_children.containsKey(mt))
            {
                _children.put(mt,new MoveNode(mt));
            }
            return _children.get(mt);
        }

        private String _shape=null;
        private MoveType _move=null;

        public HashMap<MoveType,MoveNode> get_children() {
            return _children;
        }

        public void set_children(HashMap<MoveType,MoveNode> _children) {
            this._children = _children;
        }

        private HashMap<MoveType,MoveNode> _children=new HashMap<MoveType, MoveNode>();


        public String getShape() {
            return _shape;
        }

        public void setShape(String _shape) {
            this._shape = _shape;
        }

        public MoveType getMove() {
            return _move;
        }

        public void setMove(MoveType _move) {
            this._move = _move;
        }

        public MoveNode()
        {}
        public MoveNode(MoveType mt)
        {
            _move=mt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MoveNode node = (MoveNode) o;

            return _move == node._move;

        }

        @Override
        public int hashCode() {
            return _move != null ? _move.hashCode() : 0;
        }
    }

}
