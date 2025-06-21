package com.example.sapatatix.dao;

import com.example.sapatatix.database.DBUtil;
import com.example.sapatatix.Model.Ticket; // Pastikan menggunakan Model dengan 'M' kapital

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    public static boolean insertTicket(Ticket ticket) {
        String sql = "INSERT INTO ticket (id_event, ticket_name, price, quantity, ticket_type) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getIdEvent());
            stmt.setString(2, ticket.getTicketName());
            stmt.setDouble(3, ticket.getPrice());
            stmt.setInt(4, ticket.getQuantity());
            stmt.setString(5, ticket.getTicketType());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            return false;
        }
    }

    public static List<Ticket> getTicketsByEventId(int eventId) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT id_ticket, id_event, ticket_name, price, quantity, ticket_type FROM ticket WHERE id_event = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket(
                        rs.getInt("id_ticket"),
                        rs.getInt("id_event"),
                        rs.getString("ticket_name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("ticket_type")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}