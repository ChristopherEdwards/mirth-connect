/*
 * TabbedTemplatePanel.java
 *
 * Created on February 2, 2007, 1:50 PM
 */

package com.webreach.mirth.client.ui.editors;

import java.util.Properties;
import java.util.Set;

import org.syntax.jedit.SyntaxDocument;

import com.webreach.mirth.client.ui.FunctionList;
import com.webreach.mirth.client.ui.TreePanel;
import com.webreach.mirth.client.ui.VariableListHandler;
import com.webreach.mirth.client.ui.panels.reference.VariableReferenceTable;
import com.webreach.mirth.client.ui.panels.reference.ReferenceListFactory.ContextType;

/**
 * 
 * @author brendanh
 */
public class TabbedTemplatePanel extends javax.swing.JPanel
{
    private VariableReferenceTable globalVarTable, dbVarTable;

    private SyntaxDocument incomingHL7Doc, outgoingHL7Doc;

    private TreePanel incomingTreePanel, outgoingTreePanel;

    private MirthEditorPane parent;

    /** Creates new form TabbedTemplatePanel */
    public TabbedTemplatePanel(MirthEditorPane p)
    {
        parent = p;
        initComponents();
        messageTemplatePanel.setInboundTreePanel(messageTreePanel.getInboundTreePanel());
        messageTemplatePanel.setOutboundTreePanel(messageTreePanel.getOutboundTreePanel());

        // ArrayList<ReferenceListItem> functionListItems = new
        // ReferenceListBuilder().getVariableListItems();
        variableTable = new VariableReferenceTable("Available Variables", new String[] {});
        variableTable.setDragEnabled(true);
        variableTable.setTransferHandler(new VariableListHandler("$('", "')"));
        variableListScrollPane.setViewportView(variableTable);      
    }
    
    public void setFilterView()
    {
        messageTreePanel.hideOutbound();
        messageTemplatePanel.hideOutbound();
        
        messageTreePanel.getInboundTreePanel().setFilterView();
        messageTreePanel.getOutboundTreePanel().setFilterView();
    }
    
    public void setTransformerView()
    {
        messageTreePanel.showOutbound();
        messageTemplatePanel.showOutbound();
        
        messageTreePanel.getInboundTreePanel().setTransformerView();
        messageTreePanel.getOutboundTreePanel().setTransformerView();
    }
    
    public void resizePanes()
    {
        variableSplitPane.setDividerLocation(.5);
        variableSplitPane.setResizeWeight(.5);
        messageTreePanel.resizePanes();
        messageTemplatePanel.resizePanes();
    }

    public void updateVariables(Set<String> rules, Set<String> steps)
    {
    	if (rules != null && steps != null){
    		rules.addAll(steps);
    	}
        variableTable.updateVariables(rules);
    }

    public String getIncomingMessage()
    {
        return messageTemplatePanel.getInboundMessage();
    }

    public void setIncomingMessage(String msg)
    {
        messageTemplatePanel.setInboundMessage(msg);
    }

    public String getOutgoingMessage()
    {
        return messageTemplatePanel.getOutboundMessage();
    }

    public void setOutgoingMessage(String msg)
    {
        messageTemplatePanel.setOutboundMessage(msg);
    }

    public void setIncomingDataType(String protocol)
    {
        messageTemplatePanel.setInboundProtocol(protocol);
    }

    public void setOutgoingDataType(String protocol)
    {
        messageTemplatePanel.setOutboundProtocol(protocol);
    }

    public String getIncomingDataType()
    {
        return messageTemplatePanel.getInboundProtocol();
    }

    public String getOutgoingDataType()
    {
        return messageTemplatePanel.getOutboundProtocol();
    }

    public void setIncomingDataProperties(Properties properties)
    {
        messageTemplatePanel.setInboundDataProperties(properties);
    }

    public void setOutgoingDataProperties(Properties properties)
    {
        messageTemplatePanel.setOutboundDataProperties(properties);
    }

    public Properties getIncomingDataProperties()
    {
        return messageTemplatePanel.getInboundDataProperties();
    }

    public Properties getOutgoingDataProperties()
    {
        return messageTemplatePanel.getOutboundDataProperties();
    }

    public void setDefaultComponent()
    {
        tabPanel.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        tabPanel = new javax.swing.JTabbedPane();
        variableTab = new javax.swing.JPanel();
        variableSplitPane = new javax.swing.JSplitPane();
        functionList = new FunctionList(ContextType.MESSAGE_CONTEXT.getContext());
        variableListScrollPane = new javax.swing.JScrollPane();
        variableTable = new com.webreach.mirth.client.ui.panels.reference.VariableReferenceTable();
        treeTab = new javax.swing.JPanel();
        messageTreePanel = new com.webreach.mirth.client.ui.editors.MessageTreePanel();
        messageTab = new javax.swing.JPanel();
        messageTemplatePanel = new com.webreach.mirth.client.ui.editors.MessageTemplatePanel();

        variableTab.setBackground(new java.awt.Color(255, 255, 255));
        variableSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        variableSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        functionList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        variableSplitPane.setLeftComponent(functionList);

        variableListScrollPane.setViewportView(variableTable);

        variableSplitPane.setRightComponent(variableListScrollPane);
        variableSplitPane.setDividerSize(6);
        variableSplitPane.setOneTouchExpandable(true);
        variableSplitPane.setDividerLocation(.5);
        variableSplitPane.setResizeWeight(.5);
        org.jdesktop.layout.GroupLayout variableTabLayout = new org.jdesktop.layout.GroupLayout(variableTab);
        variableTab.setLayout(variableTabLayout);
        variableTabLayout.setHorizontalGroup(
            variableTabLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, variableSplitPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );
        variableTabLayout.setVerticalGroup(
            variableTabLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, variableTabLayout.createSequentialGroup()
                .addContainerGap()
                .add(variableSplitPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );
        tabPanel.addTab("Reference", variableTab);

        treeTab.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout treeTabLayout = new org.jdesktop.layout.GroupLayout(treeTab);
        treeTab.setLayout(treeTabLayout);
        treeTabLayout.setHorizontalGroup(
            treeTabLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(messageTreePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );
        treeTabLayout.setVerticalGroup(
            treeTabLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(messageTreePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        tabPanel.addTab("Message Trees", treeTab);

        messageTab.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout messageTabLayout = new org.jdesktop.layout.GroupLayout(messageTab);
        messageTab.setLayout(messageTabLayout);
        messageTabLayout.setHorizontalGroup(
            messageTabLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(messageTemplatePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );
        messageTabLayout.setVerticalGroup(
            messageTabLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(messageTemplatePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        tabPanel.addTab("Message Templates", messageTab);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.webreach.mirth.client.ui.FunctionList functionList;
    public javax.swing.JPanel messageTab;
    private com.webreach.mirth.client.ui.editors.MessageTemplatePanel messageTemplatePanel;
    private com.webreach.mirth.client.ui.editors.MessageTreePanel messageTreePanel;
    public javax.swing.JTabbedPane tabPanel;
    public javax.swing.JPanel treeTab;
    private javax.swing.JScrollPane variableListScrollPane;
    private javax.swing.JSplitPane variableSplitPane;
    private javax.swing.JPanel variableTab;
    private com.webreach.mirth.client.ui.panels.reference.VariableReferenceTable variableTable;
    // End of variables declaration//GEN-END:variables

}
