package net.vquanta.ui.diagram;

import net.vquanta.ui.features.CreateDomainObjectConnectionConnectionFeature;
import net.vquanta.ui.features.CreateDomainObjectFeature;
import net.vquanta.ui.features.LayoutDomainObjectFeature;
import net.vquanta.ui.features.porta.AddPortAFeature;
import net.vquanta.ui.features.porta.CreatePortAFeature;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;


public class VQuantaFeatureProvider extends DefaultFeatureProvider {

  public VQuantaFeatureProvider(IDiagramTypeProvider dtp) {
    super(dtp);
  }

  @Override
  public ICreateFeature[] getCreateFeatures() {
    return new ICreateFeature[] {new CreatePortAFeature(this)};
  }

  @Override
  public ICreateConnectionFeature[] getCreateConnectionFeatures() {
    return new ICreateConnectionFeature[] {new CreateDomainObjectConnectionConnectionFeature(this)};
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
    // TODO: check for right domain object instances below
    if (context.getPictogramElement() instanceof ContainerShape /* && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof <DomainObject> */) {
      return new LayoutDomainObjectFeature(this);
    }

    return super.getLayoutFeature(context);
  }
}
