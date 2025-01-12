package thito.nodeflow.plugin.base.blueprint_legacy.state;

import thito.nodeflow.engine.node.state.HandlerState;
import thito.nodeflow.plugin.base.blueprint_legacy.NodeProvider;

import java.io.Serial;

public class BlueprintNodeState implements HandlerState {
    @Serial
    private static final long serialVersionUID = 1L;
    public String providerId;

    public BlueprintNodeState(NodeProvider provider) {
        providerId = provider.getId();
    }
}
