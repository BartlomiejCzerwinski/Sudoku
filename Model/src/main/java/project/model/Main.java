package project.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("log1");
        logger.error("log2");
        logger.info("log log3");
    }
}
