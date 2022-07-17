package pl.piomin.samples.spring.graphql.resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PingResolver {

    /*
    {
      pingHelloWorld
    }
     */
    @QueryMapping
    public String pingHelloWorld() {
        return "Hello WORLD";
    }

    /*
    {
      pingMessage(message: "test")
    }
    OR
    query PING_MESSAGE($message: String!) {
      pingMessage(message: $message)
    }

     */
    @QueryMapping
    public String pingMessage(@Argument String message) {
        return "Hello " + message;
    }

    /*
    mutation pingMutation($message: String!) {
      pingMutation(message: $message)
    }
     */
    @MutationMapping
    public String pingMutation(@Argument String message) {
        return "Example Mutation Text: " + message;
    }

}
