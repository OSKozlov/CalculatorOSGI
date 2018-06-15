package com.muntian.calculator.controller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.muntian.calculator.listeners.ListenerForButtonCalculate;
import com.muntian.calculator.listeners.ModifyListenerForFirstOperand;
import com.muntian.calculator.listeners.ModifyListenerForSecondOperand;
import com.muntian.calculator.listeners.SelectionAdapterForCheckBox;
import com.muntian.calculator.listeners.SelectionAdapterForMathOperator;
import com.muntian.calculator.listeners.VerifyListenerForOperand;
import com.muntian.calculator.logic.Calculations;
import com.muntian.calculator.logic.MathData;
import com.muntian.calculator.mathservice.SimpleCalculatorImpl;
import com.muntian.calculator.ui.MainPanel;
import com.muntian.calculator.ui.MathOperationPanel;

public class CalcController {
	
	
	private MathData mathData;
	
	private Calculations calculation;
	
	private MathOperationPanel mathOperationPanel;
	
	public CalcController() {
		
		mathData = new MathData();
		calculation = new Calculations(new SimpleCalculatorImpl());
		mathData.registerObserver(calculation);
		
		MainPanel mainPanel = MainPanel.getInstance();
		mathOperationPanel = mainPanel.getMathOperationPanel();
		initActions();
	}
	
	private void initActions() {		
		mathOperationPanel.getFirstNumber().addModifyListener(new ModifyListenerForFirstOperand(mathData));
		mathOperationPanel.getFirstNumber().addListener(SWT.Verify, new VerifyListenerForOperand());
		mathOperationPanel.getSecondNumber().addModifyListener(new ModifyListenerForSecondOperand(mathData));
		mathOperationPanel.getSecondNumber().addListener(SWT.Verify, new VerifyListenerForOperand());
		mathOperationPanel.getMathOperator().addSelectionListener(new SelectionAdapterForMathOperator(mathData));
		mathOperationPanel.getCheckBoxOnFlyMode().addSelectionListener(new SelectionAdapterForCheckBox(mathData));
		mathOperationPanel.getBtnCalculate().addListener(SWT.Selection, new ListenerForButtonCalculate(mathData));
	}
	
}
