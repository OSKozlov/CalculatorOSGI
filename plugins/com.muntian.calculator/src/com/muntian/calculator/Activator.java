package com.muntian.calculator;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.muntian.calculator.controller.CalcController;
import com.muntian.calculator.ui.MainPanel;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("### Start application !!!!");

		CalcController calcController = new CalcController();
		
		Shell shell = MainPanel.getInstance().getShell();
		Display display = MainPanel.getInstance().getDisplay();
		shell.setLocation(750, 200);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}


	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("### Stop application !!!!");
		MainPanel.getInstance().getDisplay().dispose();
	}
	
}
