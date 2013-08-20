package net.vquanta.ui.diagram;

import java.util.HashMap;
import java.util.Map;

import net.vquanta.ui.PortA;
import net.vquanta.ui.features.porta.AddPortAFeature;
import net.vquanta.ui.features.porta.CreatePortAFeature;
import net.vquanta.ui.features.porta.LayoutPortAFeature;
import net.vquanta.ui.features.porta.MoveShapePortAFeature;
import net.vquanta.ui.features.porta.UpdatePortAFeature;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class VQuantaFeatureProvider extends DefaultFeatureProvider {

    private Map<Class<?>, FeatureContainer> containers;

    public VQuantaFeatureProvider(IDiagramTypeProvider dtp) {
	super(dtp);

	containers = new HashMap<Class<?>, FeatureContainer>();

	FeatureContainer container = new DefaultFeatureContainer();

	containers.put(PortA.class, container);

    }

    @Override
    public ICreateFeature[] getCreateFeatures() {
	return new ICreateFeature[] { new CreatePortAFeature(this) };
    }

    @Override
    public ICreateConnectionFeature[] getCreateConnectionFeatures() {
	return new ICreateConnectionFeature[] {/* new CreateDomainObjectConnectionConnectionFeature(this) */};
    }

    @Override
    public IAddFeature getAddFeature(IAddContext context) {
	// is object for add request a EClass?
	if (context.getNewObject() instanceof EClass) {
	    return new AddPortAFeature(this);
	}

	return super.getAddFeature(context);
    }

    @Override
    public ILayoutFeature getLayoutFeature(ILayoutContext context) {
	PictogramElement pictogramElement = context.getPictogramElement();
	Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	if (bo instanceof EClass) {
	    return new LayoutPortAFeature(this);
	}
	return super.getLayoutFeature(context);
    }

    @Override
    public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	PictogramElement pictogramElement = context.getPictogramElement();
	if (pictogramElement instanceof ContainerShape) {
	    Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	    if (bo instanceof EClass) {
		return new UpdatePortAFeature(this);
	    }
	}
	return super.getUpdateFeature(context);
    }

    @Override
    public IRemoveFeature getRemoveFeature(IRemoveContext context) {
	// TODO Auto-generated method stub
	return super.getRemoveFeature(context);
    }

    @Override
    public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
	Shape shape = context.getShape();
	Object bo = getBusinessObjectForPictogramElement(shape);
	if (bo instanceof EClass) {
	    return new MoveShapePortAFeature(this);
	}
	return super.getMoveShapeFeature(context);
    }
    
    public ICreateFeature[] getOneQubitCreateFeatures(){
	return new ICreateFeature[] { new CreatePortAFeature(this) };
    }
    
    public ICreateFeature[] getMultiQubitCreateFeatures(){
	return new ICreateFeature[] { new CreatePortAFeature(this) };
    }
}
