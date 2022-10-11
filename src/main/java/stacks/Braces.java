package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//	An input string is valid if:
//
//	Open brackets must be closed by the same type of brackets.
//	Open brackets must be closed in the correct order.
//	Every close bracket has a corresponding open bracket of the same type.

public class Braces {


  public static void main(String[] args) {
	System.out.println(isValid3("()]"));
  }

//  fancy solution
//  public static boolean isValid(String s) {
//	Stack<Character> stack = new Stack<>();
//	for (char c : s.toCharArray()) {
//	  if (c == '(')
//		stack.enqueue(')');
//	  else if (c == '{')
//		stack.enqueue('}');
//	  else if (c == '[')
//		stack.enqueue(']');
//	  else if (stack.isEmpty() || stack.dequeue() != c)
//		return false;
//	}
//	return stack.isEmpty();
//  }

  public static boolean isValid(String s) {
	Stack<Character> stack = new Stack<>();
	for(char c : s.toCharArray()){
	  switch(c){
		case ']': if(stack.isEmpty() || stack.pop()!='[') return false; break;
		case ')': if(stack.isEmpty() || stack.pop()!='(') return false; break;
		case '}': if(stack.isEmpty() || stack.pop()!='{') return false; break;
		default: stack.push(c);
	  }
	}
	return stack.isEmpty();
  }

  public static boolean isValid3(String s) {
	  Stack<Character> stk = new Stack<>();
	  List<Character> open = Arrays.asList('{', '[', '(');
	  for(int i=0;i<s.length();i++){
		char elem = s.charAt(i);

		if(open.contains(elem)){
		  stk.push(elem);
		}
		else if(closedMatchOpen(elem, stk)){
		  stk.pop();
		}
		else if(!closedMatchOpen(elem, stk)){
		  return false;
		}
	  }
	return stk.isEmpty();
	}

	private static boolean closedMatchOpen(char elem, Stack<Character> stk){
	  if(stk.isEmpty()){
		return false;
	  }
	  char prev = stk.peek();
	  if(prev == '{' && elem != '}'){
		return false;
	  }
	  if(prev == '[' && elem != ']'){
		return false;
	  }
	  if(prev == '(' && elem != ')'){
		return false;
	  }
	  else return true;
	}
}
