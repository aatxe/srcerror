import java.awt.*;
import java.awt.event.*;

public class ClassSpambot {
    
    private Robot robot;
    
    public ClassSpambot() throws java.awt.AWTException {
        
        robot = new Robot();
        robot.mouseMove( 3250, 500 );
        robot.mousePress( 16 );
        robot.delay( 50 );
        robot.mouseRelease( 16 );
       
       
        // First TextField --> y = 270;
        // Second Textfield --> y = 370;
        // Third Textfield --> y = 470;
        // Fourth Textfield --> y = 540;
        // Fifth Textfield --> y = 620;
        // Sixth Textfield --> y = 680;
        // Seventh Textfield --> y= 770;
        // Eigth Textfield --> y = 830;
        // Ninth Textfield --> y = 920;
        // Tenth Textfield --> y = 980;
        // Eleventh Textfield --> y = 1070;
        // Scrolled down.
        // Twelfth Textfield --> y = 540;
        // Thirteenth Textfield --> y = 610;
        // Fourteenth Textfield --> y = 680;
        // Fifteenth Textfield --> y = 750;
        // Sixteenth Texfield --> y = 820;
        // Seventeenth Textfield --> y = 900;
        
        int[] textFieldYs = { 270, 370, 470, 540, 620, 680, 770, 830, 920, 980, 1070, 540, 610, 680, 750, 820, 900 };
        
        String[][] data = new String[ 16 ][];

        String[] AdayBlock1Teacher = { "Salmestrelli", "Jablonski", "Fasanella", "Study hall", "Staff", "Czelusniak", "Drake", "Mealy", "Hartmann", "Cornell", "Bencivengo", "Savas", "Koricki", "Christie", "Hsuchen",
            "Jetton", "Serughetti", "Scarpitta", "Allen", "Fantry", "Goodkin", "Allison", "Christie, L", "Study Hall", "Wong", "SooHoo", "Mingrone", "Enz", "Crochetiere", "Reca", "Joyce" };
        data[ 0 ] = AdayBlock1Teacher;
        
        String[] AdayBlock1Room = { "Gym", "205", "200", "201", "405", "215", "216", "213", "217", "A211", "109", "221", "A209", "224", "225", "226", "Gym 6", "Gym 5", "A202", "114", "300", "303", "LDH",
            "A104", "A107", "A106", "A101", "A110", "A118", "A116", "A113", "A111" };
        data[ 1 ] = AdayBlock1Room;
        
        String[] AdayBlock2Teacher = { "Kiernen", "Hussong", "Fasanella", "Czelusniak", "Staff", "Benbrahim", "Kavanagh", "Drake", "Mr.Allen", "Martens", "Haut", "Hartmann", "Marshall, K", "Savas", "Knorr", "Snyder",
            "Bugge", "Hsuchen", "Jetton", "Wishart", "Allen", "Williams", "Totaro", "Ellingson", "conrad", "Allison", "Stubbs", "Blackman", "Arias", "Bond", "Connolly", "Biro", "Study Hall", "Bendrahim", "Thyrum",
            "Christie", "Curtis", "Conrad" };
        data[ 2 ] = AdayBlock2Teacher;
        
        String[] AdayBlock2Room = { "202", "Gym", "204", "208", "209", "405", "404", "210", "215", "213", "A214", "A211", "A212", "A213", "109", "108", "105", "A209", "224", "225", "A207", "227", "A205", "A203", "A204",
            "A202", "114", "115", "119", "LDH", "A106", "A103", "A110", "A115" };
        data[ 3 ] = AdayBlock2Room;
        
        String[] AdayBlock3Teacher = { "Richards", "Curtis", "Study hall", "Staff", "Boyce", "Kavanagh", "Mealy", "Clementson", "Dean", "Egner", "Soohoo", "Clovis", "Bugge", "Haut", "Nicosia", "Sieben", "Snyder", "Allen",
            "Goodkin", "Warner", "Pisano, C", "Vostal", "Thambidurai", "Yu", "Stubbs", "Drake", "Bartram", "Margerum", "Shea", "Study Hall", "SooHoo", "Mingrone", "Celin", "Curtis", "Vogt", "Crochetiere", "Reca", "Joyce" };
        data[ 4 ] = AdayBlock3Teacher;
        
        String[] AdayBlock3Room = { "202", "203", "Gym", "209", "405", "212", "215", "216", "A214", "217", "A210", "Gym", "A211", "A212", "A213", "108", "106", "105", "225", "A205", "Gym 5", "A200", "115", "A203", "A108",
            "LDH", "A105", "A104", "A107", "A106", "A101", "A103", "A116", "A112" };
        data[ 5 ] = AdayBlock3Room;
        
        String[] AdayBlock4Teacher = { "Salmestrelli", "Pross", "Carter", "Chu", "Stanley", "Study hall", "Staff", "Mealy", "Miller", "Martens", "Haut", "Dean", "Bencivengo", "Knorr", "Marshall", "Bugge", "Blackman, S",
            "Colella", "Romero", "Serughetti", "Kreutter", "scarpitta", "Vostal", "Stubbs", "Bossio", "Arias", "Shea", "Study Hall", "McDowell", "Thyrum", "Mingrone", "Celin", "Enz", "Romero", "McDowell", "Conrad", "Vogt", 
            "Reca" };
        data[ 6 ] = AdayBlock4Teacher;                
        
        String[] AdayBlock4Room = { "Gym", "204", "205", "209", "405", "212", "210", "215", "213", "A214", "217", "A210", "106", "A209", "226", "A205", "229", "A204", "A201", "A202", "A200", "117", "115", "300",
            "301", "303", "Study Hall", "LDH", "A106", "A101", "A118", "A117", "A112" };
        data[ 7 ] = AdayBlock4Room;
        
        String[] AdayBlock5Teacher = { "Patel", "Staff", "Boyce", "Czelusniak", "Kavanagh", "Drake", "DeSanctis", "Mealy", "Dean", "Santoro M", "Egner", "Soohoo", "Clovis", "Bugge", "Colella", "Hsuchen", "independent study", 
            "Castro-Verrault", "Serughetti", "Fantry", "Warner", "Arias", "Biro", "Study Hall", "Studyhall", "Thyrum", "Rodrigo", "Nunziato", "Curtis", "Vogt", "Crochetiere" };
        data[ 8 ] = AdayBlock5Teacher;
        
        String[] AdayBlock5Room = { "lifeskills", "202", "Gym", "204", "200", "209", "405", "210", "215", "216", "213", "A214", "A212", "108", "106", "105", "A207", "A205", "A206", "Gym 5", "A201", "A202", 
                "Gym 6", "LDH", "A105", "A106", "A103", "A112", "A111" };
        data[ 9 ] = AdayBlock5Room;
        
        String[] AdayBlock6Teacher = { "Patel", "Stanley", "Fasanella", "Gym", "Staff", "Collela", "N/A", "Drake", "Martens", "Cabaniss-Kreultter", "Clovis", "Knorr", "Marshall", "Paulsson", "Colella", 
                "Sieben", "Serughetti", "Scarpitta", "Cabaniss-Kreutter", "Vostal", "Tessein", "Study Hall", "Thambidurai", "Stubbs", "Blackman", "Costello", "Warren", "Bond", "O'Donnell", 
                        "Biro", "Margerum", "Study Hall", "Santoro", "Wong", "staff", "White", "Kreutter", "Tomlinson" };
        data[ 10 ] = AdayBlock6Teacher;
        
        String[] AdayBlock6Room = { "Gym", "201", "208", "404", "210", "216", "A214", "217", "A212", "A213", "Gym 5", "109", "108", "105", "101", "224", "A209", "A203", "A204", "A201", "A202", "A200",
                "115", "Study Hall", "300", "A108", "LDH", "A105", "A104", "A101", "A103", "A113", "A112" };
        data[ 11 ] = AdayBlock6Room;
        
        String[] BdayBlock1Teacher = { "Salmestrelli", "Corriveau", "Chu", "Staff", "Boyce", "Biro", "Mealy", "Martens", "Cornell", "Benitez-Morales", "Pisano", "Clovis", "Paulsson", "Totaro, B", "Goodkin", 
                 "Warner", "Totaro", "Tessein", "Allison", "Lag", "Bossio", "Bond", "Connolly", "Biro", "Shea", "Study Hall", "Alison", "Mingrone", "Enz", "Bond", "Conrad", "studyhall", "Joyce" };
        data[ 12 ] = BdayBlock1Teacher;
        
        String[] BdayBlock1Room = { "114", "Gym", "Staff", "205", "200", "208", "209", "215", "214", "A214", "A212", "109", "225", "226", "A207", "229", 
            "A200", "Gym 4", "114", "119", "303", "LDH", "A105", "A104", "A107", "A101", "A118", "A116", "A113" };
        data[ 13 ] = BdayBlock1Room;
        
        String[] BdayBlock4Teacher = { "Koricki", "Curtis", "Pross", "Breisacher", "Crochietere", "Chu", "Staff", "Boyce", "Czelusniak", "Kavanagh", "Hare", "Cornell", "O'hare", "Savas", "Loveland", "Clovis", "Study hall",
                "Paulsson", "Scarpitta", "Curtis, S", "Allen", "Fantry", "Williams", "Thambidurai", "Stubbs", "Warren", "Bond", "Petrocelli", "Biro", "Shea", "Study Hall", "Thyrum", "SooHoo", "Middlemiss", 
                        "Celin", "Curtis", "haut", "Vogt", "Crochetiere", "Reca", "O'Hare", "Joyce" };
        data[ 14 ] = BdayBlock4Teacher;
        
        String[] BdayBlock4Room = { "203", "Gym", "200", "201", "208", "209", "A103", "403", "210", "215", "216", "213", "A214", "A212", "A213", "108", "106", "105", "227", "A203", "Gym 6", "A204", 
                "A202", "A200", "Gym 3", "Gym 4", "114", "LDH", "A105", "A107", "A103", "A102", "A118", "A116", "A115", "A111" };
        data[ 15 ] = BdayBlock4Room;
        
        for( int i = 0; i < 10; i++ ) {
            
                    
            robot.mouseMove( 3250, 500 );
            robot.mousePress( 16 );
            robot.delay( 50 );
            robot.mouseRelease( 16 );
       
            robot.delay( 1000 );
            robot.mouseWheel( 5000000 );
            robot.delay( 1000 );
            robot.mouseWheel( -6 );
            robot.delay( 1000 );
    
            for( int j = 0; j < textFieldYs.length; j++ ) {
                robot.mouseMove( 2000, textFieldYs[ j ] );
                robot.mousePress( 16 );           
                robot.delay( 50 );
            
                
                if( j == 0 ) {
                    String s = "Waldo";
                    for( int k = 0; k < s.length(); k++ ) {
                        if( Character.isUpperCase( s.charAt( k ) ) ) {
                            robot.keyPress( KeyEvent.VK_SHIFT );
                            robot.keyPress( charToInt( s.charAt( k ) ) );
                            robot.keyRelease( KeyEvent.VK_SHIFT );
                        }
                        else {
                            robot.keyPress( charToInt( s.charAt( k ) ) );
                        }
                        robot.delay( 50 );
                    }
                }
                else {
                    int index = ( int )( Math.random() * ( data[ j - 1 ].length ) );
                    String s = data[ j - 1 ][ index ];
                    for( int k = 0; k < s.length(); k++ ) {
                        if( Character.isUpperCase( s.charAt( k ) ) ) {
                            robot.keyPress( KeyEvent.VK_SHIFT );
                            robot.keyPress( charToInt( s.charAt( k ) ) );
                            robot.keyRelease( KeyEvent.VK_SHIFT );
                        }
                        else {
                            robot.keyPress( charToInt( s.charAt( k ) ) );
                        }
                        robot.delay( 50 );
                    }
                }

                robot.delay( 50 );
            
                if( textFieldYs[ j ] == 1070 ) {
                    robot.mouseMove( 3250, 500 );
                    robot.mousePress( 16 );
                    robot.delay( 50 );
                    robot.mouseRelease( 16 );
                    robot.mouseWheel( 5000000 );
                }
            
                robot.delay( 100 );
            }
            
            robot.delay( 50 );
            robot.mouseMove( 1950, 950 );
            robot.mousePress( 16 );
            robot.delay( 50 );
            robot.mouseRelease( 16 );
            robot.delay( 50 );
            robot.mouseWheel( -6 );
            robot.delay( 1000 );
         
            
            robot.mouseMove( 2150, 300 );
            robot.delay( 100 );
            robot.mousePress( 16 );
            robot.delay( 100 );
            robot.mouseRelease( 16 );
        }
        
    }
    public static void main( String[] args ) {
        
    	try {
        	new ClassSpambot();
    	}
    	catch( AWTException e ) {
    		e.printStackTrace();
    	}

    }
    
    private int charToInt( char c ) {
        
        if( Character.isLowerCase( c ) ) {
            return ( int )( c ) - 32;
        }
        else {
            return ( int )( c );
        }
    }
}