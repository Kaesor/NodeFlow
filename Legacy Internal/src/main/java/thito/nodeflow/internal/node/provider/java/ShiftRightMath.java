package thito.nodeflow.internal.node.provider.java;

import thito.nodeflow.api.editor.node.*;
import thito.nodeflow.internal.node.*;
import thito.nodeflow.internal.node.provider.*;
import thito.reflectedbytecode.jvm.*;

public class ShiftRightMath extends AbstractNodeProvider {
    public ShiftRightMath(NodeProviderCategory category) {
        super("java#shiftright", "Shift Right Binary", category);
        addParameter(new JavaNodeParameter("Number", Number.class, false, LinkMode.SINGLE, LinkMode.NONE));
        addParameter(new JavaNodeParameter("Shift Amount", Number.class, false, LinkMode.SINGLE, LinkMode.NONE));
        addParameter(new JavaNodeParameter("Result", Number.class, true, LinkMode.NONE, LinkMode.MULTIPLE));
    }

    @Override
    public CompileSession createNewSession() {
        return new CompileSession() {
            @Override
            protected void prepareStructure() {
                getHandler().prepareLocalField(this, getNode().getParameter(0));
                getHandler().prepareLocalField(this, getNode().getParameter(1));
                getHandler().computeField(getNode().getParameter(2));
            }

            @Override
            protected void handleCompile() {
                getHandler().setReference(getNode().getParameter(2), Java.Math.shr(
                        getHandler().getReference(getNode().getParameter(0)),
                        getHandler().getReference(getNode().getParameter(1))
                ));
            }
        };
    }

    @Override
    public NodeCompileSession createCompileSession(Node node) {
        return new NodeCompileSession() {
            @Override
            public void handleCompile(NodeCompileHandler handler) {
                if (isParameterUsed(node.getParameter(2))) {
                    handler.putReference(node.getParameter(2), Java.Math.shr(
                            handler.getReference((node.getParameter(0))),
                            handler.getReference((node.getParameter(1)))
                    ));
                }
            }
        };
    }

}