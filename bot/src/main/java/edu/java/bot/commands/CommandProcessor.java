package edu.java.bot.commands;

public class CommandProcessor {
    private CommandProcessor() {
    }

    public static final AbsCommand PROCESSOR = new Start(
        new Help(
            new Track(
                new Untrack(
                    new List(
                                new UnknownCommand(null)
                            )))));
}
