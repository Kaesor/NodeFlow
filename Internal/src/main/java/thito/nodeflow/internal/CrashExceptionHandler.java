package thito.nodeflow.internal;

import javax.swing.*;

public class CrashExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Application crashed. Please see crash.log!", "Crash", JOptionPane.ERROR_MESSAGE);
    }
}
