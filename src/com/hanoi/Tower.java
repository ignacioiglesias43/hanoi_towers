package com.hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

public class Tower extends JPanel {

    private static final int height = 200;
    private static final int weight = 10;
    private static final int baseWeight = 180;
    private static final int baseHeight = 10;
    private static final int y = 150;
    private static final int yBase = 340;
    private static final Color color = Color.BLACK;
    private static final int x = 80;
    private static final int xBase = 0;
    private Stack<Disk> disks = new Stack<>();

    public Tower() {
        setBackground(new Color(157, 157, 166));
    }

    public Stack<Disk> getDisks() {
        return disks;
    }

    public void setDisks(Stack<Disk> disks) {
        this.disks = disks;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D tower = (Graphics2D) g;
        tower.setColor(color);
        /* Rectangulo */
        tower.fill(new Rectangle2D.Double(x,y,weight,height));
        /* Base */
        tower.fill(new Rectangle2D.Double(xBase,yBase,baseWeight,baseHeight));

        for (Disk disk : disks) {
            Graphics2D draw = (Graphics2D) g;
            int index = disks.indexOf(disk);
            int y = index == 0 ? 310 : 280 - 30*(index-1);
            disk.setY(y);
            draw.setColor(disk.color);
            draw.fill(new Rectangle2D.Double(disk.x, disk.y, disk.weight, disk.height));
        }
    }
}
