package hello.utils;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HelloController {

    boolean output = true;

    public void mute() {
        this.output = false;
    }

    public String index() {
        return "Greetings from Spring Boot! "+this;
    }

    public void log(String msg) {
        if (output) System.out.println(msg);
    }

}