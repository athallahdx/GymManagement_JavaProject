package com.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppQuery {
    private DatabaseConnection dbc = new DatabaseConnection();
    
    public void addMember(com.model.Member member) {
        try {
            dbc.getDBConn();
            PreparedStatement ps = dbc.getCon().prepareStatement(
                "INSERT INTO `members`(`member_name`, `member_sex`, `member_birthdate`, `member_isstudent`, `member_registered_date`, `last_membership_payment_date`, `current_membership_due`, `membership_status`) VALUES (?,?,?,?,?,?,?,?)"
            );

            // Set the parameters based on the Member object
            ps.setString(1, member.getFullName());  // `member_name`
            ps.setString(2, member.getSex());  // `member_sex`
            ps.setDate(3, java.sql.Date.valueOf(member.getBirthdate()));  // `member_birthdate`
            ps.setBoolean(4, member.isStudent());  // `member_isstudent`
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(member.getRegisteredDate()));  // `member_registered_date`
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(member.getLastMembershipPaymentDate()));  // `last_membership_payment_date`
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(member.getCurrentMembershipDue()));  // `current_membership_due`
            ps.setString(8, member.getMembershipStatus());  // `membership_status`

            // Execute the update
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeConnection();  // Always close the connection in a finally block to ensure it gets closed
        }
    }
}
