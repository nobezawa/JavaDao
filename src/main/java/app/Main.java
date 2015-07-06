package app;

import com.avaje.ebean.Ebean;
import models.entity.Check;
import org.avaje.agentloader.AgentLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nobesawa on 15/07/05.
 */
public class Main {

    protected static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Check check = new Check();

        someApplicationBootupMethod();


        int id = 1;
        String name = "sakuro";
        Date created = new Date();
        Date modified = new Date();
        check.setId((long) id);
        check.setName(name);
        check.setCreted(created);
        check.setModified(modified);
        Ebean.save(check);
    }

    public static void someApplicationBootupMethod() {
        // Load the agent into the running JVM process
        if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1;packages=org.example.model.**")) {
            logger.info("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
        }
    }
}
