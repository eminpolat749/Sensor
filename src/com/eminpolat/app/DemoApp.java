package com.eminpolat.app;

import com.eminpolat.sensor.Sensor;
import com.eminpolat.util.console.Console;
import com.eminpolat.util.thread.ThreadUtil;

import java.io.IOException;

public class DemoApp {
    public static void run()
    {
        while (true) {
            try (Sensor sensor = new Sensor("www.csystem.org:50500")) {
                Console.writeLine("------------------------------------------------------");
                sensor.doWork();
                Console.writeLine("------------------------------------------------------");
            }
            catch (IllegalArgumentException ignore) {
                Console.writeLine("Invalid URL!...");
            }
            catch (IllegalStateException ignore) {
                Console.writeLine("Connection problem occurs!...");
            }
            catch (IOException ignore) {
                Console.writeLine("Problem in IO operations!...");
            }

            ThreadUtil.sleep(1000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}