package thito.nodeflow.plugin.base.blueprint.state;

import thito.nodeflow.plugin.base.blueprint.NodeProvider;

import java.io.Serial;

public class EventMethodInvocationNodeState extends BlueprintNodeState {
    @Serial
    private static final long serialVersionUID = 1L;
    public EventMethodInvocationNodeState(NodeProvider provider) {
        super(provider);
    }
}
