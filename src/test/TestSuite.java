package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestGame.class, TestConversation.class, TestPlayer.class, TestCommandParser.class})
public final class TestSuite {

}