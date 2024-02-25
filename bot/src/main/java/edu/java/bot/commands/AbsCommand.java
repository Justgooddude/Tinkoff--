package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Update;

public abstract class AbsCommand {
    AbsCommand nextCommand;

    public AbsCommand(AbsCommand nextCom) {
        nextCommand =  nextCom;
    }

    abstract public String execute(Update update);
}
