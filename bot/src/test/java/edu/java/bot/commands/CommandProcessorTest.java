package edu.java.bot.commands;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import edu.java.bot.Bot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommandProcessorTest {

    private Update update;
    private Message message;

    @BeforeEach
    void initMocks() {
        update = mock(Update.class);
        message =  mock(Message.class);
        Chat chat = mock(Chat.class);
        var chatId = 1L;
        when(update.message()).thenReturn(message);
        when(message.chat()).thenReturn(chat);
        when(chat.id()).thenReturn(chatId);
        when(update.message().from()).thenReturn(mock(com.pengrad.telegrambot.model.User.class));
        when(update.message().from().id()).thenReturn(1L);
    }

    @Test
    public void helpTest() {
        when(message.text()).thenReturn("/help");
        var text = CommandProcessor.PROCESSOR.execute(update);
        assertEquals("""
                    /start - Start the bot
                    /track - Add new site for tracking
                    /untrack - Stop site tracking
                    /list - Show the list of tracked links
                    /help - Get help""", text);
    }

    @Test
    public void listTest() {
        Bot.USERS_LINKS.put(1l, List.of());
        when(message.text()).thenReturn("/list");
        var text = CommandProcessor.PROCESSOR.execute(update);
        assertEquals("You not tracking anithing", text);
    }

    @Test
    public void startTest() {
        when(message.text()).thenReturn("/start");
        var text = CommandProcessor.PROCESSOR.execute(update);
        assertEquals("User is registered", text);
    }

    @Test
    public void trackingTest() {
        Bot.USERS_LINKS.put(1l, List.of());
        when(message.text()).thenReturn("/track https://github.com/sanyarnd/tinkoff-java-course-2023/");
        var text = CommandProcessor.PROCESSOR.execute(update);
        assertEquals("Link is tracking", text);
    }
    @Test
    public void unknownProcessorTest() {
        when(message.text()).thenReturn("/random");
        var text = CommandProcessor.PROCESSOR.execute(update);
        assertEquals("Unknown command. Print /help to see aviable commands", text);
    }

    @Test
    public void untrackingTest() {
        Bot.USERS_LINKS.put(1L,List.of("https://github.com/sanyarnd/tinkoff-java-course-2023/")) ;
        when(message.text()).thenReturn("/untrack https://github.com/sanyarnd/tinkoff-java-course-2023/");
        var text = CommandProcessor.PROCESSOR.execute(update);
        assertEquals("Link is untracted", text);
    }

}
