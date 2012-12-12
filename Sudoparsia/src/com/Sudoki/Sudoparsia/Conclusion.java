package com.Sudoki.Sudoparsia;

/**
 * Created with IntelliJ IDEA.
 * User: stephenhand
 * Date: 13/04/12
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
public class Conclusion {
    private ConclusionType _type;
    private Statement _statement;

    public ConclusionType getType() {
        return _type;
    }

    public void setType(ConclusionType _type) {
        this._type = _type;
    }

    public Statement getStatement() {
        return _statement;
    }

    public void setStatement(Statement _statement) {
        this._statement = _statement;
    }
}
