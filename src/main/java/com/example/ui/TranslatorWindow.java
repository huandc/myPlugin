package com.example.ui;

import com.example.listener.TranslatorButtonActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TranslatorWindow {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JTable noteTable;
    private JPanel notePannel;
    private JPanel translatePannel;
    private JComboBox comboBox1;
    private JTextArea originalTextArea;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox5;
    private JButton translateButton;
    private JTextArea translateTextArea;
    public TranslatorWindow() {

        // 下拉框添加下拉选项
        comboBox1.addItem("英文");
        comboBox1.addItem("中文");
        comboBox2.addItem("中文");
        comboBox2.addItem("英文");

        // 备忘录表格属性设置
        String[] header = {"原文", "译文"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
        noteTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        noteTable.setModel(tableModel);

        // 按钮添加监听器
        translateButton.addActionListener(new TranslatorButtonActionListener(this));
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public void setTabbedPane1(JTabbedPane tabbedPane1) {
        this.tabbedPane1 = tabbedPane1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTable getNoteTable() {
        return noteTable;
    }

    public void setNoteTable(JTable noteTable) {
        this.noteTable = noteTable;
    }

    public JPanel getNotePannel() {
        return notePannel;
    }

    public void setNotePannel(JPanel notePannel) {
        this.notePannel = notePannel;
    }

    public JPanel getTranslatePannel() {
        return translatePannel;
    }

    public void setTranslatePannel(JPanel translatePannel) {
        this.translatePannel = translatePannel;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JTextArea getOriginalTextArea() {
        return originalTextArea;
    }

    public void setOriginalTextArea(JTextArea originalTextArea) {
        this.originalTextArea = originalTextArea;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public void setComboBox2(JComboBox comboBox2) {
        this.comboBox2 = comboBox2;
    }

    public JComboBox getComboBox3() {
        return comboBox3;
    }

    public void setComboBox3(JComboBox comboBox3) {
        this.comboBox3 = comboBox3;
    }

    public JComboBox getComboBox5() {
        return comboBox5;
    }

    public void setComboBox5(JComboBox comboBox5) {
        this.comboBox5 = comboBox5;
    }

    public JButton getTranslateButton() {
        return translateButton;
    }

    public void setTranslateButton(JButton translateButton) {
        this.translateButton = translateButton;
    }

    public JTextArea getTranslateTextArea() {
        return translateTextArea;
    }

    public void setTranslateTextArea(JTextArea translateTextArea) {
        this.translateTextArea = translateTextArea;
    }
}
