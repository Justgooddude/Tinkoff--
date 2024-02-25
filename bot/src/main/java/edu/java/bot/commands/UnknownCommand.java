package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;

public class UnknownCommand extends AbsCommand{
    public UnknownCommand(AbsCommand command){
        super(command);
    }
    @Override
    public String execute(Update update){
        return "Unknown command. Print /help to see aviable commands";
    }
}
