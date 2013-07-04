/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionclient;

import java.awt.*;
import java.net.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author kogayou
 */
public class ClientKernel {
    
    private static JTextPane msgTextPane,auctionTextPane,clientTextPane;
    
    public static void appendTextPanes(JTextPane tp,String str,Color color) {
        Document docs=tp.getDocument();
        try {
            docs.insertString(docs.getLength(),ClientUtil.getTime(),ClientUtil.setAttributeSet(Color.LIGHT_GRAY));
            docs.insertString(docs.getLength(),str+"\n",ClientUtil.setAttributeSet(color));
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientKernel.class.getName()).log(Level.SEVERE, null, ex);
        }
        tp.setCaretPosition(docs.getLength());
    }
    
    public static void processDatagramPacket(DatagramPacket dp) {
        String ip=dp.getAddress().getHostAddress();
        int port=dp.getPort();
        String data=new String(dp.getData(),0,dp.getLength());
        if (data.startsWith("0")) {
            appendTextPanes(msgTextPane,data.substring(2),ClientUtil.getColor(data.substring(1,2)));
        }
        if (data.startsWith("1")) {
            updateTextPanes(auctionTextPane,data.substring(2),new Color(206,123,0));
        }
        if (data.startsWith("2")) {
            updateTextPanes(clientTextPane,data.substring(2),new Color(206,123,0));
        }
    }
     
    public static void setTextPanes(JTextPane msgTextPane,JTextPane auctionTextPane,JTextPane clientTextPane) {
        ClientKernel.msgTextPane=msgTextPane;
        ClientKernel.auctionTextPane=auctionTextPane;
        ClientKernel.clientTextPane=clientTextPane;
    }
    
    public static void updateTextPanes(JTextPane tp,String str,Color color) {
        Document docs=tp.getDocument();
        try {
            docs.remove(0,docs.getLength());
            docs.insertString(0,str,ClientUtil.setAttributeSet(color));
        } catch (BadLocationException ex) {
            Logger.getLogger(ClientKernel.class.getName()).log(Level.SEVERE, null, ex);
        }       
    } 

}
