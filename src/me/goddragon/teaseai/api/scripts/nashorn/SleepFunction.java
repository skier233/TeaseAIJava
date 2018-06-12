package me.goddragon.teaseai.api.scripts.nashorn;

import me.goddragon.teaseai.TeaseAI;
import me.goddragon.teaseai.utils.TeaseLogger;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * Created by GodDragon on 14.04.2018.
 */
public class SleepFunction extends CustomFunction {

    public SleepFunction() {
        super("sleep");
    }

    @Override
    public boolean isFunction() {
        return true;
    }

    @Override
    public Object call(Object object, Object... args) {
        super.call(object, args);

        if(args.length <= 0) {
            TeaseLogger.getLogger().log(Level.SEVERE, "Called " + getFunctionName() + " method without parameters.");
            return null;
        }

        if(args[0] instanceof Integer || args[0] instanceof Double || args[0] instanceof Long) {
            TeaseAI.application.sleepPossibleScripThread(Math.round(1000L * Double.valueOf(args[0] + "")));
            return null;
        } else {
            TeaseLogger.getLogger().log(Level.SEVERE, getFunctionName() + " called with invalid args:" + Arrays.asList(args).toString());
            return null;
        }
    }
}
