package com.muntian.calculator.listeners;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.muntian.calculator.logic.MathData;
import com.muntian.calculator.ui.MainPanel;
import com.muntian.calculator.ui.MathOperationPanel;

public class ListenerForButtonCalculate implements Listener {
	
	private MathOperationPanel mathOperationPanel = MainPanel.getInstance().getMathOperationPanel();
	private MathData mathData;
	
	public ListenerForButtonCalculate(MathData mathData) {
		this.mathData = mathData;
	}
	
	@Override
	public void handleEvent(Event event) {
		switch (event.type) {
		case SWT.Selection:

			mathData.setFirstOperand(Double.parseDouble(mathOperationPanel.getFirstNumber().getText()));
			mathData.setSecondOperand(Double.parseDouble(mathOperationPanel.getSecondNumber().getText()));
			mathData.setSign(mathOperationPanel.getMathOperator().getText());

			break;
		}
	}
}
