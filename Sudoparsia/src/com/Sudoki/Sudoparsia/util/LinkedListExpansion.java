package com.Sudoki.Sudoparsia.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 06/04/12
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListExpansion<T> extends AbstractSequentialList<T> {
    private AbstractSequentialList<AbstractSequentialList<T>> _source;
    public LinkedListExpansion(AbstractSequentialList<AbstractSequentialList<T>> source)
    {
        _source=source;
    }
    @Override
    public ListIterator<T> listIterator(int index) {

        ExpansionIterator<T> iterator=new ExpansionIterator<T>(this);

        iterator.setPos(index);
        return iterator;
    }

    @Override
    public int size() {
        int i=0 ;
        for(AbstractSequentialList<T> sublist: _source)
        {
            i+=sublist.size();
        }
        return i;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public class ExpansionIterator<T> implements ListIterator<T>
    {
        private ListIterator<T> _currentIt=null;
        private ListIterator<AbstractSequentialList<T>> _currentSubListIt=null;
        private LinkedListExpansion<T> _data;

        private void setPos(int index)
        {
            _currentSubListIt =_data._source.listIterator();
            if (index==0)
            {
                _currentIt=_currentSubListIt.next().listIterator();
                return;
            }
            int counter=0;
            while (counter<index)
            {
                AbstractSequentialList<T> currentSublist=_currentSubListIt.next();
                _currentIt=currentSublist.listIterator();
                while (counter<index && _currentIt.hasNext())
                {
                    _currentIt.next();
                    counter++;
                }
            }


        }




        public ExpansionIterator(LinkedListExpansion<T> data)
        {
            _data=data;
            if (_data._source.size()>0)
            {
                AbstractSequentialList<T> subList=data._source.get(0);
            }
        }

        @Override
        public boolean hasNext() {
            if (_currentIt.hasNext())
            {
                return true;
            }
            ListIterator<AbstractSequentialList<T>> checkIt=_data._source.listIterator(_currentSubListIt.nextIndex());
            while (checkIt.hasNext())
            {
                if (checkIt.next().iterator().hasNext())
                {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {

            if (_currentIt.hasNext())
            {
                 return _currentIt.next();
            }
            else
            {
                while (_currentSubListIt.hasNext())
                {
                    _currentIt=_currentSubListIt.next().listIterator();
                    if (_currentIt.hasNext())
                    {
                        return _currentIt.next();
                    }
                }
                throw new NoSuchElementException("Attempt to iterate past the end of the list");
            }
        }

        @Override
        public boolean hasPrevious() {
            if (_currentIt.hasPrevious())
            {
                return true;
            }
            ListIterator<AbstractSequentialList<T>> checkIt=_data._source.listIterator();
            int limit=_currentSubListIt.nextIndex();
            while (checkIt.hasNext()&&checkIt.nextIndex()<limit)
            {
                if (checkIt.next().iterator().hasNext())
                {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T previous() {
            if (_currentIt.hasPrevious())
            {
                return _currentIt.previous();
            }
            else
            {
                while (_currentSubListIt.hasPrevious())
                {
                    AbstractSequentialList<T> list=_currentSubListIt.previous();
                    _currentIt=list.listIterator(list.size());
                    if (_currentIt.hasPrevious())
                    {
                        return _currentIt.previous();
                    }
                }
                throw new NoSuchElementException("Attempt to iterate past the start of the list");
            }
        }

        @Override
        public int nextIndex() {
            int listIndex=_currentSubListIt.nextIndex(),i=0;
            ListIterator<AbstractSequentialList<T>> it=_data._source.listIterator();
            int indexCounter=0;
            for (i=0;i<listIndex;i++)
            {

                     indexCounter+=it.next().size();

            }

                return indexCounter+_currentIt.nextIndex();

        }

        @Override
        public int previousIndex() {
            return nextIndex()-1;
        }

        @Override
        public void remove() {
            _currentIt.remove();
        }

        @Override
        public void set(T t) {
            _currentIt.set(t);
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException("Adding via a list expansion is unsupported because the sublist being added to is ambiguous.");
        }
    }

}
