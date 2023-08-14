package ua.bizbiz.testspringstatemachine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import ua.bizbiz.testspringstatemachine.entity.Events;
import ua.bizbiz.testspringstatemachine.entity.States;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {
  
  @Override
  public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
    config.withConfiguration().listener(listener());
  }
  
  @Override
  public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
    states.withStates()
            .initial(States.AUTH)
            .states(EnumSet.allOf(States.class));
  }
  
  @Override
  public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
    transitions
            .withExternal().source(States.AUTH).target(States.AUTH_SUCCESS_AS_ADMIN).event(Events.ENTER_ADMIN_SECRET_CODE)
            .and()
            .withExternal().source(States.AUTH).target(States.AUTH_SUCCESS_AS_USER).event(Events.ENTER_USER_SECRET_CODE)
            .and()
            .withExternal().source(States.AUTH).target(States.AUTH_FAILED).event(Events.ENTER_INCORRECT_SECRET_CODE);
  }
  
  @Bean
  public StateMachineListener<States, Events> listener() {
    return new ChatStateMachineListener();
  }
}
