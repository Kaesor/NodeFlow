package thito.nodeflow.bytecode.transform;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import thito.nodeflow.bytecode.*;

public class LongToDouble implements ObjectTransformation {
    @Override
    public Reference transform(Reference source) {
        return new Reference(double.class) {
            @Override
            public void write() {
                source.write();
                MethodContext.getContext().pushNode(new InsnNode(Opcodes.L2D));
            }
        };
    }
}
