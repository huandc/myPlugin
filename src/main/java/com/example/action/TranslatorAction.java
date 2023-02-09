package com.example.action;

import com.example.extension.TranslatorCache;
import com.example.util.TranslatorUtils;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
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
        // 获取到持久化数据对象
        Map<String, String> transCache = TranslatorCache.getInstance(e.getProject()).transCache;
        String transResult;
        // 缓存存在查询缓存，不存在通过 API 查询
        if (transCache.containsKey(text)) {
            transResult = transCache.get(text);
        } else {
            transResult = TranslatorUtils.getTransResult(text, "auto", "zh");
            transCache.put(text, transResult);
        }        Notifications.Bus.notify(new Notification("Translate", "This is translator", transResult, NotificationType.INFORMATION), e.getProject());

    }
}
