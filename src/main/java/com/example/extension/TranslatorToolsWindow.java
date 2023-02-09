package com.example.extension;

import com.example.ui.TranslatorWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TranslatorToolsWindow implements ToolWindowFactory {

    private static JTable table;
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // ContentFactory 在 IntelliJ 平台 SDK 中负责UI界面的管理
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        // 创建我们的工具栏界面
        // TranslatorNote note = new TranslatorNote();
        // table = note.getTable();
        TranslatorWindow translatorWindow = new TranslatorWindow();
        table = translatorWindow.getNoteTable();
        // 在界面工厂中创建翻译插件的界面
        Content content = contentFactory.createContent(translatorWindow.getMainPanel(), "", false);
        // 将被界面工厂代理后创建的 content，添加到工具栏窗口管理器中
        toolWindow.getContentManager().addContent(content);
    }

    // addNote 方法将翻译插件的原文与译文加入到工具栏窗口的表格视图中
    public static void addNote(String from, String to) {   
        if (table == null) {
            return;
        }
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(new Object[]{from, to});
    }

}