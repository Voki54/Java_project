package ru.vlsu.ispi.springproject.daos.implementations;

import ru.vlsu.ispi.springproject.beans.Chat;
import ru.vlsu.ispi.springproject.daos.interfaces.ChatDao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatDaoImpl implements ChatDao {
    private final DataSource dataSource;

    public ChatDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addChat(Chat chat) {
        String query = "INSERT INTO chat (id, name) VALUES (?, ?)";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, chat.getId());
            statement.setString(2, chat.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error addChat: " + e.getMessage());
        }
    }

    @Override
    public void updateChat(Chat chat) {
        String query = "UPDATE chat SET name = ? WHERE id = ?";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setString(1, chat.getName());
            statement.setLong(2, chat.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updateChat: " + e.getMessage());
        }
    }

    @Override
    public void deleteChat(long chatId) {
        String query = "DELETE FROM chat WHERE id = ?";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, chatId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleteChat: " + e.getMessage());
        }
    }

    @Override
    public Chat getChatById(long chatId) {
        String query = "SELECT name FROM chat WHERE id = ?";
        Chat chat = null;
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query)) {
            statement.setLong(1, chatId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())
                    chat = new Chat(chatId, resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error getChatById: " + e.getMessage());
        }
        return chat;
    }

    @Override
    public List<Chat> getAllChats() {
        String query = "SELECT * FROM chat";
        ArrayList<Chat> chats = new ArrayList<>();
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next())
                chats.add(new Chat(
                        resultSet.getLong("id"),
                        resultSet.getString("name")));
        } catch (
                SQLException e) {
            System.out.println("Error getAllChats: " + e.getMessage());
        }
        return chats;
    }
}