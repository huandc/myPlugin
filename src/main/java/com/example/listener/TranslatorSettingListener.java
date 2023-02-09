package com.example.listener;

import com.example.extension.TranslatorSetting;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationAction;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;


public class TranslatorSettingListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull Project project) {

        if (!TranslatorSetting.getInstance().appID.equals("请输入appID") && !TranslatorSetting.getInstance().securityKey.equals("请输入securityKey")) {
            return;
        }
        Notification notification = new Notification("Print", "小天才翻译器", "请配置翻译 API 的 AppID 与密钥", NotificationType.INFORMATION);
        // 在提示消息中，增加一个 Action，可以通过 Action 一步打开配置界面
        notification.addAction(new OpenTranslatorSettingAction());
        Notifications.Bus.notify(notification, project);
    }

    static class OpenTranslatorSettingAction extends NotificationAction {

        OpenTranslatorSettingAction() {
            super("打开翻译插件配置界面");
        }

        @Override
        public void actionPerformed(@NotNull AnActionEvent e, @NotNull Notification notification) {
            // IntelliJ SDK 提供的一个工具类，可以通过配置项名字，直接显示对应的配置界面
            ShowSettingsUtil.getInstance().showSettingsDialog(e.getProject(), "Translator");
            notification.expire();
        }
    }
}
