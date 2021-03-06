/*
 * Copyright (C) 2009-2011 RtcNbClient Team (http://rtcnbclient.wmi.amu.edu.pl/)
 *
 * This file is part of RtcNbClient.
 *
 * RtcNbClient is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RtcNbClient is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RtcNbClient. If not, see <http://www.gnu.org/licenses/>.
 */
package pl.edu.amu.wmi.kino.rtc.client.ui.workitems.view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

import pl.edu.amu.wmi.kino.netbeans.mvp.client.Display;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.DisplayFactory;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.SwingDisplay;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.handlers.InputHandler;
import pl.edu.amu.wmi.kino.netbeans.mvp.client.handlers.InputHandler.Input;
import pl.edu.amu.wmi.kino.rtc.client.ui.api.workitems.presenters.WorkItemHeaderPresenter;

public class MainEditorHeaderDisplayFactory implements DisplayFactory {

    @Override
    public <D extends Display> D createDisplay(Class<D> displayType, Lookup lookup) {
        if (displayType.equals(WorkItemHeaderPresenter.HeaderDisplay.class)) {
            return displayType.cast(new MainEditorHeaderDisplay());
        }
        return null;
    }
}

/**
 *
 * @author Patryk Żywica
 */
class MainEditorHeaderDisplay extends javax.swing.JPanel implements WorkItemHeaderPresenter.HeaderDisplay, ActionListener, SwingDisplay {

    private static final long serialVersionUID = 3421243L;
    private Color startColor = Color.WHITE;
    private Color endColor = Color.decode("#E0E8F1");

    /** Creates new form MainEditorHeaderDisplay */
    public MainEditorHeaderDisplay() {
        initComponents();
        jTextField1.addActionListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 3));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18));
        jLabel1.setForeground(new java.awt.Color(25, 76, 127));
        jLabel1.setText(org.openide.util.NbBundle.getMessage(MainEditorHeaderDisplayFactory.class, "RtcMainEditorHeaderDisplay.jLabel1.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(MainEditorHeaderDisplayFactory.class, "RtcMainEditorHeaderDisplay.jTextField1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(MainEditorHeaderDisplayFactory.class, "MainEditorHeaderDisplayFactory.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private final List<InputHandler<String>> handlers = Collections.synchronizedList(new LinkedList<InputHandler<String>>());

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, this.getHeight(), endColor);
        g2d.setPaint(gradient);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

    }

    public void setSummary(String summary) {
        jTextField1.setText(summary);
    }

    public void setId(String id) {
        jLabel1.setText(id);
    }
    
    public void setIcon(Image icon){
        jLabel1.setIcon(new ImageIcon(icon));
    }

    @SuppressWarnings("unchecked")
    public <T> void addHandler(Input<T> input, InputHandler<T> h) {
        if (input.equals(WorkItemHeaderPresenter.SUMMARY_INPUT)) {
            handlers.add((InputHandler<String>) h);
        }
    }

    public <T> void removeHandler(Input<T> input, InputHandler<T> handler) {
        handlers.remove(handler);
    }

    public void actionPerformed(ActionEvent e) {
        notifyHandlers(jTextField1.getText());
    }

    private <T> void notifyHandlers(String value) {
        synchronized (handlers) {
            for (InputHandler<String> h : handlers) {
                h.valueEntered(value);
            }
        }
    }

    public JComponent asComponent() {
        return this;
    }
}
