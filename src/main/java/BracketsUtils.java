import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Mouhcine on 11/01/17.
 */
public class BracketsUtils {

    private BracketsUtils() {
        // only exists to defeat instantiation
    }

    private static final Map<Character, BracketTypes> sMap = new HashMap<Character, BracketTypes>() {{
        put('(', BracketTypes.LEFT_PAREN);
        put(')', BracketTypes.RIGHT_PAREN);
        put('[', BracketTypes.LEFT_SQUARE);
        put(']', BracketTypes.RIGHT_SQUARE);
        put('{', BracketTypes.LEFT_CURLY);
        put('}', BracketTypes.RIGHT_CURLY);
    }};

    // matches any character that's neither a left nor a right parenthesis, brace or square bracket
    private static final String regex = ".*[^()\\[\\]{}].*";

    public static boolean isWellFormed(String pString) {

        // strings that are null/empty and strings with an odd length
        if (pString == null || pString.isEmpty() || pString.length()%2 != 0) {
            return false;
        }

        if (pString.matches(regex)) {
            return false;
        }

        // now we're guaranteed that our String contains only brackets
        Stack<Character> stack = new Stack<>();

        boolean leftSquareRead = false;
        for (int i=0; i<pString.length(); ++i) {
            char c = pString.charAt(i);
            BracketTypes bracket = sMap.get(c);
            if (bracket.isLeft()) {
                if (!stack.isEmpty()) {
                    boolean isAllowed = isAllowed(stack.peek(), c);
                    if (!isAllowed) {
                        return false;
                    }
                }
                // add to stack
                stack.add(c);
            } else {
                // char c hols a closing bracket, so the stack's top value must be its matching opening bracket
                if (stack.isEmpty()) {
                    // a closing character has been read, but the stack is empty.
                    return false;
                }
                char top = stack.peek();
                assert sMap.get(top).isLeft() : "Expected a opening bracket at the stack's top, but found a closing one.";
                boolean match = top == bracket.getClosingChar();
                if (match) {
                    // perfect match, so let's remove the element at the top
                    stack.pop();
                } else {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }

    /**
     * @param pLeft1 a left character
     * @param pLeft2 a left character
     * @return true if pLeft2 can appear right after pLeft1
     */
    private static boolean isAllowed(char pLeft1, char pLeft2) {
        boolean result = true;

        if (pLeft1 == BracketTypes.LEFT_PAREN.getChar() &&
                pLeft2 != BracketTypes.LEFT_CURLY.getChar()) {
            result = false;
        }

        if (pLeft1 == BracketTypes.LEFT_CURLY.getChar() &&
                pLeft2 != BracketTypes.LEFT_SQUARE.getChar()) {
            result = false;
        }

        return result;
    }

}
