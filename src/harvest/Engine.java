package harvest;

import harvest.busneslogic.DraftManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    private DraftManager manager;

    public Engine() {
        this.manager = new DraftManager();
    }

    public void run() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!input.equalsIgnoreCase("shutdown")) {
            List<String> arguments = new ArrayList<>();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            for (int i = 1; i < tokens.length; i++) {
                arguments.add(tokens[i]);
            }
            switch (command){
                case "RegisterHarvester":
                    System.out.println(manager.registerHarvester(arguments));
                    break;
                case "RegisterProvider":
                    System.out.println(manager.registerProvider(arguments));
                    break;
                case "Day":
                    System.out.println(manager.day());
                    break;
                case "Mode":
                    System.out.println(manager.mode(arguments));
                    break;
                case "Check":
                    System.out.println(manager.check(arguments));
                    break;
                    default:break;

            }

            input = br.readLine();
        }
        System.out.println(manager.shutDown());
    }
}
