import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

public class interpreterGUI {
    private JTextArea cSharpCode;
    private JTextArea javaCode;
    private JTextArea outputText;
    public interpreterGUI(String csFile, String javaFile, String outputFile){
        readin(csFile, cSharpCode);
        readin(javaFile, javaCode);
        readin(outputFile, outputText);

        JFrame frame = new JFrame("Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(cSharpCode, BorderLayout.WEST);
        frame.getContentPane().add(javaCode, BorderLayout.EAST);
        frame.getContentPane().add(outputText, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

    }
    static void readin(String fn, JTextComponent pane)
    {
        try
        {
            FileReader fr = new FileReader(fn);
            pane.read(fr, null);
            fr.close();
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}
