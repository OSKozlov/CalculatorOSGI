package com.muntian.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainPanel extends Composite {

	private static final String TITLE_CALCULATOR = "Calculator";
	private static final String TITLE_HISTORY = "History";

	private CTabFolder tabFolder;
	private CTabItem tabItemCalc;
	private CTabItem tabItemHistory;
	
	private MathOperationPanel mathOperationPanel;
	private HistoryPanel historyPanel;
	
	private static MainPanel instance;
	
	private static Display display;
	private static Shell shell;
	
	private static final String TITLE_OF_APP = "SWT Calculator";

	static {
		display = new Display();
		shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
	}

	private MainPanel(Composite parent) {
		super(parent, SWT.BORDER);		
		createContent(parent);
	}
	
	public static MainPanel getInstance() {
		shell.setText(TITLE_OF_APP);

		GridLayout gridLayout = new GridLayout();
		shell.setLayout(gridLayout);

		if (instance == null)
            instance = new MainPanel(shell);

        return instance;
	}
	
	private void createContent(Composite parent) {
		tabFolder=new CTabFolder(MainPanel.this, SWT.BORDER);
		GridLayout gridLayout = new GridLayout(1,false);
		tabFolder.setLayout(gridLayout);
		
		GridData gridData = new GridData(SWT.FILL,SWT.FILL,true,true);
		tabFolder.setLayoutData(gridData);
		tabFolder.setSize(280, 280);

		mathOperationPanel = new MathOperationPanel(tabFolder);
		
		tabItemCalc=new CTabItem(tabFolder,SWT.NONE);
		tabItemCalc.setText(TITLE_CALCULATOR);
		tabItemCalc.setControl(mathOperationPanel);
	
		
		historyPanel = new HistoryPanel(tabFolder);
		
		tabItemHistory=new CTabItem(tabFolder,SWT.NONE);
		tabItemHistory.setText(TITLE_HISTORY);
		tabItemHistory.setControl(historyPanel);
	}

	public MathOperationPanel getMathOperationPanel() {
		return mathOperationPanel;
	}

	public HistoryPanel getHistoryPanel() {
		return historyPanel;
	}
	
	public Shell getShell() {
		return shell;
	}
	
	public Display getDisplay() {
		return display;
	}
	
}
