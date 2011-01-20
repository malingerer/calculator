package org.nathalie.calculator;

interface Operation {
	
	double perform(double a, double b) throws IncorectOperationException;
}
