/*
 * @(#)FuncActualParameter.java                       
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

package triangle.abstractSyntaxTrees.actuals;

import triangle.abstractSyntaxTrees.terminals.Identifier;
import triangle.abstractSyntaxTrees.visitors.ActualParameterVisitor;
import triangle.syntacticAnalyzer.SourcePosition;

public class FuncActualParameter extends ActualParameter {

	public FuncActualParameter(Identifier iAST, SourcePosition position) {
		super(position);
		I = iAST;
	}

	public <TArg, TResult> TResult visit(ActualParameterVisitor<TArg, TResult> v, TArg arg) {
		return v.visitFuncActualParameter(this, arg);
	}

	public final Identifier I;
}
