package com.agos;

import org.kie.api.executor.Command;
import org.kie.api.executor.CommandContext;
import org.kie.api.executor.ExecutionResults;
import org.kie.api.runtime.process.WorkItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class AsyncCommand implements Command {
    private static final Logger log = LoggerFactory.getLogger(AsyncCommand.class);

    public ExecutionResults execute(CommandContext ctx) throws Exception {
        Boolean delayCompleted = (Boolean)((WorkItem) ctx.getData("workItem")).getParameter("delayCompleted");
        log.info("DelayCompleted Flag[{}]", delayCompleted);
        log.info("Delay Started");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<String,Object> output = new HashMap<String,Object>();
        output.put("delayCompleted",true);
        log.info("DelayCompleted Flag[{}]",true);

        ExecutionResults results = new ExecutionResults();
        results.setData(output);

        return results;
    }
}
