package ua.bizbiz.testspringstatemachine;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;
import ua.bizbiz.testspringstatemachine.entity.Events;
import ua.bizbiz.testspringstatemachine.entity.States;

@SpringBootTest
class TestSpringStateMachineApplicationTests {
  
  @Autowired
  private StateMachineFactory<States, Events> factory;
  
  @Test
  void adminMachine() {
    StateMachine<States, Events> sm = factory.getStateMachine();
    
    sm.startReactively().subscribe();
    
    Mono<Message<Events>> msg = Mono.just(MessageBuilder.withPayload(Events.ENTER_ADMIN_SECRET_CODE).build());
    sm.sendEvent(msg)
            .doOnComplete(() -> System.out.println("Event handling complete"))
            .subscribe();
  }
  
  @Test
  void userMachine() {
    StateMachine<States, Events> sm = factory.getStateMachine();
    
    sm.startReactively().subscribe();
    
    Mono<Message<Events>> msg = Mono.just(MessageBuilder.withPayload(Events.ENTER_USER_SECRET_CODE).build());
    sm.sendEvent(msg)
            .doOnComplete(() -> System.out.println("Event handling complete"))
            .subscribe();
  }
  
  @Test
  void incorrectPassword() {
    StateMachine<States, Events> sm = factory.getStateMachine();
    
    sm.startReactively().subscribe();
    
    Mono<Message<Events>> msg = Mono.just(MessageBuilder.withPayload(Events.ENTER_INCORRECT_SECRET_CODE).build());
    sm.sendEvent(msg)
            .doOnComplete(() -> System.out.println("Event handling complete"))
            .subscribe();
  }
  
}
