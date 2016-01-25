package iode.ast.nodes;

import java.util.ArrayList;
import java.util.Map;

import iode.ast.Node;
import iode.parsing.IVisitor;

public class ASTFunction extends Node {

	private String name;
	private Map<String, String> args;
	private ArrayList<Node> body;
	private String returnType;
	
	public ASTFunction(String name, Map<String, String> args, ArrayList<Node> body, String returnType) {
		this.name = name;
		this.args = args;
		this.body = body;
		this.returnType = returnType;
	}

	@Override
	public Node visit(IVisitor visitor) {
		return visitor.Visit(this);
	}

	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		
		if (returnType.equals("Void")) {
			sb.append("void ");
		} else if (returnType.equals("Int")) {
			sb.append("int ");
		} else if (returnType.equals("Bool")) {
			sb.append("bool ");
		} else if (returnType.equals("String")) {
			sb.append("string ");
		} else {
			sb.append("void ");
		}
		
		sb.append(name);
		sb.append("(");
		
		if (!args.isEmpty()) {
			for (String name : args.keySet()) {
				sb.append(args.get(name));
				sb.append(" ");
				sb.append(name);
				sb.append(", ");
			}
			
			sb.setLength(sb.length() - 2);
		}
		
		sb.append(") {");
		
		for (Node n : body) {
			sb.append("  ");
			sb.append(n.generate());
			sb.append("\n");
		}
		
		sb.append("}");
		
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

	public ArrayList<Node> getBody() {
		return body;
	}

	public void setBody(ArrayList<Node> body) {
		this.body = body;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
}
