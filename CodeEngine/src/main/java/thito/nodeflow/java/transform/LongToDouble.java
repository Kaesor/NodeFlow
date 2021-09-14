package thito.nodeflow.java.transform;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import thito.nodeflow.java.*;

public class LongToDouble implements ObjectTransformation {
    @Override
    public Reference transform(Reference source) {
        return new Reference(double.class) {
            @Override
            public void writeByteCode() {
                source.writeByteCode();
                MethodContext.getContext().pushNode(new InsnNode(Opcodes.L2D));
            }

            @Override
            public void writeSourceCode() {
                SourceCode.getContext().getLine().append("(double) ");
                source.writeSourceCode();
            }
        };
    }
}
