package net.vquanta.ui.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class VQuantaDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public VQuantaDiagramTypeProvider() {
		super();
		setFeatureProvider(new VQuantaFeatureProvider(this));
	}
}
