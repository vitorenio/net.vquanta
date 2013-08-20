package net.vquanta.ui.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

public class ToolBehaviourProvider extends DefaultToolBehaviorProvider {

    public ToolBehaviourProvider(IDiagramTypeProvider diagramTypeProvider) {
	super(diagramTypeProvider);
	// TODO Auto-generated constructor stub
    }

    @Override
    public IPaletteCompartmentEntry[] getPalette() {
	List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();

	// add new compartment at the end of the existing compartments
	PaletteCompartmentEntry oneQubit = new PaletteCompartmentEntry("1-qubit", null);
	ret.add(oneQubit);

	PaletteCompartmentEntry multiQubit = new PaletteCompartmentEntry("multi-qubit", null);
	ret.add(multiQubit);
	
	// add all create-features to the new stack-entry
	VQuantaFeatureProvider featureProvider = (VQuantaFeatureProvider) getFeatureProvider();
	ICreateFeature[] createFeatures = featureProvider.getOneQubitCreateFeatures();
	for (ICreateFeature cf : createFeatures) {
	    // add new ObjectEntry to new compartment
	    ObjectCreationToolEntry stackEntry = new ObjectCreationToolEntry("oneQubit", "oneQubit", null, null, cf);
	    oneQubit.addToolEntry(stackEntry);
	}
	
	createFeatures = featureProvider.getMultiQubitCreateFeatures();
	for (ICreateFeature cf : createFeatures) {
	    // add new ObjectEntry to new compartment
	    ObjectCreationToolEntry stackEntry = new ObjectCreationToolEntry("MultiQubit", "MultiQubit", null, null, cf);
	    multiQubit.addToolEntry(stackEntry);
	}

	// add all create-connection-features to the new stack-entry
	ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
	for (ICreateConnectionFeature cf : createConnectionFeatures) {
	    ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(cf.getCreateName(), cf.getCreateDescription(), cf.getCreateImageId(), cf.getCreateLargeImageId());
	    connectionCreationToolEntry.addCreateConnectionFeature(cf);
	}

	return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
    }

}
