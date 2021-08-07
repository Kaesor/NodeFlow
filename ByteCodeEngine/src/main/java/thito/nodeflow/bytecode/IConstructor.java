package thito.nodeflow.bytecode;

public interface IConstructor extends IMember {
    int getParameterCount();
    IClass[] getParameterTypes();
    Reference newInstance(Object...args);
    void newInstanceVoid(Object...args);
}
