import java.util.HashMap;
import java.util.Map;

public class Expression {

	private char op;

	private Expression left;

	private Expression right;

	private int constant;


	private Map<Character, Operator> map;
	
	{
		map = new HashMap<>();
		map.put('c', () -> constant);
		map.put('+', () -> left.evaluate() + right.evaluate());
		map.put('-', () -> left.evaluate() - right.evaluate());
		map.put('/', () -> left.evaluate() / right.evaluate());
		map.put('*', () -> left.evaluate() * right.evaluate());
	}
	
	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}
	

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		/* It is much easier to replace switch with object in JS */
		Operator operator = map.get(op);
		if (operator != null) {
			return operator.evaluate();
		}
	
		throw new IllegalStateException();
		
	}
}
