package net.vquanta.ui.features.gates.z;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;

public class UpdateZGateFeature extends AbstractUpdateFeature{

    public UpdateZGateFeature(IFeatureProvider fp) {
	super(fp);
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean canUpdate(IUpdateContext context) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public IReason updateNeeded(IUpdateContext context) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean update(IUpdateContext context) {
	// TODO Auto-generated method stub
	return false;
    }

}
