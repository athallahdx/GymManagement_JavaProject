package com.util;

public class AppQuery {
	private DatabaseConnection dbc = new DatabaseConnection();
	
	public void addMember(com.model.Member member) {
		try {
            dbc.getDBConn();
            java.sql.PreparedStatement ps = dbc.getCon().prepareStatement("INSERT INTO `members`(`member_name`, `member_sex`, `member_birthdate`, `member_isstudent`, `member_registered_date`, `last_membership_payment_date`, `current_membership_due`, `membership_status`) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, member.getMemberName());
            ps.setString(2, member.getMemberSex());
            ps.setString(3, member.getMemberBirthdate());
            ps.setString(4, member.getMemberIsStudent());
            ps.setString(5, member.getMemberRegisteredDate());
            ps.setString(6, member.getLastMembershipPaymentDate());
            ps.setString(7, member.getCurrentMembershipDue());
            ps.setString(8, member.getMembershipStatus());
            ps.executeUpdate();
            dbc.closeConnection();
}
		}catch(

	Exception e)
	{
		e.printStackTrace();
		}
}
