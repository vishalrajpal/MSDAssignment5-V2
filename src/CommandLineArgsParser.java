
public class CommandLineArgsParser {

    String pattern;
	
    public CommandLineArgsParser(String pattern)
    {
    	this.pattern = pattern;
    }
    
    public void validateCommandAgainstPattern(String[] args)
    {
    	if(!validCommandLineArgs(pattern, args))
	    {
    		DAMPrototype.printErrorAndExit("incorrect command line");
	    }
    }
    
    private boolean validCommandLineArgs(String pattern, String[] args)
    {
    	boolean validArgs = true;
    	String[] splittedPattern = pattern.split(" ");
    	if(splittedPattern.length != args.length)
	    {
    		validArgs = false;
	    }
    	else
	    {
    		for(int argCounter = 0; argCounter<args.length; argCounter++)
		    {
    			String currentArg = args[argCounter];
    			String patternArg = splittedPattern[argCounter];
    			if(patternArg.charAt(0) == '-')
			    {
    				if(!currentArg.equals(patternArg))
				    {
    					validArgs = false;
    					break;
				    }
			    }
		    }
	    }
    	return validArgs;
    }
}
