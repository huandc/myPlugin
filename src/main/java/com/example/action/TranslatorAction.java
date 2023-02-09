package com.example.action;

import com.example.util.TranslatorUtils;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TranslatorAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (Objects.isNull(TranslatorUtils.appid) || Objects.isNull(TranslatorUtils.securityKey)) {
            Notifications.Bus.notify(new Notification("Translate", "This is translator", "Please appid,securityKey", NotificationType.ERROR), e.getProject());
            return;
        }
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        // getSelectionModel() 可获取到鼠标选中文本对象，通过 getSelectedText() 方法获取到选中的文本字符串
        assert editor != null;
        String text = editor.getSelectionModel().getSelectedText();
        String transResult = TranslatorUtils.getTransResult(text, "auto", "zh");
        Notifications.Bus.notify(new Notification("Translate", "This is translator", transResult, NotificationType.INFORMATION), e.getProject());

    }
}
