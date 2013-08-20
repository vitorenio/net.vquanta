package net.vquanta.ui.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class VQuantaDiagramTypeProvider extends AbstractDiagramTypeProvider {

  private IToolBehaviorProvider[] toolBehaviorProviders;

  public VQuantaDiagramTypeProvider() {
    super();
    setFeatureProvider(new VQuantaFeatureProvider(this));
  }

  @Override
  public boolean isAutoUpdateAtStartup() {
    return true;
  }

  @Override
  public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
    if (toolBehaviorProviders == null) {
      toolBehaviorProviders = new IToolBehaviorProvider[] {new ToolBehaviourProvider(this)};
    }
    return toolBehaviorProviders;
  }
}
