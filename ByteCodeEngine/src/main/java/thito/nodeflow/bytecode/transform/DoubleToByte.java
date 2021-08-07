package thito.nodeflow.bytecode.transform;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import thito.nodeflow.bytecode.*;

public class DoubleToByte implements ObjectTransformation {
    @Override
    public Reference transform(Reference source) {
        return new Reference(byte.class) {
            @Override
            public void write() {
                source.write();
                MethodContext.getContext().pushNode(new InsnNode(Opcodes.D2I));
                MethodContext.getContext().pushNode(new InsnNode(Opcodes.I2B));
            }
        };
    }
}
