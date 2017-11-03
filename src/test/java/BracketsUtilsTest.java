import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by Mouhcine on 11/01/17.
 */

public class BracketsUtilsTest extends TestCase {

    @Test
    public void test_empty() {
        boolean expected = false;
        boolean result = BracketsUtils.isWellFormed("");
        Assert.assertEquals(result, expected);
    }

    @Test
    public void test_null() {
        boolean expected = false;
        boolean result = BracketsUtils.isWellFormed(null);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void test_nonBracketCharacters() {
        Assert.assertEquals(false, BracketsUtils.isWellFormed("(a)"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("()a"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("(123)"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("({-})"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("[[x[]]]"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("[[[[[[[[[[[[[]]]]]]]]]]]]]]]{}{}{}{}{}'{}{}{}{}{}()(((("));
    }

    @Test
    public void test_openingsAndClosings() {
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[({})]"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("{}{}{}()()(){[[[({[]})]]]}"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("{}(){}()[][][]{}()[]"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("{[{[({[[[]]]})]}]}"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("{}}"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("{{}}]"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("(()"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("({)}"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[[]]"));

        // TBD: flagged as false by the provided results.txt, not sure why.
        Assert.assertEquals(false, BracketsUtils.isWellFormed("[(){}]"));

    }

    @Test()
    public void test_rule_1() {
        // Inside parenthesis () only braces {} are allowed
        Assert.assertEquals(true, BracketsUtils.isWellFormed("({})"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("([])"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("([][][][])"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("(())"));
    }

    @Test
    public void test_rule_2() {
        // Inside braces {} only square brackets [] are allowed
        Assert.assertEquals(true, BracketsUtils.isWellFormed("{[]}"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("{()}"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("{{}}"));
    }

    @Test
    public void test_rule_3() {
        // Any bracket can appear (directly) inside square brackets []
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[()]"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[{}()[]]"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[[]]"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[[[]]]"));
        Assert.assertEquals(false, BracketsUtils.isWellFormed("[([])]"));
    }

    @Test
    public void test_rule_4() {
        // You can use a list of braces where a single one is allowed of that type
        Assert.assertEquals(true, BracketsUtils.isWellFormed("({}{}{}{})"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("[()()]"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("{[][()()]}"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("()()"));
        Assert.assertEquals(true, BracketsUtils.isWellFormed("{[][][][][]}"));
    }

}
