
import edu.umn.crisys.plexil.java.PlexilDriver;
import edu.umn.crisys.plexil.java.TestGenerationInfo;
import edu.umn.crisys.plexil.java.plx.*;
import edu.umn.crisys.plexil.java.psx.symbolic.*;
import edu.umn.crisys.plexil.java.world.*;
import edu.umn.crisys.plexil.java.values.*;


public class SchoolDriver implements TestGenerationInfo {
	
	
	public static void main(String[] args) throws Exception {
		PlexilDriver.mainMethod(new SchoolDriver(), args);
	}
	
	@Override
	public JavaPlan createPlanUnderTest(ExternalWorld world) {
		return new DriveToSchool(world);
	}
	@Override
	public SymbolicDecisionMaker createDecisionMaker(ValueSource values) {
		SymbolicDecisionMaker search = new MinimalEventStrategy(values);
		// Respond to all the commands with either success or failure
		search.addCommand("push_start", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("select_radio", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("turn_on_wipers", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("depress_clutch", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("depress_accelerator", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("turn_on_lights", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("turn_key", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("select_CD", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		search.addCommand("drive_a_bit", CommandHandleState.COMMAND_SUCCESS,
				CommandHandleState.COMMAND_FAILED);
		// Lookups. They are all booleans.
		search.addLookup("raining", PlexilType.BOOLEAN);
		search.addLookup("at_school", PlexilType.BOOLEAN);
		search.addLookup("no_passengers", PlexilType.BOOLEAN);
		search.addLookup("car_started", PlexilType.BOOLEAN);

		// Time should be an integer.
		search.addIncreasingLookup("time", 0);
		return search;
	}
	@Override
	public ValueSource createSymbolicValueSource() {
		return new SPFValues();
	}
}

