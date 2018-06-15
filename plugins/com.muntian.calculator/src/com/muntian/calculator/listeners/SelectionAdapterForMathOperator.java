package com.muntian.calculator.listeners;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.muntian.calculator.logic.MathData;
import com.muntian.calculator.ui.MainPanel;
import com.muntian.calculator.ui.MathOperationPanel;

public class SelectionAdapterForMathOperator extends SelectionAdapter {
	
	private MathOperationPanel mathOperationPanel = MainPanel.getInstance().getMathOperationPanel();
	private MathData mathData;
	
	public SelectionAdapterForMathOperator(MathData mathData) {
		this.mathData = mathData;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		mathData.setOnFlyMode(mathOperationPanel.getCheckBoxOnFlyMode().getSelection());
		if (mathOperationPanel.getCheckBoxOnFlyMode().getSelection()) {
			mathOperationPanel.getBtnCalculate().setEnabled(false);
		} else {
			mathOperationPanel.getBtnCalculate().setEnabled(true);
		}
	}
}