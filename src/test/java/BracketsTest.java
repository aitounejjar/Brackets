import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by maitoune on 11/01/17.
 */

public class BracketsTest extends TestCase {

    @Test
    public void test_empty() {
        boolean expected = false;
        boolean result = Brackets.isWellFormed("");
        Assert.assertEquals(result, expected);
    }

    @Test
    public void test_null() {
        boolean expected = false;
        boolean result = Brackets.isWellFormed(null);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void test_nonBracketCharacters() {
        Assert.assertEquals(false, Brackets.isWellFormed("(a)"));
        Assert.assertEquals(false, Brackets.isWellFormed("()a"));
        Assert.assertEquals(false, Brackets.isWellFormed("(123)"));
        Assert.assertEquals(false, Brackets.isWellFormed("({-})"));
        Assert.assertEquals(false, Brackets.isWellFormed("[[x[]]]"));
        Assert.assertEquals(false, Brackets.isWellFormed("[[[[[[[[[[[[[]]]]]]]]]]]]]]]{}{}{}{}{}'{}{}{}{}{}()(((("));
    }

    @Test
    public void test_openingsAndClosings() {
        Assert.assertEquals(true, Brackets.isWellFormed("[({})]"));
        Assert.assertEquals(true, Brackets.isWellFormed("{}{}{}()()(){[[[({[]})]]]}"));
        Assert.assertEquals(true, Brackets.isWellFormed("{}(){}()[][][]{}()[]"));
        Assert.assertEquals(true, Brackets.isWellFormed("{[{[({[[[]]]})]}]}"));
        Assert.assertEquals(false, Brackets.isWellFormed("{}}"));
        Assert.assertEquals(false, Brackets.isWellFormed("{{}}]"));
        Assert.assertEquals(false, Brackets.isWellFormed("(()"));
        Assert.assertEquals(false, Brackets.isWellFormed("({)}"));
        Assert.assertEquals(true, Brackets.isWellFormed("[(){}]")); // TBD: flagged as false by the provided results.txt

    }

    @Test()
    public void test_rule_1() {
        // Inside parenthesis () only braces {} are allowed
        Assert.assertEquals(true, Brackets.isWellFormed("({})"));
        Assert.assertEquals(false, Brackets.isWellFormed("([])"));
        Assert.assertEquals(false, Brackets.isWellFormed("(())"));
    }

    @Test
    public void test_rule_2() {
        // Inside braces {} only square brackets [] are allowed
        Assert.assertEquals(true, Brackets.isWellFormed("{[]}"));
        Assert.assertEquals(false, Brackets.isWellFormed("{()}"));
        Assert.assertEquals(false, Brackets.isWellFormed("{{}}"));
    }

    @Test
    public void test_rule_3() {
        // Inside parenthesis () only braces {} are allowed
        Assert.assertEquals(true, Brackets.isWellFormed("[()]"));
        Assert.assertEquals(true, Brackets.isWellFormed("[{}]"));
        Assert.assertEquals(true, Brackets.isWellFormed("[[]]"));
        Assert.assertEquals(true, Brackets.isWellFormed("[[[]]]"));
        Assert.assertEquals(false, Brackets.isWellFormed("[([])]"));
    }

    @Test
    public void test_rule_4() {
        // You can use a list of braces where a single one is allowed of that type
        Assert.assertEquals(true, Brackets.isWellFormed("[()()]"));
        Assert.assertEquals(true, Brackets.isWellFormed("{[][()()]}"));
        Assert.assertEquals(true, Brackets.isWellFormed("()()"));
    }

}
