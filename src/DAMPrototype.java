
public class DAMPrototype{
    
    /**
     * printErrorAndString : String -> void
     * @GIVEN: A String 
     * @EFFECT: Prints the given String to standard error if not null
     * @param errorString: The String to print
     */
    public static void printErrorAndExit(String errorString)
    {
    	if(errorString!=null)
	    {
    		System.err.println("ERROR: " + errorString);
    		System.exit(1);
	    }
    }
    
    /**
     * main: String[] -> void
     * @GIVEN: An array of type String
     * @EFFECT: The program is initiated through this function
     * @param args: An array of type String having all the Command Line Arguments as entries
     */
    public static void main(String[] args)
    {
    	String pattern = "-f <pathname> -f <pathname>";
    	
    	CommandLineArgsParser cmdParser = new CommandLineArgsParser(pattern);
    	//cmdParser.validateCommandAgainstPattern(args);
    	
    	FileManager fm = new FileManager();
    }
}
