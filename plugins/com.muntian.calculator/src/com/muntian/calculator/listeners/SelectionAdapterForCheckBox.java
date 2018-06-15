package com.muntian.calculator.listeners;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.muntian.calculator.logic.MathData;
import com.muntian.calculator.ui.MainPanel;
import com.muntian.calculator.ui.MathOperationPanel;

public class SelectionAdapterForCheckBox extends SelectionAdapter {
	
	private MathOperationPanel mathOperationPanel = MainPanel.getInstance().getMathOperationPanel();
	private MathData mathData;
	
	public SelectionAdapterForCheckBox(MathData mathData) {
		this.mathData = mathData;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if (mathOperationPanel.getCheckBoxOnFlyMode().getSelection()) {
			mathData.setSign(mathOperationPanel.getMathOperator().getText());
		}
	}
}