/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionclient;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.text.*;

/**
 *
 * @author kogayou
 */
public class ClientUtil {
    public static Color getColor(String str) {
        if (str.equals("1")) {
            return Color.RED;
        }
        if (str.equals("2")) {
            return Color.BLUE;
        }
        if (str.equals("3")) {
            return Color.GRAY;
        }
        if (str.equals("4")) {
            return Color.GREEN;
        }
        if (str.equals("5")) {
            return Color.MAGENTA;
        }
        return Color.BLACK;
    }
    
    public static String getRandomPort() {
        return String.valueOf(Math.round(Math.random()*20000+10000));
    }
    
    public static String getTime()
    {
        DateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        return "["+sdf.format(new Date())+"] ";
    }
    
    public static SimpleAttributeSet setAttributeSet(Color color) {
        SimpleAttributeSet attrset=new SimpleAttributeSet();
        StyleConstants.setForeground(attrset,color); 
        return attrset;
    }
}
