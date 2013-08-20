package net.vquanta.ui.diagram;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;

public interface FeatureContainer {

  IAddFeature getAddFeature();

  IUpdateFeature getUpdateFeature();

  IDirectEditingFeature getDirectEditingFeature();

  IMoveShapeFeature getMoveShapeFeature();

  ILayoutFeature getLayoutFeature();

  IResizeShapeFeature getResizeShapeFeature();

  IRemoveFeature getRemoveFeature();

  IDeleteFeature getDeleteFeature();

}
