package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;

public class Help extends AbsCommand {
    public Help(AbsCommand command){
        super(command);
    }
    @Override
    public String execute(Update update){
        if (update.message().text().strip().equals("/help")) {
            return """
                    /start - Start the bot
                    /track - Add new site for tracking
                    /untrack - Stop site tracking
                    /list - Show the list of tracked links
                    /help - Get help""";
        }
        return nextCommand.execute(update);

    }

}
