package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTelegramBot extends TelegramLongPollingBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;
    private final String URL = "NASA_API-KEY";


    public MyTelegramBot(String BOT_NAME, String BOT_TOKEN) throws TelegramApiException {
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();

            String answer = update.getMessage().getText();
            String[] separetedAnswer = answer.split(" ");
            String action = separetedAnswer[0];

            switch (action) {
                case "/start":
                case "Старт":
                    sendMessage("Привет! Я бот, который присылает фотографии из NASA", chatId);
                    break;
                case "/help":
                case "Помощь":
                    sendMessage("Введите /image или /date", chatId);
                    break;
                case "/image":
                case "Загрузить изображение":
//                    String imageUrl = Utils.getUrl(URL);
//                    sendMessage(imageUrl, chatId);
                    sendMessage(Utils.getUrl(URL), chatId);
                    sendMessage(Utils.getName(URL), chatId);
                    break;
                case "/date":
                case "Указать дату":
//                    String date = separetedAnswer[1];
//                    imageUrl = Utils.getUrl(URL + "&date=" + date);
//                    sendMessage(imageUrl, chatId);
                    sendMessage("Введите дату в формате YYYY-MM-DD:", chatId);
                    break;

                default:
                    if (answer.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        String date = answer;
                        sendMessage(Utils.getUrl(URL + "&date=" + date), chatId);
                        sendMessage(Utils.getName(URL), chatId);
                    } else
                        sendMessage("Я не chatGPT и понимаю не всё...", chatId);
            }
        }
    }

    public void sendMessage(String text, long chatId) {
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        // Можно поступить разными путями и сделать клавиатуру, один из них в метод sendMessage добавляем:
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(); // разметка для клавиатуры
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//        List<KeyboardRow> keyboard = new ArrayList<>(); // список рядов нашей клавиатуры
//
//        KeyboardRow keyboardFirstRow = new KeyboardRow(); // создаем первый ряд
//        keyboardFirstRow.add("Старт"); // добавляем кнопку с описанием
//        keyboard.add(keyboardFirstRow); //добавляем наш первый ряд в список рядов
//
//        KeyboardRow keyboardSecondRow = new KeyboardRow(); // создаем второй ряд
//        keyboardSecondRow.add("Помощь"); // добавляем кнопку во втором ряду с описанием
//        keyboard.add(keyboardSecondRow); //добавляем наш второй ряд в список рядов
//
//        KeyboardRow keyboardThirdRow = new KeyboardRow(); // Добавляем третий ряд
//        keyboardThirdRow.add("Получить ссылку"); // добавляем кнопку в третьем ряду с описанием
//        keyboard.add(keyboardThirdRow);// добавляем третий ряд в список рядов
//        replyKeyboardMarkup.setKeyboard(keyboard); // доавляем все ряды
//        message.setReplyMarkup(keyboard); // привязываем клавиатуру к сообщению
    }


    @Override
    public String getBotUsername() {
        // TODO
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        // TODO
        return BOT_TOKEN;
    }
}
