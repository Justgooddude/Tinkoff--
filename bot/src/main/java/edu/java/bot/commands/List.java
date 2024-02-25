package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import static edu.java.bot.Bot.USERS_LINKS;

public class List extends AbsCommand {
    public List(AbsCommand command){
        super(command);
    }
    @Override
    public String execute(Update update) {
        if (update.message().text().equals("/list)")) {
            if (USERS_LINKS.get(update.message().from().id()).isEmpty()) {
                return "You not tracking anithing";
            }
            StringBuilder message = new StringBuilder();
            for (var link : USERS_LINKS.get(update.message().from().id())) {
                message.append(link).append('\n');
            }
            return message.toString();
        }
        return nextCommand.execute(update);
    }
}
