/**
 * Derek Kronemeyer
 * Print class
 * 2019
 */

import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
/**
 * A Collection of useful print methods for debugging
 *
 * @author Derek Kronemeyer
 */
public class Print
{
    /**
     * print shortcut function
     *
     * @param s the string to be printed
     */
    public static void p(String s){System.out.println(""+s);}

    /**
     * alert shortcut function
     *
     * @param s the string to alert the user with
     */
    public static void a(String s){JOptionPane.showMessageDialog(null, s, "Alert", JOptionPane.PLAIN_MESSAGE);}
}
