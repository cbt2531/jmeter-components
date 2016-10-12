package com.atlantbh.jmeter.plugins.aws.s3.gui;

import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jorphan.gui.JLabeledTextField;

import javax.swing.*;
import java.awt.*;


/**
 * Abstract S3 GUI sampler.
 */
public abstract class BaseS3GUISampler extends AbstractSamplerGui {

	private static final long serialVersionUID = 1L;
	protected JLabeledTextField ltfAwsKey = null;
	protected JLabeledTextField ltfAwsSecret = null;
	protected JLabeledTextField ltfAwsEndpoint = null;
	protected JLabeledTextField ltfAwsBucket = null;
	protected JLabeledTextField ltfObject = null;
	protected JLabeledTextField ltfDestination = null;

	private Boolean enableDestination = false;

	/**
	 * Creates new {@link BaseS3GUISampler}.
	 * @param enableDestination if <code>true</code> destination field will be rendered
	 */
	public BaseS3GUISampler(Boolean enableDestination) {
		super();
		this.enableDestination = enableDestination;
		this.init();
	}

	/**
	 * Initializes GUI elements.
	 */
	private void init() {
		setLayout(new BorderLayout());
		setBorder(makeBorder());
		add(makeTitlePanel(), BorderLayout.NORTH);

		VerticalPanel panel = new VerticalPanel();
		panel.setBorder(BorderFactory.createEtchedBorder());

		ltfAwsKey = new JLabeledTextField("S3 Key");
		ltfAwsSecret = new JLabeledTextField("S3 Secret");
		ltfAwsEndpoint = new JLabeledTextField("S3 Endpoint");
		ltfAwsBucket = new JLabeledTextField("S3 Bucket");
		ltfObject = new JLabeledTextField("S3 Object");

		if (enableDestination) {
			ltfDestination = new JLabeledTextField("Destination dir");
		}

		panel.add(ltfAwsKey);
		panel.add(ltfAwsSecret);
		panel.add(ltfAwsEndpoint);
		panel.add(ltfAwsBucket);
		panel.add(ltfObject);

		if (enableDestination) {
			panel.add(ltfDestination);
		}
		add(panel, BorderLayout.CENTER);
	}



	@Override
	public void clearGui() {
		super.clearGui();
		ltfAwsKey.setText("");
		ltfAwsSecret.setText("");
		ltfAwsBucket.setText("");
		ltfObject.setText("");
		ltfDestination.setText("");

		if (ltfAwsEndpoint != null) {
			ltfAwsEndpoint.setText("");
		}
	}
}
