package app;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.TxRunnable;
import models.entity.Check;
import org.avaje.agentloader.AgentLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by nobesawa on 15/07/05.
 */
public class Main {

    protected static Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        someApplicationBootupMethod();

        AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1");
        Ebean.beginTransaction();
        try {
            Check check = new Check();
            String name = "aaaasakuro";
            String result = "oooo";
            Date created = new Date();
            Date modified = new Date();
            check.setName(name)
                    .setResult(result)
                    .setCreted(created)
                    .setModified(modified);
            Ebean.save(check);
        } catch (Exception e) {
            Ebean.rollbackTransaction();
            throw new RuntimeException();
        } finally {
            Ebean.endTransaction();
        }

    }

    public static void someApplicationBootupMethod() {
        // Load the agent into the running JVM process
        if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent", "debug=1;packages=models.entity.**")) {
            logger.info("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
        }
    }
}
