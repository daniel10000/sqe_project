package at.fhhagenberg.sqe.javafxapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ElevatorSystemDummyTest.class, CommanderTest.class, DataUpdaterTest.class, ElevatorSystemModelTest.class })
public class ElevatorControlCenterTestSuite
{

}
