package edu.java.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import edu.java.bot.commands.CommandProcessor;
import edu.java.bot.configuration.ApplicationConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot {

    private final TelegramBot telegramBot;
    public static final Map<Long, List<String>> USERS_LINKS = new HashMap<>();

    public Bot(ApplicationConfig config) {
        telegramBot = new TelegramBot(config.telegramToken());
    }

    public void start() {
        BotComMenu.setMenuCommands(telegramBot);
        telegramBot.setUpdatesListener(updates -> {
            for (var elem : updates) {
                var res = CommandProcessor.PROCESSOR.execute(elem);
                var id = elem.message().chat().id();
                SendMessage request = new SendMessage(id, res);
                telegramBot.execute(request);
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
