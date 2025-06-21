package com.example.sapatatix.dao;

import com.example.sapatatix.database.DBUtil;
import com.example.sapatatix.Model.EventBanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventBannerDAO {
    public static boolean insertEventBanner(EventBanner banner) {
        String sql = "INSERT INTO event_banner (banner_image_path) VALUES (?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, banner.getBannerImagePath());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}