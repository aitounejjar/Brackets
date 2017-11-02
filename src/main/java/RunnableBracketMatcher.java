/**
 * Created by mouhcine on 2017-11-01.
 */

public class RunnableBracketMatcher implements Runnable {

    private int mOrder;
    private String mBrackets;

    public RunnableBracketMatcher(int pOrder, String pBrackets) {
        mOrder = pOrder;
        mBrackets = pBrackets;
    }

    public void run() {
        System.out.println(mOrder + ":" + Brackets.isWellFormed(mBrackets));
    }
}
