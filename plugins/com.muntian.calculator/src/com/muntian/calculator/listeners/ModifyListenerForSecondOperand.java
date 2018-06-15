package com.muntian.calculator.listeners;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;

import com.muntian.calculator.logic.MathData;
import com.muntian.calculator.ui.MainPanel;
import com.muntian.calculator.ui.MathOperationPanel;

public class ModifyListenerForSecondOperand implements ModifyListener {
	
	private MathOperationPanel mathOperationPanel = MainPanel.getInstance().getMathOperationPanel();
	private MathData mathData;
	
	public ModifyListenerForSecondOperand(MathData mathData) {
		this.mathData = mathData;
	}
	
	@Override
	public void modifyText(ModifyEvent e) {
		Text widget = (Text) e.widget;
		String operand = widget.getText();
		if (mathOperationPanel.getCheckBoxOnFlyMode().getSelection()) {
			System.out.println("Modify listener!!");
			mathData.setSecondOperand(Double.parseDouble(operand));
		}
	}
}