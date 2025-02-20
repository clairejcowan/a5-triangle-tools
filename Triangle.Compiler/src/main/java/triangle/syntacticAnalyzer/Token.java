/*
 * @(#)Token.java                       
 * 
 * Revisions and updates (c) 2022-2023 Sandy Brownlee. alexander.brownlee@stir.ac.uk
 * 
 * Original release:
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package triangle.syntacticAnalyzer;

final class Token extends Object {

	protected int kind;
	protected String spelling;
	protected SourcePosition position;

	public Token(int kind, String spelling, SourcePosition position) {

		if (kind == Token.IDENTIFIER) {
			int currentKind = firstReservedWord;
			boolean searching = true;

			while (searching) {
				int comparison = tokenTable[currentKind].compareTo(spelling);
				if (comparison == 0) {
					this.kind = currentKind;
					searching = false;
				} else if (comparison > 0 || currentKind == lastReservedWord) {
					this.kind = Token.IDENTIFIER;
					searching = false;
				} else {
					currentKind++;
				}
			}
		} else
			this.kind = kind;

		this.spelling = spelling;
		this.position = position;

	}

	public static String spell(int kind) {
		return tokenTable[kind];
	}

	@Override
	public String toString() {
		return "Kind=" + kind + ", spelling=" + spelling + ", position=" + position;
	}

	// Token classes...

	public static final int

	// literals, identifiers, operators...
	INTLITERAL = 0, CHARLITERAL = 1, IDENTIFIER = 2, OPERATOR = 3,

			// reserved words - must be in alphabetical order...
<<<<<<< HEAD
			ARRAY = 4, BEGIN = 5, CONST = 6, DO = 7, ELSE = 8, END = 9, FUNC = 10, IF = 11, IN = 12, LET = 13,
			LOOP = 14, //Task 6.a add new LOOP token
			OF = 15, PROC = 16, RECORD = 17, REPEAT = 18, THEN = 19, TYPE = 20, UNTIL = 21, VAR = 22, WHILE = 23,

			// punctuation...
			DOT = 24, COLON = 25, SEMICOLON = 26, COMMA = 27, BECOMES = 28, IS = 29,

			// brackets...
			LPAREN = 30, RPAREN = 31, LBRACKET = 32, RBRACKET = 33, LCURLY = 34, RCURLY = 35,

			// special tokens...
			EOT = 36, ERROR = 37;

	private static String[] tokenTable = new String[] { "<int>", "<char>", "<identifier>", "<operator>", "array",
			"begin", "const", "do", "else", "end", "func", "if", "in", "let",
			"loop", //Task 6.a add new LOOP key word to token table
			"of", "proc", "record", "repeat", "then",
=======
			ARRAY = 4, BEGIN = 5, CONST = 6, DO = 7, ELSE = 8, END = 9, FUNC = 10, IF = 11, IN = 12, LET = 13, OF = 14,
			PROC = 15, RECORD = 16, REPEAT = 17, THEN = 18,  TYPE = 19, UNTIL = 20, VAR = 21, WHILE = 22,

			// punctuation...
			DOT = 23, COLON = 24, SEMICOLON = 25, COMMA = 26, BECOMES = 27, IS = 28,

			// brackets...
			LPAREN = 29, RPAREN = 30, LBRACKET = 31, RBRACKET = 32, LCURLY = 33, RCURLY = 34,

			// special tokens...
			EOT = 35, ERROR = 36;

	private static String[] tokenTable = new String[] { "<int>", "<char>", "<identifier>", "<operator>", "array",
			"begin", "const", "do", "else", "end", "func", "if", "in", "let", "of", "proc", "record", "repeat", "then",
>>>>>>> a15935a019d310364b660e764b41eec26759f780
			"type", "until", "var", "while", ".", ":", ";", ",", ":=", "~", "(", ")", "[", "]", "{", "}", "", "<error>" };

	private final static int firstReservedWord = Token.ARRAY, lastReservedWord = Token.WHILE;

}
