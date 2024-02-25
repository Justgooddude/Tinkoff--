package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;
import java.util.List;
import static edu.java.bot.Bot.USERS_LINKS;

public class Start extends AbsCommand {
    public Start(AbsCommand command){
        super(command);
    }
    @Override
    public String execute(Update update){
        StringBuilder message;
        if(update.message().text().equals("/start")){
            if (!USERS_LINKS.containsKey(update.message().chat().id())){
                USERS_LINKS.put(update.message().from().id(), List.of());
            }
            return "User is registered";
        }
        if(!USERS_LINKS.containsKey(update.message().from().id())){
            return "you need to register";
        }
        return nextCommand.execute(update);
    }

}
