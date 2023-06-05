/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelagem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedTextField extends JTextField {
    private static final int SHADOW_SIZE = 5;
    private static final Color BORDER_COLOR = new Color(180, 180, 180);
    private static final Color SHADOW_COLOR = new Color(0, 0, 0, 50);

    public RoundedTextField() {
        setOpaque(false);
        setMargin(new Insets(5, 10, 5, 10));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(SHADOW_COLOR);
        g2.fillRoundRect(SHADOW_SIZE, SHADOW_SIZE, getWidth() - SHADOW_SIZE * 2, getHeight() - SHADOW_SIZE * 2, 10, 10);
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(BORDER_COLOR);
        g2.drawRoundRect(SHADOW_SIZE, SHADOW_SIZE, getWidth() - SHADOW_SIZE * 2 - 1, getHeight() - SHADOW_SIZE * 2 - 1, 10, 10);
        g2.dispose();
    }

    @Override
    public Insets getInsets() {
        int value = SHADOW_SIZE + 1;
        return new Insets(value, value, value, value);
    }

    @Override
    public Insets getInsets(Insets insets) {
        int value = SHADOW_SIZE + 1;
        return new Insets(value, value, value, value);
    }
}
