package com.muntian.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MathOperationPanel extends Composite {

	private static final String RESULT = "Result:";
	private static final String CALCULATE = "Calculate";
	private static final String CALCULATE_ON_THE_FLY = "Calculate on the fly";

	private static final String[] items = new String[] { "+", "-", "/", "*" };

	private Text firstNumber;
	private Combo mathOperator;
	private Text secondNumber;
	private Button checkBoxOnFlyMode;
	private Label labelCalcOnTheFly;
	private Button btnCalculate;
	private Label labelResult;
	private Text textResult;

	public MathOperationPanel(Composite parent) {
		super(parent, SWT.NONE);

		createContent(parent);
	}

	public Text getFirstNumber() {
		return firstNumber;
	}

	public Combo getMathOperator() {
		return mathOperator;
	}

	public Text getSecondNumber() {
		return secondNumber;
	}

	public Button getCheckBoxOnFlyMode() {
		return checkBoxOnFlyMode;
	}

	public Label getLabelCalcOnTheFly() {
		return labelCalcOnTheFly;
	}

	public Button getBtnCalculate() {
		return btnCalculate;
	}

	private void createContent(Composite parent) {

		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.verticalSpacing = 85;
		gridLayout.horizontalSpacing = 18;
		setLayout(gridLayout);
		setBackground(parent.getShell().getBackground());

		firstNumber = new Text(this, SWT.BORDER);

		mathOperator = new Combo(this, SWT.DROP_DOWN);
		mathOperator.setItems(items);
		GridData gridData = new GridData(GridData.CENTER, GridData.FILL, false, false);
		gridData.widthHint = 50;
		gridData.heightHint = 5;
		gridData.minimumHeight = 200;
		mathOperator.setLayoutData(gridData);

		secondNumber = new Text(this, SWT.BORDER);

		checkBoxOnFlyMode = new Button(this, SWT.CHECK);

		labelCalcOnTheFly = new Label(this, SWT.NONE);
		labelCalcOnTheFly.setText(CALCULATE_ON_THE_FLY);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalIndent = -70;
		gridData.verticalIndent = 4;
		labelCalcOnTheFly.setLayoutData(gridData);

		btnCalculate = new Button(this, SWT.PUSH);
		btnCalculate.setText(CALCULATE);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalIndent = 10;
		gridData.minimumWidth = 50;
		gridData.minimumHeight = 5;
		btnCalculate.setLayoutData(gridData);

		labelResult = new Label(this, SWT.NONE);
		labelResult.setText(RESULT);

		textResult = new Text(this, SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan = 2;
		textResult.setLayoutData(gridData);
	}

	/**
	 * This method update result field in calculator.
	 * 
	 * @param text
	 */
	public void updateResultField(String text) {
		textResult.setText(text);
	}

}

