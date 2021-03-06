/**
 * Genetic Algorithm that composes music
 * Derek Kronemeyer
 * 2019
 */
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.*;
 import java.util.ArrayList;
 import java.util.concurrent.*;


/**
 * A Java based Genetic algorithm that composes music
 *
 * @author Derek Kronemeyer
 * @version 2.0
 */
public class Main
{
    /**
    * The main constructor for the genetic algorithm
    *
    * @param args unused
    */
    public static void main(String[] args)
    {

        GeneticAlgorithm ga = new GeneticAlgorithm();
        Controller controller = new Controller(ga);
        //RuleSettings rs = new RuleSettings(controller);
        GUI gui = new GUI(controller);
        controller.setGUI(gui);
    }
}
