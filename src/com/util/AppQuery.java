package com.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.model.MemberIn;
import com.model.MemberOut;

public class AppQuery {
    private DatabaseConnection dbc = new DatabaseConnection();
    
    public void addMember(MemberIn member) {
        try {
            dbc.getDBConn();
            PreparedStatement ps = dbc.getCon().prepareStatement(
                "INSERT INTO `members`(`member_name`, `member_sex`, `member_birthdate`, `member_phonenumber`, `member_isstudent`, `member_registered_date`, `last_membership_payment_date`, `current_membership_due`, `membership_status`) VALUES (?,?,?,?,?,?,?,?,?)"
            );

            ps.setString(1, member.getFullName());
            ps.setString(2, member.getSex());
            ps.setDate(3, java.sql.Date.valueOf(member.getBirthdate()));
            ps.setString(4, member.getPhoneNumber());
            ps.setBoolean(5, member.isStudent());
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(member.getRegisteredDate()));
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(member.getLastMembershipPaymentDate()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(member.getCurrentMembershipDue()));
            ps.setString(9, member.getMembershipStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeConnection();
        }
    }
    
    public MemberIn getMember(int memberId) {
        MemberIn member = null;
        try {
            dbc.getDBConn();
            PreparedStatement ps = dbc.getCon().prepareStatement("SELECT * FROM members WHERE member_id = ?");
            ps.setInt(1, memberId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Convert SQL types to Java types for the constructor
                member = new MemberIn(
                    rs.getInt("member_id"),                                 // id
                    rs.getString("member_name"),                             // fullName
                    rs.getString("member_sex"),                              // sex
                    rs.getDate("member_birthdate").toLocalDate(),            // birthdate
                    rs.getString("member_phonenumber"),                      // phoneNumber
                    rs.getBoolean("member_isstudent"),                       // isStudent
                    rs.getTimestamp("member_registered_date").toLocalDateTime(), // registeredDate
                    rs.getTimestamp("last_membership_payment_date").toLocalDateTime(), // lastMembershipPaymentDate
                    rs.getTimestamp("current_membership_due").toLocalDateTime(), // currentMembershipDue
                    rs.getString("membership_status")                        // membershipStatus
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }


    
    public ObservableList<MemberOut> getMemberList() {
        ObservableList<MemberOut> members = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM members ORDER BY member_id ASC";
            dbc.getDBConn();
            Statement st = dbc.getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            MemberOut member;
            
            while (rs.next()) {
                member = new MemberOut(
                    rs.getInt("member_id"),
                    rs.getString("member_name"),
                    rs.getString("member_sex"),
                    rs.getDate("member_birthdate").toLocalDate(),
                    rs.getString("member_phonenumber"),
                    rs.getBoolean("member_isstudent"),
                    rs.getTimestamp("member_registered_date").toLocalDateTime(),
                    rs.getTimestamp("last_membership_payment_date").toLocalDateTime(),
                    rs.getTimestamp("current_membership_due").toLocalDateTime(),
                    rs.getString("membership_status")
                );
                members.add(member);
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.closeConnection();
        }
        return members;
    }
    
	public void deleteMember(int memberId) {
        try {
            dbc.getDBConn();
            PreparedStatement ps = dbc.getCon().prepareStatement("DELETE FROM members WHERE member_id = ?");
            ps.setInt(1, memberId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    
    public void updateMember(MemberIn member) {
    	try {
    		dbc.getDBConn();
    		PreparedStatement ps = dbc.getCon().prepareStatement(
    		"UPDATE members " +
                 "SET " +
                 "member_name = ?, " +
                 "member_sex = ?, " +
                 "member_birthdate = ?, " +
                 "member_phonenumber = ?, " +
                 "member_isstudent = ?, " +
                 "member_registered_date = ?, " +
                 "last_membership_payment_date = ?, " +
                 "current_membership_due = ? " +
                 "WHERE member_id = ?"
    		);
            ps.setString(1, member.getFullName());
            ps.setString(2, member.getSex());
            ps.setDate(3, java.sql.Date.valueOf(member.getBirthdate()));
            ps.setString(4, member.getPhoneNumber());
            ps.setBoolean(5, member.isStudent());
            ps.setTimestamp(6, java.sql.Timestamp.valueOf(member.getRegisteredDate()));
            ps.setTimestamp(7, java.sql.Timestamp.valueOf(member.getLastMembershipPaymentDate()));
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(member.getCurrentMembershipDue()));
            ps.setInt(9, member.getId());
    		ps.execute();
    		ps.close();
    		dbc.closeConnection();	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    }

	public void updateMemberStatus(int id, String active) {
		try {
			dbc.getDBConn();
			if(active == "Activate") {
	    		PreparedStatement ps = dbc.getCon().prepareStatement(
	    		   "UPDATE members " + 
	    		      "SET " + 
	    			  "last_membership_payment_date = ?, " +
	    			  "current_membership_due = ?, " +
	    			  "membership_status = ? " + 
	    		      "WHERE member_id = ?"
	    		);
	    		ps.setTimestamp(1, java.sql.Timestamp.valueOf(LocalDateTime.now()));
	    		ps.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now().plusDays(31)));
	    		ps.setString(3, "Active");
	    		ps.setInt(4, id);
	    		ps.execute();
	    		ps.close();
	    		dbc.closeConnection();	
			}if(active == "Deactivate") {
				PreparedStatement ps = dbc.getCon().prepareStatement(
				   "UPDATE members " +
				      "SET " + 
				      "membership_status = ? " + 
				      "WHERE member_id = ?"
				);
				ps.setString(1, "Inactive");
				ps.setInt(2, id);
				ps.execute();
				ps.close();
            }
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
            dbc.closeConnection();
        }
	}
	
}
