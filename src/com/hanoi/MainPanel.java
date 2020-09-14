package com.hanoi;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class MainPanel extends JPanel {
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel comboBoxPanel = new JPanel();
    private JComboBox disks = new JComboBox();
    private JButton btnInit = new JButton("Iniciar");
    private JLabel disksLabel = new JLabel("Selecciona el número de discos: ");
    private Tower tower = new Tower();
    private Tower tower1 = new Tower();
    private Tower tower2 = new Tower();
    private Stack<Integer> origin = new Stack<>();
    private Stack<Integer> aux = new Stack<>();
    private Stack<Integer> end = new Stack<>();
    private Stack<Disk> arrayDisks = new Stack<>();

    public MainPanel(){
        setBackground(new Color(157, 157, 166));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,40,20));
        comboBoxPanel.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        topPanel.setLayout(new GridLayout(1,3, 30,0));
        topPanel.setBackground(new Color(157, 157, 166));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(new Color(157, 157, 166));
        comboBoxPanel.setBackground(new Color(157, 157, 166));
        disks.addItem(1);
        disks.addItem(2);
        disks.addItem(3);
        disks.addItem(4);
        disks.addItem(5);

        disks.setPreferredSize(new Dimension(250,30));
        btnInit.setPreferredSize(new Dimension(450,30));

        disksLabel.setLabelFor(disks);

        comboBoxPanel.add(disksLabel, BorderLayout.EAST);
        comboBoxPanel.add(disks, BorderLayout.WEST);

        bottomPanel.add(comboBoxPanel, BorderLayout.NORTH);
        bottomPanel.add(btnInit, BorderLayout.SOUTH);
        topPanel.add(tower);
        topPanel.add(tower1);
        topPanel.add(tower2);
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        disks.addActionListener(e -> {
            fillOrigin();
        });

        btnInit.addActionListener(e -> {
            System.out.println("origin: " + origin);
            System.out.println("aux: " + aux);
            System.out.println("end: " + end);

            hanoi(origin.size(), origin, aux, end);
        });
    }
    private void hanoi(int disks, Stack<Integer> origin, Stack<Integer> aux, Stack<Integer> end) {
        if(disks == 1) {
            move(origin.pop(), end);
        } else {
            hanoi(disks-1,origin, end, aux);
            move(origin.pop(), end);
            hanoi(disks-1,aux, origin, end);
        }
    }

    // Esta función es para visualizar en consola el progreso
    private void move(int n, Stack<Integer> target) {
        target.push(n);
        System.out.println("origin: " + origin);
        System.out.println("aux: " + aux);
        System.out.println("end: " + end);
    }

    // Llena la pila de origen de acuerdo a la seleccion del usuario
    private void fillOrigin() {
        origin.clear();
        aux.clear();
        end.clear();
        arrayDisks.clear();
        tower.setDisks(arrayDisks);
        int limit = (int) disks.getSelectedItem();

        for (int i = limit; i > 0; i--) {
            origin.push(i);
            Disk disk = new Disk(i);
            arrayDisks.push(disk);
        }
        tower.setDisks(arrayDisks);
        repaint();
    }
}
