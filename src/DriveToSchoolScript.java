import edu.umn.crisys.plexil.java.psx.JavaPlexilScript;
import edu.umn.crisys.plexil.java.values.BooleanValue;
import edu.umn.crisys.plexil.java.values.CommandHandleState;
import edu.umn.crisys.plexil.java.values.RealValue;

public class DriveToSchoolScript
    extends JavaPlexilScript
{


    public DriveToSchoolScript() {
        addEvent(simultaneous(stateChange(BooleanValue.get((false)), "car_started"), stateChange(BooleanValue.get((false)), "raining"), stateChange(BooleanValue.get((true)), "no_passengers"), stateChange(BooleanValue.get((false)), "at_school"), stateChange(RealValue.get((0.0)), "time")));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "depress_accelerator"));
        addEvent(stateChange(RealValue.get((2.0)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "depress_accelerator"));
        addEvent(stateChange(RealValue.get((3.0)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "depress_accelerator"));
        addEvent(stateChange(RealValue.get((4.0)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "depress_clutch"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "turn_key"));
        addEvent(stateChange(BooleanValue.get((true)), "car_started"));
        addEvent(stateChange(RealValue.get((6.0)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "select_radio"));
        addEvent(stateChange(BooleanValue.get((true)), "raining"));
        addEvent(stateChange(RealValue.get((7.0)), "time"));
        addEvent(stateChange(RealValue.get((7.5)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "turn_on_wipers"));
        addEvent(stateChange(RealValue.get((8.0)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "turn_on_lights"));
        addEvent(stateChange(RealValue.get((9.0)), "time"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "drive_a_bit"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "drive_a_bit"));
        addEvent(commandAck(CommandHandleState.COMMAND_SUCCESS, "drive_a_bit"));
        addEvent(stateChange(BooleanValue.get((true)), "at_school"));
        reset();
    }

}
