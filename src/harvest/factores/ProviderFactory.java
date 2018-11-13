package harvest.factores;

import harvest.abstracts.Provider;
import harvest.providers.PressureProvider;
import harvest.providers.SolarProvider;

import java.util.List;

public class ProviderFactory {
    public Provider createProvider(List<String> arguments){
        String type = arguments.get(0);
        type = type.toLowerCase();
        String id = arguments.get(1);
        double oreOutput = Double.parseDouble(arguments.get(2));

        switch (type){
            case "solar":
                return new SolarProvider(id,oreOutput);
            case "pressure":
                return new PressureProvider(id,oreOutput);
                default:
                    throw new IllegalArgumentException("Invalid Provider");
        }
    }
}
