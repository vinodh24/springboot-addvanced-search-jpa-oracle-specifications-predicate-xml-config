package com.vinodh.advanced.search.model;

public enum SearchOperation {

	EQUALITY, EQUAL, NEGATION, GREATER_THAN, LESS_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN_OR_EQUAL, GREATER_THAN_OR_EQUAL_DATE, LESS_THAN_OR_EQUAL_DATE,LIKE, STARTS_WITH, ENDS_WITH, CONTAINS, IN, NOT_IN, NOT_EQUAL;

	public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~", "#" };

	public static SearchOperation getSimpleOperation(final char input) {
		switch (input) {
		case ':':
			return EQUALITY;
		case '!':
			return NEGATION;
		case '>':
			return GREATER_THAN;
		case '<':
			return LESS_THAN;
		case '~':
			return LIKE;
		case '#':
			return IN;
		default:
			return null;
		}
	}

	public static SearchOperation getSimpleOperation(final String input) {
		switch (input) {
		case "contains":
			return LIKE;
		case "ge-date":
			return GREATER_THAN_OR_EQUAL_DATE;
		case "le-date":
			return LESS_THAN_OR_EQUAL_DATE;
		case "startsWith":
			return STARTS_WITH;
		case "is_equal":
			return EQUALITY;
		case "equals":
			return EQUAL;
		case "not_equal":
			return NOT_EQUAL;
		default:
			return null;
		}
	}

}
