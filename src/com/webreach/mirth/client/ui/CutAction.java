package com.webreach.mirth.client.ui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.text.JTextComponent;

/** Allows for Cutting in text components. */
public class CutAction extends AbstractAction
{
    JTextComponent comp;
    
    public CutAction(JTextComponent comp)
    {
        super("Cut");
        this.comp = comp;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        comp.cut();
    }
    
    public boolean isEnabled()
    {
        return comp.isEditable()
                && comp.isEnabled()
                && comp.getSelectedText() != null;
    }
}
