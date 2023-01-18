package tamp;

import java.sql.Connection;

import consolecolors.ConsoleColor;
import util.DBUtil;

public class Demo {

	public static void main(String[] args) {
		
		Connection conn=DBUtil.getConnection();
		//System.out.println( ConsoleColor.GREEN_BOLD +conn+ ConsoleColor.RESET+ "amit");
		
	}
}
