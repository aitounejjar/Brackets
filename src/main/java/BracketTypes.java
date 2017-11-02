/**
 * Created by Mouhcine on 11/02/17.
 */

public enum BracketTypes {
    LEFT_PAREN ('(', ')', true), RIGHT_PAREN (')', '(', false),
    LEFT_CURLY ('{', '}', true), RIGHT_CURLY ('}', '{', false),
    LEFT_SQUARE('[', ']', true), RIGHT_SQUARE(']', '[', false);

    private char mChar;
    private char mOtherChar;
    private boolean mIsLeft;

    BracketTypes(char pChar, char pOtherChar, boolean pIsLeft) {
        mChar = pChar;
        mOtherChar = pOtherChar;
        mIsLeft = pIsLeft;
    }

    public char getChar() {
        return mChar;
    }

    public char getClosingChar() {
        return mOtherChar;
    }

    public boolean isLeft() {
        return mIsLeft;
    }

    public boolean isRight() {
        return !mIsLeft;
    }
}
