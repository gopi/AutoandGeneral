package com.autogeneral.service;

import com.autogeneral.exception.Detail;
import com.autogeneral.exception.ToDoItemValidationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Stack;

@Service
public class ValidationServiceImpl implements ValidationService {


	private static final Logger LOG = LoggerFactory.getLogger(ValidationServiceImpl.class);

	public ToDoItemValidationError buildValidationError(String input, String text) {
		Detail detail = new Detail();
		detail.setLocation("params");
		detail.setParam(text);
		detail.setMsg("Must be between 1 and 50 chars long");
		detail.setValue(input);
		ToDoItemValidationError toDoItemValidationError = new ToDoItemValidationError(detail, detail.getMsg());
		return toDoItemValidationError;
	}

	@Override
	public Boolean validateText(String input) {
		Boolean result = Boolean.FALSE;
		if (StringUtils.hasLength(StringUtils.trimAllWhitespace(input)) && input.length() <= 50)  {
			result = Boolean.TRUE;
		}
		return result;	}

	@Override
	public Boolean checkBrackets(String input) {
		LOG.debug("Input - " + input.toString());
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {  //this bit checks for balance
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.empty();
	}

	@Override
	public Boolean validateIsComplete(Boolean isCompleted) {
		return null;
	}


}
