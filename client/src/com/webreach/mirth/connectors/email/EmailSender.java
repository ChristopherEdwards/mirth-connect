/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mirth.
 *
 * The Initial Developer of the Original Code is
 * WebReach, Inc.
 * Portions created by the Initial Developer are Copyright (C) 2006
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Gerald Bortis <geraldb@webreachinc.com>
 *
 * ***** END LICENSE BLOCK ***** */

package com.webreach.mirth.connectors.email;

import java.util.Properties;

import com.webreach.mirth.client.ui.UIConstants;
import com.webreach.mirth.connectors.ConnectorClass;

/**
 * A form that extends from ConnectorClass. All methods implemented are
 * described in ConnectorClass.
 */
public class EmailSender extends ConnectorClass
{
    /** Creates new form EmailSender */

    public EmailSender()
    {
        name = EmailSenderProperties.name;
        initComponents();
    }

    public Properties getProperties()
    {
        Properties properties = new Properties();
        properties.put(EmailSenderProperties.DATATYPE, name);
        properties.put(EmailSenderProperties.EMAIL_ADDRESS, SMTPServerHostField.getText());
        properties.put(EmailSenderProperties.EMAIL_PORT, SMTPServerPortField.getText());
        properties.put(EmailSenderProperties.EMAIL_USERNAME, emailUsernameField.getText());
        properties.put(EmailSenderProperties.EMAIL_PASSWORD, new String(emailPasswordField.getPassword()));
        properties.put(EmailSenderProperties.EMAIL_TO, emailToField.getText());
        properties.put(EmailSenderProperties.EMAIL_FROM, emailFromField.getText());
        properties.put(EmailSenderProperties.EMAIL_SUBJECT, emailSubjectField.getText());
        
        if (htmlContentYesButton.isSelected())
            properties.put(EmailSenderProperties.EMAIL_HTML_CONTENT, UIConstants.YES_OPTION);
        else
        	properties.put(EmailSenderProperties.EMAIL_HTML_CONTENT, UIConstants.NO_OPTION);
        
        properties.put(EmailSenderProperties.EMAIL_BODY, emailBodyTextPane.getText());
        return properties;
    }

    public void setProperties(Properties props)
    {
        resetInvalidProperties();
        
        SMTPServerHostField.setText((String) props.get(EmailSenderProperties.EMAIL_ADDRESS));
        SMTPServerPortField.setText((String) props.get(EmailSenderProperties.EMAIL_PORT));
        emailUsernameField.setText((String) props.get(EmailSenderProperties.EMAIL_USERNAME));
        emailPasswordField.setText((String) props.get(EmailSenderProperties.EMAIL_PASSWORD));
        emailToField.setText((String) props.get(EmailSenderProperties.EMAIL_TO));
        emailFromField.setText((String) props.get(EmailSenderProperties.EMAIL_FROM));
        emailSubjectField.setText((String) props.get(EmailSenderProperties.EMAIL_SUBJECT));
        
        if (((String) props.get(EmailSenderProperties.EMAIL_HTML_CONTENT)).equals(UIConstants.YES_OPTION))
        	htmlContentYesButton.setSelected(true);
        else
        	htmlContentNoButton.setSelected(true);
        
        emailBodyTextPane.setText((String) props.get(EmailSenderProperties.EMAIL_BODY));
    }

    public Properties getDefaults()
    {
        return new EmailSenderProperties().getDefaults();
    }

    public boolean checkProperties(Properties props, boolean highlight)
    {
        resetInvalidProperties();
        boolean valid = true;
        
        if (((String) props.get(EmailSenderProperties.EMAIL_ADDRESS)).length() == 0)
        {
            valid = false;
            if (highlight)
            	SMTPServerHostField.setBackground(UIConstants.INVALID_COLOR);
        }
        if (((String) props.get(EmailSenderProperties.EMAIL_PORT)).length() == 0)
        {
            valid = false;
            if (highlight)
            	SMTPServerPortField.setBackground(UIConstants.INVALID_COLOR);
        }
        if (((String) props.get(EmailSenderProperties.EMAIL_TO)).length() == 0)
        {
            valid = false;
            if (highlight)
            	emailToField.setBackground(UIConstants.INVALID_COLOR);
        }
        
        return valid;
    }
    
    private void resetInvalidProperties()
    {
        SMTPServerHostField.setBackground(null);
        SMTPServerPortField.setBackground(null);
        emailToField.setBackground(null);
    }
    
    public String doValidate(Properties props, boolean highlight)
    {
    	String error = null;
    	
    	if (!checkProperties(props, highlight))
    		error = "Error in the form for connector \"" + getName() + "\".\n\n";
    	
    	return error;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailUsernameField = new com.webreach.mirth.client.ui.components.MirthTextField();
        SMTPServerPortField = new com.webreach.mirth.client.ui.components.MirthTextField();
        SMTPServerHostField = new com.webreach.mirth.client.ui.components.MirthTextField();
        emailToField = new com.webreach.mirth.client.ui.components.MirthTextField();
        emailSubjectField = new com.webreach.mirth.client.ui.components.MirthTextField();
        emailPasswordField = new com.webreach.mirth.client.ui.components.MirthPasswordField();
        jLabel8 = new javax.swing.JLabel();
        emailFromField = new com.webreach.mirth.client.ui.components.MirthTextField();
        emailBodyTextPane = new com.webreach.mirth.client.ui.components.MirthSyntaxTextArea();
        htmlContentLabel = new javax.swing.JLabel();
        htmlContentYesButton = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        htmlContentNoButton = new com.webreach.mirth.client.ui.components.MirthRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("SMTP Server Host:");

        jLabel2.setText("SMTP Server Port:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        jLabel5.setText("To:");

        jLabel6.setText("Subject:");

        jLabel7.setText("Body:");

        emailUsernameField.setToolTipText("If the SMTP server requires authentication to send a message, enter the username here.");

        SMTPServerPortField.setToolTipText("<html>The port number of the SMTP server to send the email message to.<br>Generally, the default port of 25 is used.</html>");

        SMTPServerHostField.setToolTipText("<html>Enter the DNS domain name or IP address of the SMTP server to use to send the email messages.<br>Note that sending email to an SMTP server that is not expecting it may result in the IP of the box running Mirth being added to the server's \"blacklist.\"</html>");

        emailToField.setToolTipText("The name of the mailbox (person, usually) to which the email should be sent.");

        emailSubjectField.setToolTipText("The text that should appear as the subject of the email, as seen by the receiver's email client.");

        emailPasswordField.setToolTipText("If the SMTP server requires authentication to send a message, enter the password here.");

        jLabel8.setText("From:");

        emailFromField.setToolTipText("The name that should appear as the \"From address\" in the email.");

        emailBodyTextPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        htmlContentLabel.setText("HTML Content:");

        htmlContentYesButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(htmlContentYesButton);
        htmlContentYesButton.setText("Yes");

        htmlContentNoButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(htmlContentNoButton);
        htmlContentNoButton.setText("No");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(htmlContentLabel)
                    .add(jLabel8)
                    .add(jLabel2)
                    .add(jLabel1)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(emailPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(SMTPServerHostField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .add(SMTPServerPortField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(emailUsernameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(emailToField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .add(emailFromField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(emailSubjectField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, emailBodyTextPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(htmlContentYesButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(htmlContentNoButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(SMTPServerHostField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(SMTPServerPortField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(emailUsernameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(emailPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(emailToField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(emailFromField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(emailSubjectField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(htmlContentLabel)
                    .add(htmlContentYesButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(htmlContentNoButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(emailBodyTextPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.webreach.mirth.client.ui.components.MirthTextField SMTPServerHostField;
    private com.webreach.mirth.client.ui.components.MirthTextField SMTPServerPortField;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.webreach.mirth.client.ui.components.MirthSyntaxTextArea emailBodyTextPane;
    private com.webreach.mirth.client.ui.components.MirthTextField emailFromField;
    private com.webreach.mirth.client.ui.components.MirthPasswordField emailPasswordField;
    private com.webreach.mirth.client.ui.components.MirthTextField emailSubjectField;
    private com.webreach.mirth.client.ui.components.MirthTextField emailToField;
    private com.webreach.mirth.client.ui.components.MirthTextField emailUsernameField;
    private javax.swing.JLabel htmlContentLabel;
    private com.webreach.mirth.client.ui.components.MirthRadioButton htmlContentNoButton;
    private com.webreach.mirth.client.ui.components.MirthRadioButton htmlContentYesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

}
