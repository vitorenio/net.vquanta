package net.vquanta.ui.features.gates.ancilla;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateAncillaGateFeature extends AbstractCreateFeature{

    public CreateAncillaGateFeature(IFeatureProvider fp, String name, String description) {
	super(fp, name, description);
	// TODO Auto-generated constructor stub
    }

    @Override
    public boolean canCreate(ICreateContext context) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Object[] create(ICreateContext context) {
	// TODO Auto-generated method stub
	return null;
    }

}
