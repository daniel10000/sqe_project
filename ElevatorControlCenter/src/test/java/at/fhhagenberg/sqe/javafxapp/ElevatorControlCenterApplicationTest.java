package at.fhhagenberg.sqe.javafxapp;

import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;

public class ElevatorControlCenterApplicationTest {
	FxRobot robot;

	@Before
	public void setup() throws TimeoutException {
		FxToolkit.registerPrimaryStage();
		FxToolkit.setupApplication(ElevatorControlCenterApplication.class);

		robot = new FxRobot();
	}

	@Test
	public void testComputeSum() {
		robot.clickOn("#a").write("1");
		robot.clickOn("#b").write("2");

		robot.clickOn(NodeMatchers.hasText("="));

		FxAssert.verifyThat(".label.sum", LabeledMatchers.hasText("3,00"));
	}

	@Test
	@Ignore
	public void testComputeSumNoInput() {
		robot.clickOn("#compute");

		FxAssert.verifyThat(".label.sum", LabeledMatchers.hasText("n/a"));
	}
}
