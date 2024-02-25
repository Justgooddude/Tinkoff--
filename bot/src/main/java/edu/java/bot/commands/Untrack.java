package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import java.util.ArrayList;
import static edu.java.bot.Bot.USERS_LINKS;

public class Untrack extends AbsCommand {
    public Untrack(AbsCommand command) {
        super(command);
    }

    @Override
    public String execute(Update update) {
        String answer = "";
        var message = update.message().text().split(" ");
        if (message[0].equals("/untrack")) {
            if (message.length < 2) {
                answer = "You need to write link";
            } else {
                if (message[1].startsWith("http")) {
                    var id = update.message().from().id();
                    if (USERS_LINKS.get(id).contains(message[1])) {
                        var deleted = new ArrayList<>(USERS_LINKS.get(id));
                        deleted.remove(message[1]);
                        USERS_LINKS.replace(id, deleted);
                        answer = "Link is untracted";
                    } else {
                        answer = "There is no suck link";
                    }

                }
            }
            return answer;
        }
        return nextCommand.execute(update);

    }

}
