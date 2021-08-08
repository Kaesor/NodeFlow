package thito.nodeflow.bytecode.transform;

import thito.nodeflow.bytecode.*;

public class ByteToInt implements ObjectTransformation {
    @Override
    public Reference transform(Reference source) {
        return new Reference(int.class) {
            @Override
            public void write() {
                source.write();
            }
        };
    }
}