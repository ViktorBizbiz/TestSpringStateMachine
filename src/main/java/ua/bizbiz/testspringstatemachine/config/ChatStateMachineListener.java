package ua.bizbiz.testspringstatemachine.config;

import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import ua.bizbiz.testspringstatemachine.entity.Events;
import ua.bizbiz.testspringstatemachine.entity.States;

public class ChatStateMachineListener extends StateMachineListenerAdapter<States, Events> {
  @Override
  public void stateChanged(State<States, Events> from, State<States, Events> to) {
    System.out.printf("State changed from %s to %s \n", from == null ? "none" : from.getId(), to.getId());
  }
}
