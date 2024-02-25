package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import java.util.ArrayList;
import static edu.java.bot.Bot.USERS_LINKS;

public class Track extends AbsCommand {
    public Track(AbsCommand command) {
        super(command);
    }

    @Override
    public String execute(Update update) {
        String answer = "";
        var message = update.message().text().split(" ");
        if (message[0].equals("/track")) {
            if (message.length < 2) {
                answer = "You need to write link";
            } else {
                if (message[1].startsWith("http")) {
                    answer = "Link is tracking";
                    long id = update.message().from().id();
                    var refr = new ArrayList<>(USERS_LINKS.get(id));
                    refr.add(message[1]);
                    USERS_LINKS.replace(id, refr);
                } else {
                    answer = "you need to write http link";
                }
            }
            return answer;
        }
        return nextCommand.execute(update);
    }

}
